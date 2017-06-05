package com.revature.hmwk1;

import java.util.Date;

public class Question14 {
	/* Q14. Write a program that demonstrates the switch case
	* Implement the following functionalities in the cases:
	* Case 1: Find the square root of a number using the Math class method
	* Case 2: Display today’s date
	* Case 3: Split the following string and store it in a sting array
	* 
	*/ 
	
	// test variables
	final String line = "I am learning Core Java";
	final double testNum = 36; 
	
	public Question14(int c) {
		// call the switch case method
		switchCase(c);
	}

	private void switchCase(int c) {
		// create switch case for each case described in instructions
		switch (c) {
			case 1:
				// case 1 prints the square root of a the test number
				System.out.println(Math.sqrt(testNum));
				break;
			case 2:
				// case 2 prints today's date
				Date d = new Date();
				System.out.println(d.toString().substring(0, 10) + " 2017");
				break;
			case 3:
				// case 3 splits test string stores in a string array & prints array
				String[] strArray = line.split(" ");
				for (String str : strArray) {
					System.out.println(str);
				}
				break;
			default:
				// prints message when invalid case choice is entered
				System.out.println("invalid case choice");
				break;
		}
	}

}
