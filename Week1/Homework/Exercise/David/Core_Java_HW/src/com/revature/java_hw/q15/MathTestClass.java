package com.revature.java_hw.q15;

public class MathTestClass {

	public static void main(String[] args) {
		//Hard-coded values for testing
		final double a = 3.5;
		final double b = 2;
		
		//Object containing the methods declared in MathInterface and defined in MathClass
		MathClass mc = new MathClass();
		
		//Test of each method
		System.out.println("Addition: " + a + " + " + b + " = " + mc.addition(a, b));
		System.out.println("Subtraction: " + a + " - " + b + " = " + mc.subtraction(a, b));
		System.out.println("Multiplication: " + a + " * " + b + " = " + mc.multiplication(a, b));
		System.out.println("Division: " + a + " / " + b + " = " + mc.division(a, b));
	}

}
