/* Demetrus Atkinson
 * 
 */
package com.revature.problem3;

import java.util.Scanner;

public class reverse {

	public static void main(String[] args) {

		// user provides string
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter string: ");
		String s = scanner.nextLine();

		int x = 0; // counter for printing characters

		// print out original string and reversed string
		System.out.println("Original string: " + s);
		System.out.print("Reversed string: ");

		// cycle through array in reverse
		for (int i = s.length() - 1; i >= 0; i--) {
			// print each letter, x goes up while the array is going
			// in descending order so each letter can be printed
			System.out.print(s.charAt((s.length() - 1) - x++));
		}
	}
}
