/* Demetrus Atkinson
 * 
 */
package com.revature.problem9;

import java.util.ArrayList;

public class Primes {

	public static void main(String[] args) {
		int count = 0; // flag to detect prime numbers

		// original ArrayList contents
		ArrayList<Integer> al = new ArrayList<>();

		// new ArrayList of primes
		ArrayList<Integer> alprimes = new ArrayList<>();

		// fill array with values 1-100
		for (int i = 1; i <= 100; i++) {
			al.add(i);
		}

		// go through ArrayList until size() is reached
		for (int j = 1; j <= al.size(); j++) {
			/*
			 * while going through ArrayList, get each modulo value for j and
			 * all others up to (but not including) j
			 */

			for (int k = 1; k < j; k++) {
				// check to see if numbers divide with no remainder
				if (j % k == 0) {
					count++; // keep count of each time j is divisible
				}
			}
			/*
			 * if count == 1, then the only number that it was divisible by was
			 * itself, so this number must be prime
			 */
			if (count == 1) {
				// add primes to new ArrayList of primes
				alprimes.add(j);
			}
			// reset counter after every iteration
			count = 0;
		}
		// print prime ArrayList contents
		System.out.println("Primes: " + alprimes);

	}

}
