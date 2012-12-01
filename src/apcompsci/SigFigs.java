package apcompsci;

import java.util.Scanner;
/**
 *
 * @author Dwu2
 */
public class SigFigs {
    char[] numChar;
    
    public SigFigs(String s) {
        numChar = s.toCharArray();
    }
    
    public int calculateSigFigs() {
        int n = 0, index = 0, trailingZeroCount = 0;
        boolean pastDecimalPoint = false, trailingZero = false, startingZero = (numChar[0] == '0');
        
        while(index < numChar.length) {
            if(!pastDecimalPoint) {
                if(numChar[index] == '.') {
                    n += trailingZeroCount;
                    trailingZeroCount = 0;
                    
                    if(index < numChar.length - 1) {
                        startingZero = (numChar[index + 1] == '0');
                    }
                    
                    pastDecimalPoint = true;
                }
                else if(numChar[index] == '0') {
                    if(!startingZero) {
                        trailingZeroCount++;
                        trailingZero = true;
                    }
                }
                else {
                    if(startingZero) {
                        startingZero = false;
                    }
                    
                    n++;
                    n += trailingZeroCount;
                    trailingZeroCount = 0;
                    trailingZero = false;
                }
            }
            else {
                if(numChar[index] == '0') {
                    if(!startingZero) {
                        trailingZeroCount++;
                        trailingZero = true;
                    }
                }
                else {
                    if(startingZero) {
                        startingZero = false;
                    }
                    
                    n++;
                    n += trailingZeroCount;
                    trailingZeroCount = 0;
                    trailingZero = false;
                }
            }
            
            index++;
        }
        
        return n;
    }

    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);

	System.out.println("Please enter a floating point value to calculate the significant figures of: ");

	SigFigs sf = new SigFigs(input.nextLine());

	System.out.println("Amount of sigfigs: " + sf.calculateSigFigs());

    }
}
