package com.revature.question4;

public class Factorial {

	public static void main(String[] args) {
		
		int i, fact = 1; 
		int number = 7; //Number to be computed
		for(i = 1; i <= number ; i++){
			fact = fact * i;
		}
		System.out.println("Factorial of " + number+ " is: " + fact);
		
	}

}
