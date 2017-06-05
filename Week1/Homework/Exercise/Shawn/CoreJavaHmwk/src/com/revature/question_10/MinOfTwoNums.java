package com.revature.question_10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MinOfTwoNums {
	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("===Find the Minimum Between Two Numbers");
		
		final int num1 = userNum1();
		final int num2 = userNum2();
		
		// Print the lowest number (btwn num1 and num2).
		System.out.println(num1 < num2 ? num1 : num2);
	}
	
	private static int userNum2() {
		while(true) {
			System.out.print("2nd number: ");
			try {
				return scan.nextInt();								// If user enters number, return.
			} catch(InputMismatchException e) {						// Otherwise, have them enter a number.
				System.out.println("Please enter a number.\n");
				scan.nextLine();									// Consume.
			}
		}
	}

	private static int userNum1() {
		while(true) {
			System.out.print("1st number: ");
			try {
				return scan.nextInt();								// If user enters number, return.
			} catch(InputMismatchException e) {						// Otherwise, have them enter a number.
				System.out.println("Please enter a number.\n");
				scan.nextLine();									// Consume.
			}
		}
	}
}