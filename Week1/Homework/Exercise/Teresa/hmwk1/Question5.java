package com.revature.hmwk1;

public class Question5 {
	// Q5. Write a substring method that accepts a string str and an integer idx
	// between 0 and idx-1 inclusive
	
	public Question5(String str, int idx) {
		subString(str, idx);
	}
	
	protected String subString(String str, int idx) {
		// add the characters to a temporary string until you 
		// reach the given int index and then return temporary string
		String temp = "";
		for (int i = 0; i < idx; i++) {
			temp += str.charAt(i);
		}
		return temp;
	}

}
