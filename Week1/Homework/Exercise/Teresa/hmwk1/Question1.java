package com.revature.hmwk1;

public class Question1 {
	// Q1. Perform a bubble sort  
	
	// given variable
	final private int[] ARRAY = {1,0,5,6,3,2,3,7,9,8,4};
	
	public Question1() {
		bubbleSort();
	}

	protected void bubbleSort() {
		// bubble sort algrithm: compare current value with next value 
		// and swap if current is greater than next
		int temp = 0;
		for (int i = 0; i < ARRAY.length; i++) {
			for (int j = 1; j < ARRAY.length-i; j++) {
				if (ARRAY[j-1] > ARRAY[j]) {
					// swap
					temp = ARRAY[j-1];
					ARRAY[j-1] = ARRAY[j];
					ARRAY[j] = temp;
				}
			}
		}
		// print sorted array
		for (int k : ARRAY) {
			System.out.print(ARRAY[k] + " ");
		}
		System.out.print("\n");
	}
}
