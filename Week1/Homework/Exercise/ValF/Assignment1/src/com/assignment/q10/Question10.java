package com.assignment.q10;

import java.util.Scanner;

public class Question10 
{

	public static void main(String[] args) 
	{
		/*Varibales: scan vairable to read in user input, two integer varibles to hold
		 * both numbers to be compared 
		 */
		Scanner scan = new Scanner(System.in);
		int num1, num2;
		
		//Prompt and input first number
		System.out.print("Input first number: ");
		num1 = scan.nextInt();
		
		//Prompt and input second number
		System.out.print("Input second number: ");
		num2 = scan.nextInt();
		
		//Display inputed numbers
		System.out.println("You entered " + num1 + " and " + num2);
		
		//Calculate and display larger number
		System.out.println((num1 < num2) ? num2 : num1 + " is the larger number.");
		
		//Close scanner
		scan.close();
	}

}
