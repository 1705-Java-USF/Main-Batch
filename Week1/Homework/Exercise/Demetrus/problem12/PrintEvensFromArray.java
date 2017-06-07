/* Demetrus Atkinson
 * 
 */
package com.revature.problem12;

public class PrintEvensFromArray {

	public static void main(String[] args) {

		// array of size 100
		int[] array = new int[100];

		// load the array with values for 1-100
		for (int i = 0; i < 100; i++) {
			array[i] = i + 1;
		}
		System.out.println("Even numbers from 0-100");
		System.out.println("----------------------");

		// used enhanced for loop to print out even numbers
		for (int n : array) {
			if (n % 2 == 0) {
				System.out.println(n);
			}
		}

	}

}
