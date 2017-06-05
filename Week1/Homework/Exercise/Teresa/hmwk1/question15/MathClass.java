package com.revature.hmwk1.question15;

public class MathClass implements MathInterface {
	// Create a class that implements this interface and provides 
	// appropriate functionality to carry out the required operations
	
	@Override
	public double addition(double a, double b) {
		return (a + b);
	}

	@Override
	public double subtraction(double a, double b) {
		return (a - b);
	}

	@Override
	public double multiplication(double a, double b) {
		return (a*b);
	}

	@Override
	public double division(double a, double b) {
		return (a/b);
	}

}
