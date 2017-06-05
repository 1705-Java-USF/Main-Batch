package com.revature.question3;

import java.util.Scanner;

public class ReverseString {
		
	public static void main(String[] args) {
		final Scanner scan = new Scanner(System.in);
		String stringToReverse;
		String reversedString = "";

		// Ask for string to reverse.
		System.out.print("Enter word or phrase that you want reversed: ");
		stringToReverse = scan.nextLine();
		scan.close();
		
		// Reverse by adding chars from String backwards.
		for(int i = stringToReverse.length() - 1; i >= 0; i--) {
			reversedString += stringToReverse.substring(i, i + 1);
		}
		
		System.out.println(reversedString);
	}

}
