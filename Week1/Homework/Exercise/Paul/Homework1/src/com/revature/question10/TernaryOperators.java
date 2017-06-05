package com.revature.question10;

import java.util.Scanner;

public class TernaryOperators {

	private static Scanner num;

	public static void main(String[] args) {
		
		//Scanner class used to get user input for numbers to compare
		//Number entered from user is stored as a double variable
		//min() method is called to find minimum between the 
		//two numbers the user entered 
		
		num = new Scanner(System.in);
		System.out.println("Enter the fist number: ");
		double n1 = num.nextDouble();
		System.out.println("Enter the second number: ");
		double n2 = num.nextDouble();
		double minNumb = min(n1,n2);
		System.out.println("\n" + "=====Minimum of Two Numbers Using Ternary Operator=====");
		System.out.println("\n" + minNumb);
		
	}
	
	//method to check for minimum number 
	//between the two numbers entered by the user 
	public static double min (double x, double y) {
		//First x and y are compared and a boolean result is returned
		//if true then x  
		//if false then y 
		return x < y ? x : y;
	}

}
