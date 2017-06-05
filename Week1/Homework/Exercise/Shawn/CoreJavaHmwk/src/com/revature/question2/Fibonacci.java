package com.revature.question2;

public class Fibonacci {

	public static void main(String[] args) {
		int fib = 0; // Initialized starting value.
		int fib2 = 1; // Second number in sequence.
		final int limit = 25; // First X Fibonacci numbers.

		for (int i = 0; i < limit; i++) {
			System.out.println(fib);
			fib = fib + fib2; // Add the 1st and 2nd in sequence together.
			fib2 = fib - fib2; // Subtract 2nd from 1st to help calculate next fib value.
		}
	}
}
