package com.revature.q17;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		double principal,rate,time;

		//scanner to read input
		Scanner in = new Scanner(System.in);
		
		//prompt for principal
		System.out.print("Enter Principal: ");
		//reads into principal
		principal = in.nextDouble();
		
		//prompt for rate
		System.out.print("Enter Rate: ");
		//reads into rate
		rate = in.nextDouble();
		
		//prompt for time
		System.out.print("Enter Time: ");
		//reads into time
		time = in.nextDouble();
		
		//displays product
		System.out.println("Result: " + (principal*rate*time));
	}
}
