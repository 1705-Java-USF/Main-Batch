/* Demetrus Atkinson
 * 
 */
package com.revature.problem2;

public class Fibonacci {

	public static void main(String[] args) {
		// array for first 25 Fibonacci numbers
		int[] F = new int[25];

		// first 2 Fibonacci numbers are known
		F[0] = 0;
		F[1] = 1;

		// print first 2
		System.out.println("First 25 Fibonacci numbers starting at 0");
		System.out.println("------------------------------------------");
		System.out.println("F[0]: " + F[0]);
		System.out.println("F[1]: " + F[1]);

		// print out the rest of the 25 Fibonacci numbers (beginning at 0)
		for (int i = 2; i < 25; i++) {
			// the result F[i] is stored from the additive
			// result of the previous two numbers
			F[i] = F[i - 1] + F[i - 2];

			// display F[i] throughout
			System.out.println("F[" + i + "]: " + F[i]);
		}

	}

}
