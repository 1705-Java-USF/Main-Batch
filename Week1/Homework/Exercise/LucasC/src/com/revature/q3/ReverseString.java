package com.revature.q3;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		System.out.println("Reverse a string without using a temporary variable.  Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.");
		System.out.println("Enter a string to reverse:");
		String str = input.nextLine(); 
		
		System.out.println("String: " + str);
		
		System.out.print("String.1: ");
		for (int i = str.length() - 1; i >= 0; i--)  // reading out the string's characters backwards. - cheating :P
		{
			System.out.print(str.charAt(i));
		}
			
		for (int i = str.length() - 1; i >= 0; i--)  // reading the string backwards again
		{
			str += str.charAt(i);     // add each character to the end of the string
		}
		str = str.substring(str.length()/2);  // cut the string in half
		
		System.out.println("\nString.2: " + str);

		input.close();
	}
}
