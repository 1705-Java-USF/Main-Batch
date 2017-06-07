/* Demetrus Atkinson
 * 
 */
package com.revature.problem11_2; 

import com.revature.problem11_1.*; // import the package to use the Floats class

//class to obtain floats from a different package
public class FloatFinder {

	public static void main(String[] args) {

		// declare new Floats
		Floats fl1 = new Floats();
		Floats fl2 = new Floats();

		// print out the value of those floats
		System.out.println("The value of fl1: " + fl1.f1);
		System.out.println("The value of fl2: " + fl2.f2);
	}

}
