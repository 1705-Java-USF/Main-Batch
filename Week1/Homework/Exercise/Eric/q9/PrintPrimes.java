package q9;

import java.util.ArrayList;

public class PrintPrimes {

	public static void main(String[] args){
		PrintPrimes pp = new PrintPrimes();
		
		// builds an ArrayList of numbers from 1 to 100
		ArrayList <Integer> nums = new ArrayList<>();
		for (int i = 1; i < 101; i++)
			nums.add(i);
		
		// prints every prime number in the list
		for (int num : nums)
			if (pp.is_prime(num))
				System.out.println(num);
	}
	
	// this method returns true if n is a prime number, false otherwise
	public boolean is_prime(int n){
		if (n == 1) // 1 is considered to be NOT prime by convention
			return false;
		// a number is prime if it is NOT divisible by all numbers from 2 to sqrt(n)
		for (int i = 2; (i * i) <= n; i++){
			if (n % i == 0) // divisible by something other than n and itself
				return false;
		}
		return true;
	}
	
}
