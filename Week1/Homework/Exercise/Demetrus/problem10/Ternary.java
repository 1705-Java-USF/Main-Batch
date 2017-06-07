/* Demetrus Atkinson
 * 
 */
package com.revature.problem10;

public class Ternary {

	public static void main(String[] args) {

		// generate random numbers for comparison
		int a = (int) (Math.random() * ((50 - 1) + 1)) + 1;
		int b = (int) (Math.random() * ((50 - 1) + 1)) + 1;

		int min; // will hold the smaller value after method call
		
		// call to findMin to return smaller integer value
		min = findMin(a, b);

		// displays the two numbers compared and the smaller of the two
		System.out.println("The numbers compared are: " + a + " and " + b);
		System.out.println("The smaller number is: " + min);

	}

	static int findMin(int a, int b) {

		// ternary operation to compare the the two integer number passed
		int smaller = (a < b) ? a : b;

		// return smaller value
		return smaller;
	}
}
