package com.revature.q19;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args){
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		for(int i = 1; i <= 10; i++)
			nums.add(i);
		//will hold the sum of odd and even numbers respectively
		int odds = 0,evens = 0;
		
		//Goes through all the numbers
		for(int i : nums){
			//adds the number to evens if its even, odd if it isn't
			if(i%2 == 0)evens+= i;
			else odds+= i;
		}
		
		//Displays Even and Odd Numbers
		System.out.println("Sum of Even Numbers: " + evens);
		System.out.println("Sum of Odd Numbers: " + odds);
		
		//Loops through the ArrayList
		for(int i = 0; i < nums.size(); i++){
			//If the number is prime...
			if(isPrime(nums.get(i))){
				//remove the prime number
				nums.remove(i);
				//go back one index to compensate for the removed item
				i--;
			}
		}
		System.out.println(nums);
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
