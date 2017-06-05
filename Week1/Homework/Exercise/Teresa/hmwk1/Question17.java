package com.revature.hmwk1;

import java.util.Scanner;

public class Question17 {
	/* Q17. Write a program that calculates interest on principal, rate, and years provided by the user
	* Enter principal, rate and time through the console using the Scanner class
	* Interest = Principal* Rate* Time
	*/
	
	// create variables 
	private int principal;
	private int rate;
	private int time;
	
	public Question17() {
		// create scanner object
		Scanner input = new Scanner(System.in);
		System.out.println("Enter principal: ");
		principal = input.nextInt();
		System.out.println("Enter rate of interest: ");
		rate = input.nextInt();
		System.out.println("Enter number of years: ");
		time = input.nextInt();
		System.out.println("Simple Interest: " + (principal*rate*time));
	}
	
}
