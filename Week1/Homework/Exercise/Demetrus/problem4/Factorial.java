/* Demetrus Atkinson
 * 
 */
package com.revature.problem4;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {

		// get number to compute factorial from user
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number: ");
		int n = scanner.nextInt();

		int total = 1; // needs a seed value of 1 to start
		// go through array (in reverse order) and print get the running total
		for (int i = n; i > 0; i--) {
			total = total * i;
		}

		// print N factorial ansd close scanner
		System.out.println(n + "! equals " + total);
		scanner.close();
	}
}
