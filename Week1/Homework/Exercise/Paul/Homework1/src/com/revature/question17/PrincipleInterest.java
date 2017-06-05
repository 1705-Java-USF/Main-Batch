package com.revature.question17;


import java.util.InputMismatchException;
import java.util.Scanner;

public class PrincipleInterest {

	private static Scanner scan;

	public static void main(String[] args) {
		
		/*
		 * try-catch block to throw an exception when user 
		 * enters anything besides a number
		 */
		try{
		scan = new Scanner(System.in);
		System.out.println("Please Enter the Principle Amount: ");
		float principle = scan.nextFloat();
		
		System.out.println("Please Enter the Time of Interest: ");
		float time = scan.nextFloat();
		
		System.out.println("Please Enter the Rate of Interest: ");
		float rate = scan.nextFloat();

		//Calls method to calculate the Simple Interest based 
		//off of user input. 
		float interest = simpleInterest(principle,time ,rate);	
		
		System.out.println("The Simple Interest Rate is: " + interest);
		
		}catch(InputMismatchException e){//error message if a number was not entered
			e.printStackTrace();
			System.err.println("Please Enter a Number!");
		}
		
	}
	
	//static method to calculate the simple interest for 
	//given principle amount, interest rate, and time on interest 
	private static float simpleInterest(float principle, float time, float rate) {
		float interest = (principle * rate * time) / 100; 
		return interest;
	}

}
