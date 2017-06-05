package com.javahw.qfour;

import java.util.InputMismatchException;
import java.util.Scanner;

public class QFour {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter a number(from 0 up to 19) to calculate its factorial!");
		
		//Check for valid input
		try{
			int n = scan.nextInt();
			
			scan.close();
			
			//Check for numbers between 0-19
			if( n <= 19 && n >= 0 ) {
				System.out.println(nFact(n));
			}else{
				System.out.println("You did not input a number between 0 and 19.");
			}	
		} catch (InputMismatchException e){
			System.out.println("You did not input a valid number.");
		} 
			
	}
	
	//Calculate N factorial correctly up to 19 (due to int)
	static int nFact(int n)
	{
		//For 0! = 1
		if(n == 0) {
			return 1;
		}
		
		//Factorial calculation
		for(int i = n-1; i > 0; i--) {
			n *= i;
		}
		return n;
	}
}
