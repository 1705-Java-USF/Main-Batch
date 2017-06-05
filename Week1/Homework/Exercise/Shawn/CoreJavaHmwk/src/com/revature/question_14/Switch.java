package com.revature.question_14;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Switch {
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		int num;												// Number used for switch conditional.
		
		while(true) {
			try {
				System.out.print("1, 2, or 3: ");				// Ask user which switch case.
				num = scan.nextInt();
				if(num == 1 || num == 2 || num == 3)
					break;										// If number is 1, 2, or 3, break.
			} catch(InputMismatchException e) {	}				// Otherwise, ask user to enter a number.
			System.out.println("Please enter 1, 2, or 3.\n");
			scan.nextLine();									// Consume
		}
		
		switch(num) {
			case 1:												// SquareRoot a number.
				squareRoot();
				break;
			case 2:												// Today's Date.
				System.out.println(LocalDate.now());
				break;
			case 3:												// Split String into String array.
				splitString();
				break;
		}
		scan.close();
	}
	
	private static void squareRoot() {
		int num;												// Number to square root.
		while(true) {
			try {		
				System.out.print("Number to square root: ");	// Ask user for number to square root.
				num = scan.nextInt();
				break;											// If number (int), break.
			} catch(InputMismatchException e) {					// Otherwise, ask user to enter a number (int).
				System.out.println("Please enter a number.\n");
				scan.nextLine();								// Consume
			}
		}
		System.out.println(Math.sqrt(num));
	}
	
	private static void splitString() {
		final String splitThis = "I am learning Core Java";
		String[] stringArray = splitThis.split("");				// Split the string into array.
		for(String s : stringArray) {
			System.out.println(s);
		}
	}
}
