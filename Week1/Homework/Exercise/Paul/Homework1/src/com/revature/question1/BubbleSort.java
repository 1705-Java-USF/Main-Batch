package com.revature.question1;

public class BubbleSort {

	private static void bubbleSort(int [] arr){ //method to sort arrays using bubble sort technique
		int n = arr.length; 
		int temp = 0;
		for(int i = 0; i< n; i++) {
			for (int j = 1; j < (n -i); j++) {
				if (arr[j - 1] > arr[j]) {
					//swap elements
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
					}
				}
			}
		}
	public static void main(String[] args) {
		int arr[] = {1,0,5,6,3,2,3,7,9,8,4};
		
		bubbleSort(arr); //sorting array of elements using bubble sort constructor
		
		System.out.println("Array After Bubble Sort");
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " ");
		}
	}

}
