package com.revature.question19;

import java.util.ArrayList;

public class InsertArray {

	public static void main(String[] args) {
		
		InsertArray list = new InsertArray();
		
		list.printArrayList();
		list.sumOfEvenArrayList();
		list.sumOfOddArrayList();
		list.removePrimeNumbers();
		
	}
	
			public void printArrayList(){
				//Array List to store numbers from 1 - 10
				//utilized a for loop to get numbers from 1 - 10
								
				ArrayList<Integer> list = new ArrayList<>();
								
				//adds numbers 1 - 10 to array list 
					for(int i = 1; i <= 10; i++){
						list.add(i);
					}
					
				System.out.println("Array List Containing Numbers 1 - 10: ");
				for(int num : list){
					System.out.println(num);
					
				}
			}
			
		public int sumOfEvenArrayList() {
			
			//Array List to store numbers from 1 - 10
			//utilized a for loop to get numbers from 1 - 10
							
			ArrayList<Integer> list = new ArrayList<>();
							
			//adds numbers 1 - 10 to array list 
				for(int i = 1; i <= 10; i++){
					list.add(i);
				}
				//for loop to go through numbers and 
				//remove the numbers that are not even from
				//the array list
				for(int i = 1; i <= list.size() - 1; i++){
					if(!isEven(list.get(i))){
						list.remove(list.get(i));
						i--;
					}
				}
				
				System.out.println("=====Sum of Even Numbers====");
			
			//for loop to go through the new array list of even numbers 
			//and calculate the sum 
			int i;
			int sum = 0;
			for(i = 1; i < list.size(); i++)
			    sum += list.get(i);
			System.out.println(sum);
			return sum;
			
		}
		
		public int sumOfOddArrayList() {
			
			//Array List to store numbers from 1 - 10
			//utilized a for loop to get numbers from 1 - 10
							
			ArrayList<Integer> list = new ArrayList<>();
							
			//adds numbers 1 - 10 to array list 
				for(int i = 0; i <= 10; i++){
					list.add(i);
				}
				//for loop to go through numbers and 
				//remove the numbers that are not even from
				//the array list
				for(int i = 1; i <= list.size() - 1; i++){
					if(isEven(list.get(i))){
						list.remove(list.get(i));
						i--;
					}
				}
				
				System.out.println("=====Sum of Odd Numbers====");
			
			//for loop to go through the new array list of even numbers 
			//and calculate the sum 
			int i;
			int sum = 0;
			for(i = 1; i < list.size(); i++)
			    sum += list.get(i);
			System.out.println(sum);
			return sum;
			
		}
		
		
		public void removePrimeNumbers() {
			
			//Array List to store numbers from 1 - 10
			//utilized a for loop to get numbers from 1 - 10
			
			ArrayList<Integer> list = new ArrayList<>();
			
			//adds numbers 1- 10 to array list 
				for(int i = 1; i <= 10; i++){
					list.add(i);
				}
						
				//for loop to go through numbers and 
				//remove the numbers that are not prime from
				//the array list
				for(int i = 1; i <= list.size() - 1; i++){
					if(isPrime(list.get(i))){
						list.remove(list.get(i));
						i--;
					}
				}
				System.out.println("=====Array List Without Prime Nubmers====");
				
				
				for(Integer p : list){
					System.out.println(p);
				}
			
		}
			
			
		//checks whether an int is prime or not.
		public static boolean isPrime(int n) {
			if(n == 2)return true;
		    //check if n is a multiple of 2
		    if (n % 2 == 0) return false;
		    //if not, then just check the odds
		    for(int i = 3; i * i <= n; i += 2) {
		        if(n % i == 0)
		            return false;
		    }
		    return true;
		}
		
	//checks whether an int is even or odd.
			public  boolean isEven(int n) {
			    //check if n is divisible by 2
			    if (n % 2 == 0) {
			    	return true;
			    }else{
			    	return false;
			    }
			    	
			}
}
