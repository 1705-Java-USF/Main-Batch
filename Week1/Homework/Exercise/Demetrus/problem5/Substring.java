/* Demetrus Atkinson
 * 
 */
package com.revature.problem5;

import java.util.Scanner;

public class Substring {

	public static void main(String[] args) {

		// get string (everything before a carriage return) from user
		Scanner scannerStr = new Scanner(System.in);
		System.out.print("Enter string: ");
		String s = scannerStr.nextLine();

		// get index from user
		Scanner scannerInt = new Scanner(System.in);
		System.out.print("Enter index: ");
		int idx = scannerInt.nextInt();
		
		getSubstring(s, idx); // call to get substring with string and
								// index
	}

	static String getSubstring(String str, int idx) {
		System.out.print("Substring: ");
		// print substring from 0 to idx-1 (inclusive)
		for (int i = 0; i <= idx - 1; i++) {
			System.out.print(str.charAt(i));
		}
		// return substring
		return str;
	}
}
