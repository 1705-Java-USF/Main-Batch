/* Demetrus Atkinson
 * 
 */
package com.revature.problem8;

import java.util.ArrayList;

public class Palindromes {

	public static void main(String[] args) {
		// original ArrayList contents
		ArrayList<String> l = new ArrayList<>();

		// new ArrayList with palindromes
		ArrayList<String> nl = new ArrayList<>();
		char[] ca; // convert ArrayList to a char array
		String s;
		String back; // string for string display backward

		// add names to ArrayList
		l.add("karan");
		l.add("madam");
		l.add("tom");
		l.add("civic");
		l.add("radar");
		l.add("sexes");
		l.add("jimmy");
		l.add("kayak");
		l.add("john");
		l.add("refer");
		l.add("billy");
		l.add("did");

		// go forward through ArrayList
		for (int i = 0; i < l.size(); i++) {

			back = ""; // clear variable after every iteration
			s = l.get(i); // store individual characters into a String
			ca = s.toCharArray();
			// go through array in reverse order
			for (int j = ca.length - 1; j >= 0; j--) {
				back = back + ca[j]; // stores contents in reverse order for
										// later comparison
			}
			// are the Strings equal?
			if (s.equals(back)) {
				// if so, then the string is a palindrome
				nl.add(back);
			}
		}

		// print out the new ArrayList of palindromes
		System.out.println("Palindromes: " + nl);
	}

}
