package Question19;

import java.util.ArrayList;

public class ArrayOddEvenPrime {

	public static void main(String[] args) {
		
		//Created array and added inserts of integers 1 to 10
		ArrayList<Integer> numList = new ArrayList<Integer>() {{
			add(1);
			add(2);
			add(3);
			add(4);
			add(5);
			add(6);
			add(7);
			add(8);
			add(9);
			add(10);
		}};
		
		//Creating objects for odd and even, both of which call their respective
		//functions to add their appropriate numbers respectively.
		//Print the sum of both the odd and even integers
		ArrayOddEvenPrime odd = new ArrayOddEvenPrime();
		int oddSum = odd.sumOdds(numList);
		System.out.println("The sum of the odd integers is: " + oddSum);
		
		ArrayOddEvenPrime even = new ArrayOddEvenPrime();
		int evenSum = even.sumEvens(numList);
		System.out.println("The sum of the even integers is: " + evenSum);
		
		//Create a prime object for determining what numbers are remaining after primes are removed in array.
		ArrayOddEvenPrime prime = new ArrayOddEvenPrime();
		System.out.println("The remaining numbers after the primes have been removed are: ");
		
		//If isPrime is false, display each remaining number and continue looping
		for(int i = 0; i < numList.size(); i++) {
			boolean isPrime = prime.isPrime(numList.get(i));
			if(isPrime == false) {
				System.out.println(numList.get(i) + " ");
			}
		}
		
		
	}

	public int sumOdds(ArrayList<Integer> o) {
		
		int result = 0;
		
		//Takes and adds from array if number is odd only, returning the result
		for(int i = 0; i < o.size(); i++) {
			if(o.get(i) % 2 == 1) {
				result += o.get(i);
			}
		}
		
		return result;
	}
	
	public int sumEvens(ArrayList<Integer> e) {
		
		int result = 0;
		
		//Takes and adds from array if number is even only, returning the result
		for(int i = 0; i < e.size(); i++) {
			if(e.get(i) % 2 == 0) {
				result += e.get(i);
			}
		}
		
		return result;
	}
	
	private boolean isPrime(int p) {
		
		//Exception check for 1 since it's not prime.
		if(p == 1) {
			return false;
		}
		
		//Efficiently only need to go as high as square root for, casting int for square root.
		int sqrt = (int)Math.sqrt(p) + 1;
		
		//Primality test where if any number is divisible it will return false as it's not prime, true if it is prime.
		for(int i = 2; i < sqrt; i++) {
			if(p % i == 0) {
				return false;
			}
		}
		
		return true;
	}

}
