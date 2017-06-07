/* Demetrus Atkinson
 * 
 */
package com.revature.problem14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SwitchCase {

	public static void main(String[] args) {
		// generate a random number so a different case could run after
		// execution
		int i = (int) (Math.random() * ((4 - 1) + 1)) + 1;

		// test String
		String s = "I am learning Core Java";

		switch (i) {
		case 1:
			/*
			 * case 1 will generate the square root of a random number (1-50)
			 * and prints the result
			 */
			int m = (int) (Math.random() * ((50 - 1) + 1)) + 1;
			double n = Math.sqrt(m);
			System.out.println("The square root of " + m + " is " + n);
			break;
		case 2:
			/*
			 * case 2 gets the current date and time and prints it the format is
			 * day of the week, month, day, 4 digit year and time (12hr)
			 */
			final DateFormat sdf = new SimpleDateFormat("EEEE MMMM dd, yyyy h:mma");
			Calendar cal = Calendar.getInstance();
			System.out.println(sdf.format(cal.getTime()));
			break;
		case 3:
			/*
			 * case 3 splits a string and puts the contents into a String array.
			 * It also prints out the results of the string for further proof
			 * that the string was split
			 */
			String[] t = s.split(" ");
			System.out.println("Results of String split");
			System.out.println("-----------------------");
			for (int j = 0; j < t.length; j++) {
				System.out.println(t[j]);
			}
			break;
		default:
			// default condition just prints something out
			System.out.println("Nothing to see here!");
			break;
		}
	}
}
