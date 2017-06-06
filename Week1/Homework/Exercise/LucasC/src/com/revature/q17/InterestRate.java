package com.revature.q17;

import java.util.*;

public class InterestRate {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		String text = "Write a program that calculates the simple interest on the principal,"
				+ " rate of interest and number of years provided by the user. Enter principal, "
				+ "rate and time through the console using the Scanner class." 
				+ "Interest = Principal* Rate* Time";
		System.out.println(text);
		
		double principal = 0;   // initialized all the variables needed
		double intRate = 0;
		double timeInYears = 0;
		double interest = 0;
		
		System.out.print("Please input your principal rate: ");  // ask for 3 number inputs, and store them all to different variables
		principal = input.nextDouble();
		System.out.print("Please input your rate of interest: ");
		intRate = input.nextDouble();
		System.out.print("Please input the amount of years: ");
		timeInYears = input.nextDouble();
		
		interest = (principal * intRate * timeInYears);   // multiply the 3 numbers
		System.out.println("Your interest is: " + interest);  // display it
		
		input.close();

	}

}
