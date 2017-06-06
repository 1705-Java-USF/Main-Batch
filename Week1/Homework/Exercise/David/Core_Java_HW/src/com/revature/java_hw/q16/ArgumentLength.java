package com.revature.java_hw.q16;

public class ArgumentLength {

	public static void main(String[] args) {
		//Check that an argument was provided.
		if(args.length > 0) {
			//args[0] is a String, so .length() gives the number of characters
			System.out.print("The string " + args[0] + " has " + args[0].length() + " characters.");
		} else {
			System.out.println("No arguments provided.");
		}
	}
}
