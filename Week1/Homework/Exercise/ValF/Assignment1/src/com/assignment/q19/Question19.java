package com.assignment.q19;

import java.util.ArrayList;

public class Question19 
{
	public final static int NUM = 10;
	
	public static void main(String[] args) 
	{
		//Variables: ArrayLsit to hold numbers 1 to 1
		//Integers oddSum and evenSunm to hold sum of odd and even numbers respectively
		ArrayList<Integer> list = new ArrayList<>();
		Integer oddSum = new Integer(0), evenSum = new Integer(0);
		
		//Populate array
		for(int i = 1; i <= NUM; i++)
		{
			list.add(i);
		}
		
		//Iterate through array
		for(int i = 0; i < list.size(); i++)
		{
			//Increment summation variables
			if(isEven(list.get(i)))
				evenSum += list.get(i);
			else
				oddSum += list.get(i);
		}
		
		//Print summations
		System.out.println("Evens add up to: " + evenSum);
		System.out.println("Odds add up to: " + oddSum);
		
		//Iterate once again and remove primes
		for(int i = 0; i < list.size(); i++)
		{
			if(isPrime(list.get(i)))
			{
				list.remove(i--);
			
			}
		}
		
		//Print prime-less array
		System.out.println(list.toString());
	}
	
	//Return true if value passed in is even
	public static boolean isEven(Integer x)
	{
		if((x % 2) == 0)
			return true;
		return false;
	}
	
	//Return true if value passed in is prime
	public static boolean isPrime(Integer num)
	{
		for(int j = 2; j < num; j++)
		{
			if(num % j == 0)
				return false;
		}
		return true;
	}
	
	

}
