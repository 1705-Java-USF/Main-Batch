package com.revature.java_hw.q3;

import java.util.Scanner;

public class ReverseString {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a string to be reversed.");
		
		//Read in and store a String
		String s = scan.nextLine();
		
		//Loop through each character in the string starting at the end
		for(int i=s.length()-1; i>=0; i--) {
			//Add the current character to the end of the string
			s += s.charAt(i);
		}
		//Keep only the last half (the reversed string)
		s = s.substring(s.length()/2);
		
		//Print the result
		System.out.print("The reversed string is: ");
		System.out.println(s);
		
		scan.close();
	}
}
