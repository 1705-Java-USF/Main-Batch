package com.assignment.q1;

public class Assignment1 
{
	
	public static void main(String[] args) 
	{
		//Initiate array
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		
		//Print unsorted array
		System.out.print("Unsorted Array: ");
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		//Call bubbleSort
		bubbleSort(arr);
		
		//Print sorted array
		System.out.print("Unsorted Array: ");
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void bubbleSort(int[] arr)
	{
		Boolean swap = false; //keep track if swap was executed
		int temp; //hold value being swaped
		
		do{
			swap = false; //assume no swaps will take place
			for(int i = 0; i < arr.length - 1; i++) //iterate through array
			{
				if(arr[i] > arr[i+1]) //compare current location to next location
				{
					//swap
					temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					//let outer loop that swap has occured
					swap = true;
				}
			}
		}while(swap); //if there are no more swaps, list is sorted
	}
}
