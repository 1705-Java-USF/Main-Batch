package com.revature.q13;

public class Triangle {

	public static void main(String[] args) {

		String text = "Display the triangle on the console as follows using any type of loop."
				+ " Do NOT use a simple group of print statements to accomplish this.";
		/*
		 * "0" 
		 * "1 0" 
		 * "1 0 1" 
		 * "0 1 0 1"
		 */
		System.out.println(text);

		int size = 10;  // initializing variable for triangle array size (can be changed easily here)
		int count = 0;  // initializing 2 counters
		int count2= 1;
		
		int triangle[] = new int[size];  // new triangle array of size'size'

		for (int i = 0; i < size; i++)  // populate array with 0's and 1's depending if even or odd
		{
			if (i % 2 == 0)
			{
				triangle[i] = 0;
			} 
			else if (i % 2 == 1) 
			{
				triangle[i] = 1;
			}
		}

		for (int i = 0; i < size; i++)   // display array elements in triangle form
		{
			System.out.print(triangle[i] + " ");
			
			if (i == count)    // whenever counter is == to the index, then it will go to a new line
			{
				System.out.println();
				count2++;
				count += count2;
			}	
		}

	}

}
