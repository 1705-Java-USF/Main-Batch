package com.revature.question1;

public class Homework {


		static void bubbleSort(int[] arr) {
			
			// declaring n to be the length of the array
			int n = arr.length;
			// creating temp to later swap values in the array
			int temp = 0;
			// Create nested for/if loop to check each position and check to see if the other position is greater or less and move around until everything has been chacked
			for (int i = 0; i < n; i++){
				for(int j = 1; j < (n); j++)
					if (arr[j-1] > arr[j]){
						temp = arr[j-1];
						arr[j-1] = arr[j];
						arr[j] = temp;
					}
				}
			}
			
					
		

		
		public static void main(String[] args) {
			
			//creating the array
			int arr[] = {1,0,5,6,3,2,3,7,9,8,4};
			
			//print original array
			System.out.println("array before bubble sort");
			for (int i = 0; i < arr.length; i++){
				System.out.print(arr[i] + "");
				
			}
			
			System.out.println();
			
			//run the bubblesort function
			bubbleSort(arr);
			
			//Print the newly bubble sorted array
			System.out.println("array after bubble sort");
			for (int i = 0; i < arr.length; i++){
				System.out.print(arr[i] + "");
			}
				
				
			
		}
	}