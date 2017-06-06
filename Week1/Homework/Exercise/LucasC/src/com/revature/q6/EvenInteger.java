package com.revature.q6;

import java.util.Scanner;

public class EvenInteger {

	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Write a program to determine if an integer is even without using the modulus operator (%)");
		System.out.print("Input an integer: " );
		int input = sc.nextInt();
		
		if ((input & 1) == 0)   // using bitwise & which will compare the bits of any input. By checking the input with '1', 
		{                       // we are making sure that only the last bit is the part checked
			System.out.println("Even");   // if the last bit is 0, then we know the number is even 
		}
		else
		{
			System.out.println("Odd");
		}
			
			
		sc.close();
	}

}
