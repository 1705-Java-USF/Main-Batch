package com.revature.hmwk1;

public class Question6 {
	// Q6. Write a program to determine if an integer is even
	// without using the modulus operator 
	
	public Question6(int num) {
		isEven(num);
	}
	
	protected boolean isEven(int num) {
		// all even numbers are divisble by 2 with no remainder
		// '/2' for odd numbers will not return the true half value, making
		// it impossible to return to the inital value if you mulitply by 2
		if ( (num/2)*2 == num ) {
			return true;
		} else {
			return false;
		}
	}
	
}
