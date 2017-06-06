package com.revature.q14;

import java.util.Date;
import java.util.Scanner;

public class SwitchCases {

	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String text = "Write a program that demonstrates the switch case. Implement the following "
				+ "functionalities in the cases:"
				+ "Case 1: Find the square root of a number using the Math class method."
				+ "Case 2: Display today’s date."
				+ "Case 3: Split the following string and store it in a string array."
				+ "		“I am learning Core Java”";

		System.out.println(text);

		int option = 0;
		String str = "I am learning Core Java";
		
		System.out.print("Choose one of the options (1 - 3) >> ");
		option = input.nextInt();                   // accepts input
		
		switch (option)   // switch case
		{
			case 1:	squareRoot();  // cases all have their own methods
					break;
			case 2: displayDate();
					break;
			case 3: splitString(str);
					break;
			default: System.out.println("Invalid input");
					break;
		}

	}
	static void squareRoot()    // asks for input, takes the square root of it, and displays it on console
	{
		System.out.print("Input a number to take square: ");
		double x = input.nextDouble();
		System.out.println("Square root is: " + Math.sqrt(x));
	}
	
	static void displayDate()   // displays date
	{
		Date date = new Date();
		System.out.println("Date: " + date.toString());
	}
	
	static void splitString(String str)   // uses the .split to put string 'str' in the strArray whenever there's a space
	{
		String strArray[] = str.split(" ");
		
		for (int i = 0; i < strArray.length; i++)   // displaying the strArray
		{
			System.out.print(strArray[i] + " ");
		}
	}
}
