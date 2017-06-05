package com.revature.question17;

import java.io.PrintStream;
import java.util.Scanner;

public class Console {
	private Scanner input;
	private PrintStream output;
	double principal;
	double rate;
	double time;

	public Console() {
		input = new Scanner(System.in);
		output = System.out;

	}

	public void reportResult(String message, double result) {
		output.println(message + result);
	}

	public void getUserInput() {
		principal = getDouble("Please enter the principal", "Invalid Number format"); 
		rate = getDouble("Please enter the rate", "Invalid Number format");
		time = getDouble("Please enter the time", "Invalid Number format");

	}

	public double getPrincipal() {
		return principal;
	}

	public double getRate() {
		return rate;
	}

	public double getTime() {
		return time;
	}
	
	/*
	 * getDouble prompts the user to enter a double with a custom message and error message in case
	 * the input is invalid
	 */

	private double getDouble(String message, String errorMessage) {
		boolean needInput = true; 
		double result = 0;
		while (needInput) {
			output.println(message);
			try {
				result = Double.parseDouble(input.nextLine());
				needInput = false;
			} catch (NumberFormatException e) {
				output.println(errorMessage);
			}
		}
		return result;

	}
}
