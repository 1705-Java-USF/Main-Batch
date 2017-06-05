package com.revature.question_12;

public class EvenNumbers {

	public static void main(String[] args) {
		int[] array = new int[100];
		
		// Fill array with 1-100.
		int j = 1;
		for(int i = 0; i < 100; i++) {
			array[i] = j;
			j++;
		}
		
		// If even, print.
		for(int i : array) {
			if(i % 2 == 0)
				System.out.println(i);
		}
	}
}
