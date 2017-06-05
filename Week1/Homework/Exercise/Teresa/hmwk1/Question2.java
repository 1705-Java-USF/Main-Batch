package com.revature.hmwk1;

public class Question2 {
	// Q2. Write a program to display the first 25 Fibonacci numbers
	
	final private int SIZE = 25;
	
	public Question2() {
		fibbNumbers();
	}
	
	protected void fibbNumbers() {
		// A Fibonacci number is the sum of the two values that came before it,
		// starting with 0 and 1
		int[] numbers = new int[SIZE];
		numbers[0] = 0;
		numbers[1] = 1;
		for (int i = 2; i < SIZE; i++) {
			numbers[i] = numbers[i-1] + numbers[i-2];
		}
		// print first 25 Fibonacci numbers
		for (int j = 0; j < SIZE; j++) {
			System.out.print(numbers[j] + " ");
		}
		System.out.print("\n");
	}

}
