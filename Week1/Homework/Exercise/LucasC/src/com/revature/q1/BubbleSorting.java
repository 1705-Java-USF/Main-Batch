package com.revature.q1;

public class BubbleSorting {

	public static void main(String[] args) 
	{
		int myArray[] = {1,0,5,6,3,2,3,7,9,8,4}; // initialized my array and declared it
		
		System.out.println("--- Array before bubble sort ---");
		
		for (int i = 0; i < myArray.length; i++)  // for loop which displays the array's values prior to being manipulated
		{
			System.out.print(myArray[i] + " ");
		}
		
		bubbleSortingMethod(myArray);   // call bubbleSortingMethod which will manipulate the array given in the parameter
		
		System.out.println("\n--Array after bubble sort ---");  // prints out the array again, after being changed
		for (int i = 0; i < myArray.length; i++)
		{
			System.out.print(myArray[i] + " ");
		}
		
	}
	
	static void bubbleSortingMethod(int[] arr)  // sorting method
	{
		int tempInt = 0;    // temporary variable to hold an integer for us
		int myArray[] = arr;  // renaming the array in this scope so that I can use code that I had already written
		
		for (int i = 0; i < myArray.length; i++)  // for loop goes through each single index in the array
		{
			for (int j = 1; j < myArray.length; j++)  // goes through array again, checking every single index 
			{
				if (myArray[j - 1] > myArray[j])  // if the index in front of the index we're checking is higher,
				{
					tempInt = myArray[j - 1];   // then swap them (saving number in temporary variable)
					myArray[j - 1] = myArray[j];
					myArray[j] = tempInt;
					
				}
			}
		}
	}
}
