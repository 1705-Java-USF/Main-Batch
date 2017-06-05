package com.revature.question_15;

public class Driver {

	public static void main(String[] args) {
		final int num1 = 4;
		final int num2 = 7;
		
		ImplementingClass operations = new ImplementingClass();
		
		System.out.println(num1 + " + " + num2 + " = " + operations.addition(num1, num2));			// Add 2 numbers.
		System.out.println(num1 + " - " + num2 + " = " + operations.subtraction(num1, num2));		// Subtract 2 numbers.
		System.out.println(num1 + " * " + num2 + " = " + operations.multiplication(num1, num2));	// Multiply 2 numbers.
		System.out.println(num1 + " / " + num2 + " = " + operations.division(num1, num2));			// Divide 2 numbers.
	}
}
