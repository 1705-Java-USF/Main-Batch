package com.revature.question19;

import java.util.ArrayList;

public class ArrayListOps {

	public static int sumOfEvenNumbers(ArrayList<Integer> al) {
		int sum = 0;
		for (int i : al) {
			if (MathUtil.isEven(i)) { // loop through numbers checking if number
										// is even
				sum += i; // If the number is even add it to the total
			}
		}
		return sum;
	}

	public static int sumOfOddNumbers(ArrayList<Integer> al) {
		int sum = 0;
		for (int i : al) {
			if (!MathUtil.isEven(i)) { // Same as above but negate the result of
										// isEven so only odd numbers are added
				sum += i;
			}
		}
		return sum;
	}

	public static void removePrimeNumbers(ArrayList<Integer> al) {
		for (int i = 0; i < al.size(); i++) {
			if (MathUtil.isPrime(al.get(i))) { // Check if number is prime
				al.remove(i); // If the number is prime remove the element
				i--; // Adjust the index so that it doesn't skip any numbers
			}
		}
	}
}
