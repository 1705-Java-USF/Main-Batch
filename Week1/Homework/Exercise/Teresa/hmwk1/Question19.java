package com.revature.hmwk1;

import java.util.ArrayList;

public class Question19 {
	/* 
	 * Q19. Create an ArrayList and insert integers 1 through 10
	 * Display the ArrayList
	 * Add all the even numbers up and display the result 
	 * Add all the odd numbers up and display the result 
	 * Remove the prime numbers from the ArrayList and print out the remaining ArrayList 
	 */
	
	// create variables
	final int NUM = 10;
	private ArrayList<Integer> a;
	private int evenCount, oddCount;

	public Question19() {
		a = new ArrayList<Integer>();
		// create arraylist with integers 1 to 10
		for (int i = 1; i <= NUM; i++) {
			a.add(i);
		}
		// get even and odd count
		for (int i : a) {
			if (i%2 == 0) {
				evenCount++;
			} else {
				oddCount++;
			}
		}
		// print results
		print();
		printEven();
		printOdd();
		removePrime();
		print();
	}
	
	private void removePrime() {
		// using prime method from question 9 to determine 
		// prime numbers and remove them from list
		int count = 1;
		while (count < a.size()) {
			int i = a.get(count);
			if (i > 2) {
				boolean prime = true;
				for (int j = 2; j < i; j++) {
			        if (i%j == 0) {
			        	prime = false;
			        	count++;
			        	break;
			        }
			    }
				if (prime) {
					a.remove(count);
				}
			} else {
				a.remove(count);
			}
		}
	}

	private void printOdd() {
		System.out.println(oddCount + " odd numbers");
	}

	private void printEven() {
		System.out.println(evenCount + " even numbers");
	}

	public void print() {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
}
