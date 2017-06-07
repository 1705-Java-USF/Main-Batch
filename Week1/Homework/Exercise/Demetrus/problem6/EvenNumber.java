/* Demetrus Atkinson
 * 
 */
package com.revature.problem6;

public class EvenNumber {
	public static void main(String[] args) {
		// generate a random number for testing
		int a = (int) (Math.random() * ((100 - 1) + 1)) + 1;

		// divide that int by 2 but make it a double so no integer division is
		// performed
		double b = a / 2;

		// convert back to int, even numbers will be equal to itself after
		// division by two and multiplication by two is performed
		int c = (int) b * 2;

		// check for evens and display the result
		if (a == c) {
			System.out.println(a + " is an even number.");
		} else {
			System.out.println(a + " is not an even number.");
		}

	}

}
