package com.revature.question5;

import java.util.Scanner;

public class Substring {

	public static void main(String[] args) {
		final Scanner scan = new Scanner(System.in);
		System.out.print("Enter a string to substring: ");
		final String input = scan.nextLine();
		scan.close();
		System.out.println(substring(input, 3));
	}
	
	// Parameters: String to pass in, char located after output stops.
	// Returns: Substring of str.
	private static String substring(String str, int idx) {
		char[] charArray = str.toCharArray();
		String substringOfString = "";
		
		// Iterate through each char index and add to string.
		for(int i = 0; i < idx; i++){
			substringOfString += charArray[i];
		}
		
		return substringOfString;
	}

}
