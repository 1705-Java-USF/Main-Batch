package com.assignment.q4;

import java.util.Scanner;

public class Question4 
{
	//Recursive function to compute factorial
	public static int fac(int i)
	{
		//Base cases
		if(i == 0)
			return 1;
		if(i == 1)
			return 1;
		else
			return fac(i-1) * i; //Recursive computation
	}

	public static void main(String[] args) 
	{
		int num; //variable to hold N
		
		//Prompt user for N
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a numer: ");
		num = scan.nextInt();
		
		//Call frac function & print result
		System.out.println("The factorial of " + num + " is " + fac(num));
	}
	
}
