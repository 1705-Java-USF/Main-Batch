package com.revature.hmwk1;

public class Question3 {
	// Q3. Reverse a string without using a temporary variable
	
	public Question3(String str) {
		reverse(str);
	}
	
	protected void reverse(String str) {
		// reverse method will take the current char at index 0 and place it at index (length minus the current index)
		// while moving the unchanged part of the string to the front
		for (int i = 0; i < str.length(); i++) {
			str = str.substring(1, str.length()-i) + str.substring(0, 1) + str.substring(str.length()-i, str.length());
		}
		System.out.println(str);
	}

}
