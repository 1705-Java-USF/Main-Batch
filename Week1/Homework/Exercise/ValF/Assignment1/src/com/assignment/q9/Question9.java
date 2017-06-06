package com.assignment.q9;

import java.util.ArrayList;

public class Question9 
{
	//Hardcode the number 100
	final static int NUM = 100;
	
	public static void main(String[] args) 
	{
		//Variable: array to store integers
		Question9 q = new Question9();
		ArrayList<Integer> arr = new ArrayList<>();
		
		//Populate array 1 to 100
		for(int i = 1; i <= NUM; i++)
		{
			arr.add(i);
		}
		
		System.out.print("Primes: ");
		
		//Cycle through array call prime() function to test if number is prime
		//If prime() returns true print the number
		for(Integer i : arr)
		{
			if(q.prime(i))
				System.out.print(i + " ");
		}
	}
	
	public boolean prime(int num)
	{
		for(int j = 2; j < num; j++)
		{
			if(num % j == 0)
				return false;
		}
		return true;
	}
}
