package com.revature.question_15;

public class ImplementingClass implements BasicOperationsI {

	@Override
	public int addition(int num1, int num2) {
		return num1 + num2;
	}

	@Override
	public int subtraction(int num1, int num2) {
		return num1 - num2;
	}

	@Override
	public int multiplication(int num1, int num2) {
		return num1 * num2;
	}

	@Override
	public int division(int num1, int num2) {
		return num1 / num2;
	}
}