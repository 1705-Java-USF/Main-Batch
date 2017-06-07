/* Demetrus Atkinson
 * 
 */
package com.revature.problem16;

public class NumberOfCharacters {

	public static void main(String[] args) {
		// count number of characters in a string
		int count = 0;
		System.out.print("The string ");
		for (int i = 0; i < args.length; i++) {
			// loop to find out how many characters are in a string
			// the count will be that length (excluding spaces)
			for (int j = 0; j < args[i].length(); j++) {
				// count each character processed
				count++;
			}
			// print argument(s)
			System.out.print(args[i] + " ");
		}

		// final tally of characters
		System.out.println("has " + count + " letters (excluding spaces).");
	}
}