package com.revature.q9;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List of numbers 1-100
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i = 1; i <= 100; i++)
			nums.add(i);
		
		//prints number if it is prime
		for(int i : nums){
			//Do the prime number thing here
			if(isPrime(i))System.out.println(i);
		}
			
	}

	//returns true if it is prime
	public static boolean isPrime(int n){
		//if (n == 1) return false;
		
		//1 and 2 are prime
	    if (n <= 2) return true;
	       
	    //all even numbers are prime
	    if (n % 2 == 0) return false;
	       
	    /*
	     * start at 3 because we already decided 1 and 2 are prime
	     * we only need to check even numbers so we do i+=2
	     */
	    for (int i = 3; i * i <= n; i += 2)
	        if (n % i == 0) return false;
	        
	    //if it hasn't been caught yet its prime
	    return true;
	}
}
