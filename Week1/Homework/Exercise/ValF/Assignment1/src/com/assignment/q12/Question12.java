package com.assignment.q12;

public class Question12 
{
	//Hardcode the value 100
	static final int NUM = 100;
	
	public static void main(String[] args) 
	{
		//Variable: integer array to hold values
		int[] arr = new int[NUM];
		
		//Populate array
		for(int i = 1; i <= NUM; i++)
		{
			arr[i - 1] = i;
		}
		
		//Iterate through array
		for(int i : arr)
		{
			//If value is even then print
			if(i % 2 == 0)
				System.out.print(i + " ");
		}
		System.out.println("\n");
	}

}
