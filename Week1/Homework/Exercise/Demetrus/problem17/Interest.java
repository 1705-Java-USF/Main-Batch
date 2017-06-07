/* Demetrus Atkinson
 * 
 */
package com.revature.problem17;

import java.util.Scanner;

public class Interest {

	public static void main(String[] args) {

		// get and read users principal and store it
		Scanner pScanner = new Scanner(System.in);
		System.out.print("Enter Principal: ");
		double ps = pScanner.nextDouble();

		// get and read users rate and store it
		Scanner rScanner = new Scanner(System.in);

		System.out.print("Enter rate: ");

		// divide by 100 to get user anticipated output by percent
		double rs = rScanner.nextDouble() / 100;

		// get and read users years and store it
		Scanner tScanner = new Scanner(System.in);
		System.out.print("Enter years: ");
		int ts = rScanner.nextInt();

		// print the interest based on the formula
		System.out.println("Simple Interest: " + (ps * rs * ts));

		// close Scanners
		pScanner.close();
		rScanner.close();
		tScanner.close();

	}

}
