package com.revature.q15;

public class MainMathDriver {

	public static void main(String[] args) {
		
		String message = "Write a program that defines an interface having the following methods: "
				+ "addition, subtraction, multiplication, and division. "
				+ " Create a class that implements this interface and provides appropriate "
				+ "functionality to carry out the required operations. Hard code two operands in a"
				+ " test class having a main method that calls the implementing class.";
		System.out.println(message);
		
		double x = 4.5;  // hard coding two numbers
		double y = 2.5;
		
		MathInterface obj = new MathImplementation();  // creating a new object 
		
		obj.Addition(x, y);   // calling functions from interface (MathImplementation class) with numbers x , y
		obj.Subtraction(x, y);
		obj.Multiplication(x, y);
		obj.Division(x, y);
	}

}
