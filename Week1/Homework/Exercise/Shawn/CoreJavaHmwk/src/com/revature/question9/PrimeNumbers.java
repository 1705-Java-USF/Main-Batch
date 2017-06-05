package com.revature.question9;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {

	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<Integer>();
		boolean isPrime;	// Is a num prime? True.
		
		// Loop adds 1-100 to list nums.
		for (int i = 1; i <= 100; i++) {
			nums.add(i);
		}
		
		// Find all prime numbers.
		for(int num : nums) {
			isPrime = true;
			// Only 2 or higher matters for checking primes.
			for (int i = 2; i < num; i++) {
				// If current num evaluates to zero on any int 2 or higher, then it's not prime.
				if ((num % i == 0))
					isPrime = false;
			}
			if(isPrime)
				System.out.println(num);
		}
	}
}
