package com.revature.question12;

public class EvenPrinter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[100];
		for(int i = 0; i < 100; i++)
		{
			nums[i] = i+1; //index is 0-99 while nums are 1-100
		}
		for(int i : nums)
		{
			if(isEven(i))
			{
				System.out.println(i);
			}
		}
	}
	public static boolean isEven(int n)
	{
		/*
		 * the result of n mod 2 is the remainder of n /2 if it is zero then 2|n
		 */
		if((n%2) == 0) //A number n is even if 2|n
		{
			return true;
		}
		return false;
	}

}
