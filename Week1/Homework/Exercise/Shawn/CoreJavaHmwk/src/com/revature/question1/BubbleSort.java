package com.revature.question1;

public class BubbleSort {

	public static void main(String[] args) {
		int[] numsToSort = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		int temp;
		// Nested for loops for Bubble Sort.
		for (int i = 0; i < numsToSort.length; i++) {
			for (int j = 1; j < numsToSort.length - i; j++) {
				// Interchange values.
				if (numsToSort[j - 1] > numsToSort[j]) {
					temp = numsToSort[j - 1];
					numsToSort[j - 1] = numsToSort[j];
					numsToSort[j] = temp;
				}
			}
		}
		
		// Iterate and print through the Bubble Sorted array.
		for (int num : numsToSort) {
			System.out.print(num + " ");
		}
	}
}
