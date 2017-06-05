package com.revature.question9;

import java.util.ArrayList;

public class PrimeChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create array list for the numbers
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i = 1; i <= 100; i++) // go through 1 - 100 adding to an array list and checking if it is prime
		{
			nums.add(i); 
			if(isPrime(i)) 
			{
				System.out.println(i);
			}
		}
	}
	public static boolean isPrime(int i)
	{
		
		for(int a = 2; a < i; a++) // skip 1 and the number itself every number can be divided by them 
		{
			if((i%a) == 0) // check if a|i 
			{
				return false; // a|i therefore i is not prime
			}
		}
		return true; // there is no a s.t. 1 < a < i & a|i therefore i is prime
	}

}
