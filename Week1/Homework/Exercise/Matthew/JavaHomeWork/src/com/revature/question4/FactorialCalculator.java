package com.revature.question4;

public class FactorialCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(factorial(5));
	}

	/*
	 * A factorial of n is defined by the product of every number from 1 to n
	 */
	public static int factorial(int n) {
		int result = 1;
		for (int i = 2; i <= n; i++) // starting at 2 saves a step as 1 * 1 = 1
		{
			result *= i;
		}
		return result;
	}

}
