package com.revature.java_hw.q19;

import java.util.ArrayList;

public class ArrayListDriver {

	public static void main(String[] args) {
		//Create an ArrayList containing the numbers 1-10 and print it
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i=1; i<=10; i++) {
			nums.add(i);
		}
		System.out.println("ArrayList: " + nums);
		
		//Start a running sum at 0 and add numbers that are even. Print the result
		int sum = 0;
		for(int i:nums) {
			if(i%2==0) {
				sum += i;
			}
		}
		System.out.println("The sum of even numbers: " + sum);

		//Start a running sum at 0 and add numbers that are odd. Print the result
		sum = 0;
		for(int i:nums) {
			if(i%2 != 0) {
				sum += i;
			}
		}
		System.out.println("The sum of odd numbers: " + sum);
		
		//Loop through each number in the ArrayList
		for(int i=0; i<nums.size(); i++) {
			//Doesn't remove if less than or equal to 1 (not prime numbers)
			if(nums.get(i) <= 1)
				continue;
			
			//Set prime as true, changed to false if the number has a factor after 1
			//(Doesn't enter loop for 2 or 3, meaning they're prime still)
			boolean prime = true;
			for(int j=2; j<=Math.sqrt(nums.get(i)); j++) {
				if(nums.get(i)%j == 0){
					prime = false;
					//One factor found, break out of the loop since the number isn't prime.
					break;
				}
			}
			//No factors found, the number is prime and gets removed.
			if(prime) {
				//Decrements i because the number was removed, meaning i would be the index of the next number
				nums.remove(i--);
			}
		}
		System.out.println("ArrayList after removing primes: " + nums);
	}

}
