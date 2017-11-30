/**
 * Author: Hunter Allen (jhallen3@crimson.ua.edu)
 * 
 * Class Description: A simple class containing tools that may need
 * 					  to be used in many parts of the program.
 */

package team11project4.tools;

import java.util.Random;

public class NumberGenerator {
	
	/**
	 * Returns a random 9-digit string to be used for member or provider numbers.
	 * 
	 * @return	A string representing the 9-digit number for the member or provider
	 */
	public static String generateNumber() {
		
		Random rand = new Random();
		
		int number = 0;
		int digit = 1;
		
		for (int i = 0; i < 9; i++) {
			digit = digit * 10;
			int randNum = rand.nextInt(10);
			number = randNum * digit;
		}
		
		return (Integer.toString(number));
		
	}

}
