package com.revature.day3;

import java.util.Scanner;

public class ScannerExample {

	public static void main(String[] args) {
		/*
		 * Scanner is a class used to parse Strings.
		 * e.g. parse numbers/letter/etc from strings easily.
		 * 
		 * Most commonly used for user input in console applications.
		 * By default, it delimits by ' ' <-(space)
		 */
		
		//System.in provides a inputStream that takes user input.
		Scanner scan = new Scanner(System.in);
		
		//All we did up to this is create the scanner.
		//Scanner only begins to scan, when you invoke a command.
		
		System.out.println("Please input a number!");
		
		//nextInt() parses the first number it finds out of a String

		String s = scan.nextLine();
		System.out.println(s);
		
		
		
	}

}
