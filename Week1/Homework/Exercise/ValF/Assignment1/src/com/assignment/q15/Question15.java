package com.assignment.q15;

public class Question15 implements MathStuff{

	public static void main(String[] args) 
	{
		//Variables: two hard coded integer values
		Question15 d = new Question15();
		int num1 = 10,  num2 = 20;
		
		//Display original values
		System.out.println("Original values: " + num1 + " and " + num2);
		
		//Test addition
		System.out.println("Addition returns: " + d.addition(num1, num2));
		
		//Test subtraction
		System.out.println("Subtraction returns: " + d.subtraction(num1, num2));
		
		//Test multiplication 
		System.out.println("Multiplication returns: " + d.multiplicaton(num1, num2));
		
		//Test division
		System.out.println("Division returns: " + d.division(num1, num2));
		
	}

	
	//Return addition of x and y
	@Override
	public int addition(int x, int y) 
	{
		return (x + y);
	}

	//Return subtraction of x and y
	@Override
	public int subtraction(int x, int y) 
	{
		return (x - y);
	}

	//Return division of x and y
	@Override
	public int division(int x, int y) 
	{
		return (x / y);
	}
	
	//Return multiplication of x and y
	@Override
	public int multiplicaton(int x, int y) 
	{
		return (x * y);
	}

}
