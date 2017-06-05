package com.revature.hmwk1;

public class Question10 {
	// Q10. Find the minimum of two numbers using ternary operators
	
	public Question10 (int a, int b) {
		minimum(a, b);
	}
	
	protected void minimum(int a, int b) {
		// if b is less than a, return b
		// if not, return a 
		// if same, return a
		if (b < a) {
			System.out.println(b);
		} else {
			System.out.println(a);
		}
	}
	
}
