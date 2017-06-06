package com.revature.q10;

import java.util.Scanner;

public class TernaryOperators {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in); // scanner for input

		int x = 0; // declaring variables
		int y = 0;
		int result = 0;

		System.out.println("Find the minimum of two numbers using ternary operators.");

		System.out.print("Input first number: ");
		x = input.nextInt(); // asking for input

		System.out.print("Input second number: ");
		y = input.nextInt(); // asking for another input

		result = (x < y) ? x : y; // ternary operator which checks which number
									// is smaller, and sets that number to a
									// third variable "result"
		System.out.println("Minimum of the two: " + result);  // print out result

		input.close();  // close scanner
	}

}
