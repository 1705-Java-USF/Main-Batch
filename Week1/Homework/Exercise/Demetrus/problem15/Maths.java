package com.revature.problem15;

public class Maths implements MathOperations { // concrete Maths class must
												// implement all methods from
												// the MathOperations interface

	public static void main(String[] args) {
		// generate random number (1-1000) so different values can be compared
		int a = (int) (Math.random() * ((1000 - 1) + 1)) + 1;
		int b = (int) (Math.random() * ((1000 - 1) + 1)) + 1;

		// Make a Maths object to access MathOperations methods
		Maths ma = new Maths();

		// print what values are being used for the math operations
		System.out.println("a: " + a);
		System.out.println("b: " + b);

		// calls to the implementing methods
		ma.addition(a, b);
		ma.subtraction(a, b);
		ma.multiplication(a, b);
		ma.division(a, b);
	}

	@Override
	public void addition(int a, int b) { // print out total from addition
		System.out.println("Addition: a + b = " + (a + b));

	}

	@Override
	public void subtraction(int a, int b) { // print out total from subtraction
		System.out.println("Subtraction: a - b = " + (a - b));

	}

	@Override
	public void multiplication(int a, int b) { // print out total from
												// multiplication
		System.out.println("Mutiplication: a * b = " + (a * b));

	}

	@Override
	public void division(int a, int b) { // print out total from division
		System.out.println("Division: a / b = " + (a / b));

	}

}
