package com.revature.question4;

public class QuestionFour {

	public static void main(String[] args) {
		
		//create the factorial number
		int f = 1;
		
		
		// the n!
		int n = 5;
		
		//do the factorial of n
		for (int i = 1; i <= n; i++){
			f = f * i;
		}
		
		System.out.println("factorial of " + n + " is " + f);
		

	}

}
