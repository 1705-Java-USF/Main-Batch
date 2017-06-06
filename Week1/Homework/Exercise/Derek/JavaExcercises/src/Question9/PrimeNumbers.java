package Question9;

import java.util.ArrayList;

public class PrimeNumbers {
	
	public static void main(String[] args) {
		
		//Creating an ArrayList and looping through numbers
		//from 1 to 100 to add to it.
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			numbers.add(i);
		}
		
		/*
		 * Creating an ArrayList for the prime numbers.
		 * Enhanced for loop to check each integer with
		 * findPrime and the num isn't equal to 1.
		 * Then it adds it to the prime numbers ArrayList.
		*/		
		ArrayList<Integer> primeNumbers = new ArrayList<>();
		for (Integer num : numbers) {
			if (findPrime(num) && num != 1) {
				primeNumbers.add(num);
			}
		}
		
		//Prints the list out of prime numbers to console.
		System.out.println("Prime Numbers: " + primeNumbers);
	}
	
	public static boolean findPrime(Integer num) {

		//2 being first prime number to start with in loop.
		//Checks through multiples of 2 to determine if mod
		//between the int num and i is == 0 to say it's not prime,
		//unless it makes it through the check loop it is then prime.
		for (int i = 2; (i * 2) < num; i++) {
	        if (num % i == 0) {
	         	return false;
	        }         
		}
		
		return true;
	}
}
