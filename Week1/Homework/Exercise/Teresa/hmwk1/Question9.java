package com.revature.hmwk1;

import java.util.ArrayList;

public class Question9 {
	// Q9. Create ArrayList which stores numbers from 1 to 100 
	// and prints out all the prime numbers to the console
	private ArrayList<Integer> list;
	final int SIZE = 100;

	public Question9() {
		// create arraylist and call printPrime method
		list = new ArrayList<Integer>();
		printPrime();
	}

	private void printPrime() {
		// loop from 1 to 100 and store number in arraylist
		for (int i = 1; i < SIZE+1; i++) {
			list.add(i);
			// check for prime numbers by assuming number is prime until proven false
			// proven by checking if number is divisble by any number other than 1 or itself
			if (i > 2) {
				boolean prime = true;
				for (int j = 2; j < i; j++) {
			        if (i%j == 0) {
			        	prime = false;
			        }
			    }
				if (prime) {
					System.out.print(i + " ");
				}
			} else if (i == 2) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
}
