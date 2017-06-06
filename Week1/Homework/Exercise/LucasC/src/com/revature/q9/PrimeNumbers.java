package com.revature.q9;

import java.util.ArrayList;

public class PrimeNumbers {

	public static void main(String[] args) {

		String text = "Create an ArrayList which stores numbers from 1 to 100 and"
				+ "prints out all the prime numbers to the console.";
		System.out.println(text);

		ArrayList<Integer> a1 = new ArrayList<Integer>(); // Instantiating new
															// ArrayList object
															// named a1

		for (int i = 1; i < 101; i++) // populate a1 with numbers from 1 - 100
		{
			a1.add(i);
		}
		System.out.print(a1); // print all numbers in a1

		System.out.print("\nPrime numbers: ");
		
		primeNumbers(a1);

	}
	
	public static void primeNumbers(ArrayList<Integer> a1){
		for (int j : a1) // loop through a1 once
		{
			boolean isPrime = true; // creating boolean variable isPrime
			if (j == 1)   // 1 is not prime
			{
				isPrime = false;
			}

			for (int k = 2; k < j; k++) // looping through any numbers lower
										// than "j" (numbers in a1)
			{
				if (j % k == 0) // if that number can be fully divisible by any
								// other numbers, (other than itself - which it
								// never checks)
				{
					isPrime = (false); // then it is not prime
					break;  // stop checking 
				}
			}
			if (isPrime) // if it wasn't divisible at all...
			{
				System.out.print(j + ", "); // then return that number
			}
		}
	}
}
