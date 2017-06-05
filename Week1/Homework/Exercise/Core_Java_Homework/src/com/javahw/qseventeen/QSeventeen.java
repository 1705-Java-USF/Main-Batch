package com.javahw.qseventeen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class QSeventeen {

	public static void main(String[] args) {
		
		//System.in provides a inputStream that takes user input
		Scanner scan = new Scanner(System.in);
		double[] params = new double[3];
		
		System.out.println("Enter principal, rate, and time in that order:");
		System.out.println("==================");
		try{
			for(int i = 0; i < 3; i++){
				
				params[i] = scan.nextDouble();
				
			}
			scan.close();
			
			System.out.print("Your interest is... ");
			System.out.println(calculateInterest(params[0], params[1], params[2]));
		}catch(InputMismatchException e){
			System.out.println("Invalid input");
		}
	}
	
	static double calculateInterest(double principal, double rate, double time){
		return principal * rate * time;
	}
}
