package com.revature.q15;

public class MathImplementation implements MathInterface {

	@Override
	public void Addition(double a, double b)
	{
		System.out.println("Adding both numbers: " + (a + b));
	
	}

	@Override
	public void Subtraction(double a, double b) {
		
		System.out.println("Subtracting both numbers: " + (a - b));
		
	}

	@Override
	public void Multiplication(double a, double b) {
		System.out.println("Multiplying both numbers: " + (a * b));
	}

	@Override
	public void Division(double a, double b) {
		System.out.println("Dividing a by b: " + (a / b));
	}
}

