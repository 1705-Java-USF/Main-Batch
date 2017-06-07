/* Demetrus Atkinson
 * 
 */
package com.revature.problem13;

public class Triangle {

	public static void main(String[] args) {

		int x = 0; // variable to increment to get a different modulo value
		// the triangle is 4 characters in height
		for (int j = 1; j <= 4; j++) {
			// loop to print 0's and 1's for every j
			for (int k = 1; k <= j; k++) {
				// use modulo to print only 0 and 1
				System.out.print(x % 2);
				// increment x so the same number is not printed twice
				x++;
			}
			// go to new line after every iteration of j
			System.out.println();
		}
	}
}
