package com.revature.question9;

import java.util.ArrayList;

public class PrimeNumbers {

	public static void main(String[] args) {
		
		//Array List to store numbers from 1 - 100
		//utilized a for loop to get numbers from 1 - 100
		
		ArrayList<Integer> list = new ArrayList<>();
		
		//adds numbers 2- 100(1 is not prime number) to array list 
			for(int i = 2; i <= 100; i++){
				list.add(i);
			}
					
			//for loop to go through numbers and 
			//remove the numbers that are not prime from
			//the array list
			for(int i = 2; i <= list.size() - 1; i++){
				if(!isPrime(list.get(i))){
					list.remove(list.get(i));
					i--;
				}
			}
			System.out.println("=====Array List of Prime Nubmers====");
			
			System.out.println();
			
			for(Integer p : list){
				System.out.println(p);
			}
	}
		
	//checks whether an int is prime or not.
	public static boolean isPrime(int n) {
	    //check if n is a multiple of 2
	    if (n % 2 == 0) return false;
	    //if not, then just check the odds
	    for(int i = 3; i * i <= n; i += 2) {
	        if(n % i == 0)
	            return false;
	    }
	    return true;
	}
}
		
	

