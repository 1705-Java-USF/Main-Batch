package com.revature.hmwk1.question15;

public class Driver {
	// Q15. Write a program that defines an interface having the following methods: addition, subtraction, multiplication, and division
	// Create a class that implements this interface and provides appropriate functionality to carry out the required operations
	// Hard code two operands in a test class having a main method that calls the implementing class
	
	// create test values
	final static double A = 4.5;
	final static double B = 7.3;
	
	public static void main(String[] args) {
		MathClass mc = new MathClass();
		System.out.println( mc.addition(A, B) );
		System.out.println( mc.subtraction(B, A) );
		System.out.println( mc.multiplication(A, B) );
		System.out.println( mc.division(B, A) );
		
	}
}
