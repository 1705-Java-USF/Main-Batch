package com.revature.q4;

import java.util.Scanner;

public class NFactorial {

	public static void main(String[] args) {
			System.out.println("Write a program to compute N factorial.");
			Scanner input = new Scanner(System.in);  // to accept input
			
			System.out.print("Please input a number: ");
			int num = input.nextInt();  // asks for input
			int answer = 1;   // variable to keep the answer in
			
			for (int i = 0; i < num; i++)   // for loop which will run 'num' amount of time
			{
				answer *= (num - i);    // n factorial formula
			}
			
			System.out.println("Answer: " + answer);
			
			input.close();
	}

}
