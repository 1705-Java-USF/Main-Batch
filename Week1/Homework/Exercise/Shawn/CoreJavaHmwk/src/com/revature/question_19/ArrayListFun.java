package com.revature.question_19;

import java.util.ArrayList;
import java.util.List;

public class ArrayListFun {
	private static int even = 0;
	private static int odd = 0;

	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>();
		
		add1Through10To(arr);
		displayList(arr);

		for (int i : arr) {
			checkEven(i);	// Check if num is even. If yes, add to global 'even'.
			checkOdd(i);	// Check if num is odd. If yes, add to global 'odd'.
		}

		arr = convertToListOfPrimeNumbers(arr);
		
		System.out.println("\nEven numbers added: " + even);
		System.out.println("Odd numbers added: " + odd);
		
		displayList(arr);
	}

	private static void add1Through10To(List<Integer> arr) {
		for (int i = 1; i <= 10; i++)
			arr.add(i);
	}

	private static void displayList(List<Integer> arr) {
		for (int i : arr)
			System.out.print(i + " ");
	}

	private static void checkEven(int i) {
		if (i % 2 == 0)
			even += i;
	}

	private static void checkOdd(int i) {
		if (i % 2 == 1)
			odd += i;
	}
	
	private static List<Integer> convertToListOfPrimeNumbers(List<Integer> arr) {
		List<Integer> remove = new ArrayList<>();
		
		// Add all prime to separate list.
		// Removing here causes ConcurrentModificationException.
		for (int i : arr) {
			if (isPrime(i))
				remove.add(i);
		}
		
		// Clear and then replace arr with all prime numbers.
		arr.clear();
		
		for (int i : remove) {
			arr.add(i);
		}
		return arr;
	}

	private static boolean isPrime(int i) {
		if(i <= 1)						// Prime >= 2
			return false;
		for (int j = 2; j < i; j++) {
			if (i % j == 0)				// If number ever divides evenly, it can't be prime.
				return false;
		}
		return true;
	}

}
