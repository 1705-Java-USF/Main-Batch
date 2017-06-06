package com.revature.q16;

public class StringChars {

	public static void main(String[] args) {

		String text = "Write a program to display the number of characters for a string input."
				+ " The string should be entered as a command line argument using (String [ ] args).";
		System.out.println(text);

		/*
		 * Click in the menu: run > run configurations >
		 * (click the arguments tab) > write arguments
		 * separated by 'space'
		 */
		int count = 0; 
		System.out.println("String size: "+ args.length); 
		for (int i = 0; i < args.length; i++) {
			System.out.print(args[i] + " ");
			count += args[i].length();
		}
		System.out.println("\nChars amount: " + count);
	}

}
