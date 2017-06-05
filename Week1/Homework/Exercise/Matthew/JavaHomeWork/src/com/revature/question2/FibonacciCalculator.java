package com.revature.question2;

import java.util.ArrayList;

public class FibonacciCalculator {

	public static void main(String[] args) {
		FibonacciCalculator fc = new FibonacciCalculator();
		
		
		for(int i = 0; i < 25; i++) // print out the fibonacci numbers
		{
			
			System.out.println(fc.getNumber(i));
		}
	}
	ArrayList<Integer> calculatedNumber; //holds numbers already calculated
	public FibonacciCalculator()
	{
		calculatedNumber = new ArrayList<Integer>();
		calculatedNumber.add(0); //initialize the first two as 0 and 1 the first two fibonacci numbers
		calculatedNumber.add(1);
	}
	public int getNumber(int n) // get the nth fibonacci number
	{
		if(n < calculatedNumber.size()) // checks if number was already calculated
		{
			return calculatedNumber.get(n);
		}else if(n == calculatedNumber.size()) //else checks if the number right before was calculated
		{
			calculatedNumber.add(calculateNumber(n)); // adds the calculated number 
		}else // the previous number was not calculated call getNumber on the previous number
		{
			getNumber(n-1); //Will end up with the previous number being calculated
			calculatedNumber.add(calculateNumber(n)); //leaving the current one ready to be calculated
		}
		return calculatedNumber.get(n);
	}
	private int calculateNumber(int n) // calculates the number
	{
		return calculatedNumber.get(n-2) + calculatedNumber.get(n-1); //adds two previous numbers
	}

}
