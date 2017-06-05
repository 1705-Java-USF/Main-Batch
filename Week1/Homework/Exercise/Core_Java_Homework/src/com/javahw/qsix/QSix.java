package com.javahw.qsix;

import java.util.InputMismatchException;
import java.util.Scanner;

public class QSix {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter a number to see if it is even!");
		
		//Check for valid input
		try{
			int n = scan.nextInt();
			
			scan.close();
			
			if(isEven(n)){
				System.out.println("It is even!");
			} else {
				System.out.println("It is odd!");
			}	
		} catch (InputMismatchException e){
			System.out.println("You did not input a valid number.");
		} 
	}

	//Check if the int variable is even
	static boolean isEven(int num)
	{
		if( (num/2)*2 == num )
			return true;
		else
			return false;
	}
}
