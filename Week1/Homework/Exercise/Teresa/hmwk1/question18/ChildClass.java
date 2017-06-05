package com.revature.hmwk1.question18;

public class ChildClass extends ParentClass {
	/* 
	 * three implementations in the subclass: 
	 * Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
	 * Convert all of the lower case characters to uppercase in the input string, and return the result. 
	 * Convert the input string to integer and add 10, output the result to the console
	 */

	@Override
	protected boolean hasUpperCase(String word) {
		// create char array and use an enhanced for loop 
		// to check for a upper case char
		char[] cList = word.toCharArray();
		for (char c : cList) {
			if ( Character.isUpperCase(c) ) {
				return true;
			}
		}
		return false;
	}

	@Override
	protected String convertCase(String word) {
		// create a char array and use an enhanced for loop 
		// to convert all lowercase letters to uppercase, while
		// adding the char back to a string
		char[] cList = word.toCharArray();
		String temp = "";
		for (char c : cList) {
			if (Character.isLowerCase(c)) {
				c = Character.toUpperCase(c);
			}
			temp += c;
		}
		return temp;
	}

	@Override
	protected void addTen(String num) {
		// convert string to int using integer class and add ten
		// print result
		int newNum  = Integer.parseInt(num) + 10;
		System.out.println(newNum);
	}

}
