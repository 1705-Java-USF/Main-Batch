package com.revature.question_17;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Interest {
	final static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		final DecimalFormat df = new DecimalFormat(".##");
		double principal;
		double interestRate;
		int numOfYears;
		
		principal = userPrincipal();								// Get principal from user.
		interestRate = userInterestRate();							// Get interest rate from user.
		numOfYears = userNumOfYears();								// Get number of years from user.
		
		System.out.println("\nSimple Interest: $" + df.format((principal * interestRate * numOfYears)));
	}
	
	private static double userPrincipal() {
		while(true) {
			System.out.print("Principal: ");
			try {
				return scan.nextDouble();							// If user enters number, return.
			} catch(InputMismatchException e) {						// Otherwise, have them enter a number.
				System.out.println("Please enter a number.\n");
				scan.nextLine();									// Consume.
			}
		}
	}
	
	private static double userInterestRate() {
		while(true) {
			System.out.print("Interest Rate: ");
			try {
				return scan.nextDouble();							// If user enters number, return.
			} catch(InputMismatchException e) {						// Otherwise, have them enter a number.
				System.out.println("Please enter a number.\n");
				scan.nextLine();									// Consume.
			}
		}
	}
	
	private static int userNumOfYears() {
		while(true) {
			System.out.print("Number of Years: ");
			try {
				return scan.nextInt();								// If user enters number, return.
			} catch(InputMismatchException e) {						// Otherwise, have them enter a number.
				System.out.println("Please enter a number.\n");
				scan.nextLine();									// Consume.
			}
		}
	}
}
