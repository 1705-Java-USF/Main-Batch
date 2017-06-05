package com.javahw.qone;

public class QOne {

	public static void main(String[] args) 
	{
		//Initialize array of integers
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		
		//Print array contents to console
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
		
		// Sort the array
		bubbleSort(arr);
		
		//Print sorted array
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	//The Bubble Sort algorithm
	static int[] bubbleSort (int[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			for(int j = 0; j < array.length - 1; j++)
			{
				if(array[j] > array[j+1])
				{
					swap(array, j, j+1);
				}
			}
		}
		return array; 
	}
	
	//Helper function for Bubble Sort
	static void swap(int[] arr, int ind1, int ind2)
	{
		int temp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = temp;
	}

} // End of class
