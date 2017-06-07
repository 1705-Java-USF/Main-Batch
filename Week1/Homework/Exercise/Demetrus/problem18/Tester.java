/* Demetrus Atkinson
 * 
 */
package com.revature.problem18;

import java.util.Scanner;

public class Tester extends AbstractTest { // Tester must implement AbstractTest
											// methods

	public static void main(String[] args) {

		// Test String
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter string: ");
		
		// Scanner process entire line of input
		String s = scanner.nextLine();
		boolean upper;

		// create Tester object
		Tester t = new Tester();
		upper = t.uppercaseTest(s);

		// results of uppercase test
		if (upper == true)
			System.out.println("There is an uppercase letter in the string " + s);
		else
			System.out.println("There is no uppercase letter in the string " + s);

		// printouts of results of tests
		System.out.println("ALL CAPS version of string: " + t.convertToUppercase(s));
		System.out.println("Int value of string: " + t.convertToInt(s));
	}

	@Override
	public boolean uppercaseTest(String s) {

		char[] carray = s.toCharArray(); // converted to needed char array to
											// test for uppercase
		for (int i = 0; i < carray.length; i++) {
			if (Character.isUpperCase(carray[i])) {
				return true; // uppercase is found
			}
		}
		return false; // no uppercase chars
	}

	@Override
	public String convertToUppercase(String s) {// convert all chars to
												// uppercase
		String uppercaseStr = s.toUpperCase();

		return uppercaseStr;
	}

	@Override
	public int convertToInt(String s) { // convert String to int
		/*
		 * Need to convert to char array to get the string's value because
		 * strings cannot (unless using wrapper classes) be converted to ints
		 */

		char[] ca = s.toCharArray();
		int subtotal = 0; // running subtotal of added chars
		int total; // grand total
		for (int i = 0; i < ca.length; i++) {
			//use Character getNumericValue method to get the value of a string
			subtotal = subtotal+ Character.getNumericValue(ca[i]);
		}
		// the subtotal needs to be added by 10 the get the actual result
		total = subtotal + 10;
		return total;
	}

}
