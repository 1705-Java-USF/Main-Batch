package com.revature.q12;

public class ArrayEnhancedForLoop {

	public static void main(String[] args) {

		String text = "Write a program to store numbers from 1 to 100 in an array."
				+ "Print out all the even numbers from the array. Use the enhanced FOR loop for printing out the numbers.";
		System.out.println(text);
		
		
		int arr[] = new int[100];  // initialize an array of type int with size 100
		
		for (int i = 0; i < 100; i++)  // populate array with values from 1 - 100
		{
			arr[i] = i + 1;
		}
		
		System.out.println("Even numbers (being printed with enhanced for loop): ");
		for (int j : arr)  // enhanced for loop which checks all values within array
		{
			if (j % 2 == 0)   // if value j is even,
			{
				System.out.print(j + ", ");  // print it out
			}
		}
		
		
		
		
	}

}
