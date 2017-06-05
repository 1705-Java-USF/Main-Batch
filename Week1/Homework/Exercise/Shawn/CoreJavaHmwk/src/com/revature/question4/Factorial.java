package com.revature.question4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int factorial;
		
		while(true) {
			try {
				// Define N to be used in calculating N factorial.
				System.out.print("Define N for N factorial: ");
				factorial = scan.nextInt();
				break;	// If number (int), break. Otherwise, ask user to enter a number (int).
			} catch(InputMismatchException e) {
				System.out.println("Please enter a number.\n");
				scan.nextLine();	//consume
			}
		}
		
		scan.close();

		// Multiply current factorial value with next factorial.
		for (int i = factorial; i > 1; i--) {
			factorial *= (i - 1);
		}
		
		System.out.println(factorial);
	}
}
