package com.revature.q1;

public class Driver {
	public static void main(String[] args) {
		int arr[] = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		// runs bubble sort on array
		bubbleSort(arr);
		// prints each element of the now sorted array
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public static void bubbleSort(int[] arr) {
		//if you swapped an element
		boolean swapped = true;
		//index offset
		int j = 0;
		//temporary variable for swapping
		int tmp;
		while (swapped) {
			swapped = false;
			j++;
			for (int i = 0; i < arr.length - j; i++) {
				if (arr[i] > arr[i + 1]) {
					//if the next element is less than the current
					//element, swap the two and say it was swapped
					tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
					swapped = true;
				}
			}
		}
	}
}
