package com.revature.java_hw.q17;

import java.util.Scanner;

public class InterestCalculator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//Read in a double for the principal.
		System.out.println("Please enter the principal.");
		while(!scan.hasNextDouble()){
			scan.next();
		}
		double principal = scan.nextDouble();
		
		//Read in a double for the rate of interest.
		System.out.println("Please enter the rate of interest.");
		while(!scan.hasNextDouble()){
			scan.next();
		}
		double rate = scan.nextDouble();

		
		//Read in a double for the number of years.
		System.out.println("Please enter the number of years.");
		while(!scan.hasNextDouble()){
			scan.next();
		}
		double time = scan.nextDouble();
		
		//Print out the resulting simple interest to 2 decimal places (the format for money)
		System.out.println("The simple interest is $" +
				new java.text.DecimalFormat("#.##").format(principal * rate * time));
		
		scan.close();
	}

}
