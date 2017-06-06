package com.revature.java_hw.q6;

import java.util.Scanner;

public class EvenOddTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter an integer to determine if it's even or odd.");
		
		//Read in and store an integer
		while(!scan.hasNextInt()){
			scan.next();
		}
		int num = scan.nextInt();
		
		//Make the integer positive if it wasn't already
		if(num < 0)
			num *= -1;
		
		//boolean to evaluate final result
		boolean even = true;
		
		//Loops through NUMBER of times, toggling the boolean even each time
		int i=num;
		while (i > 0) {
			i--;
			even = !even;
		}
		
		//Prints out the result based on the boolean value of even.
		System.out.println((even) ? ("even!"):("odd!"));
		
		scan.close();
	}
}
