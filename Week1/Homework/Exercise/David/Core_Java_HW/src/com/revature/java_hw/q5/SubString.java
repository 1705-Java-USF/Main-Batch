package com.revature.java_hw.q5;

import java.util.Scanner;

public class SubString {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a string.");
		//Read in and store a String
		String str = scan.nextLine();
		
		//Read in and store an integer
		int idx;
		do {
			System.out.println("Please enter idx, the number of characters to keep from the beginning of your string");
			while(!scan.hasNextInt()){
				scan.next();
			}
			idx = scan.nextInt();
			//Check if number entered is negative
			if(idx < 0) {
				System.err.println("Negative numbers are not valid.");
			}
			//Check if number entered is greater than the string's length
			else if (idx > str.length()) {
				System.err.println("Number provided is greater than the string's length.");
				idx = -1;
			}
		} while (idx < 0);
		//Print out the string returned
		System.out.println(subString(str, idx));
		scan.close();
	}
	
	//Returns the substring of str from 0 to idx-1 inclusive
	public static String subString(String str, int idx) {
		//Loop through each index from 0 to idx-1 and add the character to the resulting string.
		String result = "";
		for(int i=0; i < idx; i++) {
			result += str.charAt(i);
		}
		
		//returns the final result.
		return result;
	}

}
