package com.revature.hmwk1;

public class Question4 {
	// Q4. Write a program to compute N factorial
	
	public Question4(int num) {
		factorial(num);
	}
	
	protected int factorial(int num){
		// factorial is computed by multiplying your current value 
		// by the current value minus one until you reach 1
		int value = 1;
		for (int i = 0; i < num; i++) {
			value *= (num-i);
		}
		return value;
	}

}
