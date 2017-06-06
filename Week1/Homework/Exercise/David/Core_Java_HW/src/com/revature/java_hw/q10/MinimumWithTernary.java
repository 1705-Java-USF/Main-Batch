package com.revature.java_hw.q10;

import java.util.Scanner;

public class MinimumWithTernary {

	public static void main(String[] args) {
		//Input first integer
		Scanner scan = new Scanner(System.in);
		System.out.println("Input the first number: ");
		while(!scan.hasNextInt()){
			scan.next();
		}
		int a = scan.nextInt();
		
		//Input second integer
		System.out.println("Input the next number: ");
		while(!scan.hasNextInt()){
			scan.next();
		}
		int b = scan.nextInt();
		
		//Print out the minimum using Ternary operator.
		System.out.println("Minimum of " + a + " and " + b + " is " + ((a<=b)?a:b));
		
		scan.close();
	}
	
}
