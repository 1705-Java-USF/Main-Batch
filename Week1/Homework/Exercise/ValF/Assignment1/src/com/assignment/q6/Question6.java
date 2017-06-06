package com.assignment.q6;

import java.util.Scanner;

public class Question6 
{
	//Method to determine if number is even or odd
	public static String evenOrOdd(int num)
	{	
		if(num == 0)//Is zero even or odd?
			return "Is zero even or odd? I'm not a math major..";
		if(((num / 2) * 2) == num)
			return "Even";
		else
			return "Odd";
			
	}

	public static void main(String[] args) 
	{
		//Varibles: integer to hold user input
		int num;
		Scanner scan = new Scanner(System.in);
		
		//Prompt user input
		System.out.print("Enter a number: ");
		num = scan.nextInt();
		
		//Call even or odd method
		System.out.println(evenOrOdd(num));
	}

}
