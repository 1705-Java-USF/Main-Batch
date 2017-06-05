package com.revature.hmwk1;

public class Question16 {
	// Q16. Write a program to display the number of characters for a string input
	// The string should be entered as a command line argument using (String [ ] args)
	public static int count;

	public static void main(String[] args) {
		// get character count for all strings entered
		// for loop created for one or mulitple words entered since not specified
		count = 0;
		for (int i = 0; i < args.length; i++) {
			count += args[i].length();
		}
		System.out.println(count);
	}

}
