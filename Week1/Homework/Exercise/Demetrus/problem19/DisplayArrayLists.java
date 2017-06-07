/* Demetrus Atkinson
 * 
 */
package com.revature.problem19;

import java.util.ArrayList;

public class DisplayArrayLists {

	public static void main(String[] args) {

		// original ArrayList
		ArrayList<Integer> al = new ArrayList<>();

		// display of alternate ArrayList based on method
		DisplayArrayLists dal = new DisplayArrayLists();

		// fill ArrayList with values from 1-10
		for (int i = 1; i <= 10; i++) {
			al.add(i);
		}

		// method calls to perform operations on ArrayList
		dal.originalArrayList(al);
		dal.sumOfEvens(al);
		dal.sumOfOdds(al);
		dal.displayNoPrimes(al);

	}

	public void originalArrayList(ArrayList<Integer> al) {// displays original
															// ArrayList
		System.out.println("Original ArrayList:" + al);

	}

	public void sumOfEvens(ArrayList<Integer> al) { // display the added total
													// of all even numbers in
													// the ArrayList
		int sumEvens = 0; // running total counter

		// loop through ArrayList only getting the even numbers
		for (int i = 0; i < al.size(); i++) {

			// ArrayList must cast the results from the get method to an Integer
			// for testing
			if (((Integer) al.get(i) % 2) == 0) {
				// running total stored in sumEvens variable
				sumEvens = sumEvens + (Integer) al.get(i);
			}
		}
		// print the sum
		System.out.println("Sum of even numbers = " + sumEvens);

	}

	public void sumOfOdds(ArrayList<Integer> al) {// display the added total of
													// all even numbers in the
													// ArrayList
		int sumOdds = 0;// running total counter
		for (int i = 0; i < al.size(); i++) {
			// loop through ArrayList only getting the odd numbers
			if (((Integer) al.get(i) % 2) != 0) {
				// running total stored in sumOdds variable
				sumOdds = sumOdds + (Integer) al.get(i);
			}
		}
		// print the sum
		System.out.println("Sum of odd numbers = " + sumOdds);
	}

	public void displayNoPrimes(ArrayList<Integer> al) { // display ArrayList
															// with
															// no primes

		int count = 0; // int counter to test for primes

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
			if (count == 1) {
				al.remove((Integer) j); // remove() needs the int casted to an
										// object(Integer) to work in this case

			}
			count = 0; // reset counter
		}

		// display ArrayList without primes
		System.out.println("ArrayList with primes removed: " + al);

	}

}
