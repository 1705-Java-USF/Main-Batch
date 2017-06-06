package com.revature.java_hw.q4;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter an integer to calculate its factorial");
		
		//Read in and store an integer
		while(!scan.hasNextInt()){
			scan.next();
		}
		int num = scan.nextInt();
		
		//Test for invalid numbers and base cases
		if (num < 0) {
			System.out.println("Factorial operation can only be done on positive integers.");
		} else if (num < 2) {
			System.out.println(1);
		} else if (num > 20) {
			System.out.println(num + "! is above a long's maximum value.");
		} else {
			//Starting with the value 2, multiply it by each number from 3 up to (and including) the entered number. 
			long product = 2;
			for(int i=3; i<=num; i++) {
				product *= i;
			}
			//Print out the result
			System.out.println(num + "! = " + product);
		}
		
		scan.close();
	}
}
