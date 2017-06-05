package com.revature.question6;

public class EvenInteger {

	public static void main(String[] args) {
		int numToCheck = 974;
		
		// Check if number is even or not.
		if((numToCheck / 2) * 2 == numToCheck) {
			System.out.println("The number " + numToCheck + " is even.");
		} else {
			System.out.println("The number " + numToCheck + " is not even.");
		}
	}
}