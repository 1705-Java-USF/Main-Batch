package com.revature.q5;

import java.util.Scanner;

public class SubstringMethod {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		String text = "Write a substring method that accepts a string str and and "
				+ "integer idx and returns the substring contained between"
				+ "0 and idx-1 inclusive.  Do NOT use any of the existing substring"
				+ "methods in the String, StringBuilder, or StringBuffer APIs.";
		System.out.println(text);
				
		System.out.print("Input a string: ");  // asking for input
		String str = input.nextLine();
		
		int idx = str.length(); 
		
		substringMethod(idx, str);  // calling substring method
		
		input.close();
	}
	
	static void substringMethod(int idx, String str)     //method which prints all the chars out expect for the last one
	{
		for (int i = 0; i < idx - 1; i++)    // s
		{
			System.out.print(str.charAt(i));
		}
	}

}
