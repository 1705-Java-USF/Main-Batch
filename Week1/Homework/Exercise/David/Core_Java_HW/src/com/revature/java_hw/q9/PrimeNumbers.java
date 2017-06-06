package com.revature.java_hw.q9;

import java.util.ArrayList;

public class PrimeNumbers {

	public static void main(String[] args) {
		//Integer ArrayList containing numbers 1-100
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		//Add 1 as it's a special number that would register as prime, but isn't prime.
		numbers.add(1);
		
		//Add and print out 2 to avoid starting or ending with a comma.
		numbers.add(2);
		System.out.print("2");
		
		
		for(int i=3; i<=100; i++) {
			numbers.add(i);
			//Set the number as prime
			boolean prime = true;
			//Loop through all numbers between 2 and the square root of number.
			//If this is a factor of our number, our number is not prime.
			for(int j=2; j<=Math.sqrt(i); j++) {
				if(i%j == 0){
					prime = false;
					break;
				}
			}
			//If prime is still true, the number is added to primes.
			if (prime) {
				System.out.print(", " + i);
			}
		}
	}
}
