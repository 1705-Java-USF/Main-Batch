package com.revature.java_hw.q12;

public class EvenNumbers {
	
	public static void main(String[] args) {
		//Create array with numbers 1 to 100
		int[] numbers = new int[100];
		for(int i=1; i <= 100; i++) {
			numbers[i-1] = i;
		}
		
		//Loop through each number in the array
		for(int i: numbers) {
			//If even, print the number
			if(i%2 == 0)
				System.out.println(i);
		}
	}
}
