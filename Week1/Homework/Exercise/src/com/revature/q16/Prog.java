package com.revature.q16;

public class Prog {

	public static void main(String[] args) {
		//Write a program to display the number of characters 
		//for a string input. The string should be entered as a 
		//command line argument using (String [ ] args).
		
		for(int i = 0; i < args.length; i++){
			//prints the argument and the length of the string
			System.out.println(args[i] + ":\t" + args[i].length());
		}
	}
}
