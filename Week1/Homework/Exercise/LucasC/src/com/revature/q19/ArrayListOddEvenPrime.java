package com.revature.q19;

import java.util.*;

public class ArrayListOddEvenPrime {

	public static void main(String[] args) {

		String message = "Create an ArrayList and insert integers 1 through 10. "
				+ "Display the ArrayList. Add all the even numbers up and display the result. "
				+ "Add all the odd numbers up and display the result. Remove the prime numbers from"
				+ " the ArrayList and print out the remaining ArrayList.";
		System.out.println(message);
		
		ArrayList<Integer> arr1 = new ArrayList<Integer>();  // Initializing array
		
		int evenNum = 0;
		int oddNum = 0;
		
		for (int i = 0; i < 10; i ++)  // populating array
		{
			arr1.add(i + 1);
		}
		System.out.println(arr1);   // displaying ArrayList
		
		for (int j : arr1)
		{
			if (j % 2 == 0)
			{
				evenNum += j;
			}
			else if (j % 2 == 1)
			{
				oddNum += j;
			}
		}
		System.out.println("Even numbers add up to: " + evenNum);
		System.out.println("Odd numbers add up to: " + oddNum);
		
		System.out.print("\nPrime numbers: ");
		
		for (int k = 0; k < arr1.size(); k++)
		{
			if (arr1.get(k) % 2 == 0 || arr1.get(k) % 3 == 0 || arr1.get(k) % 5 == 0)
			{
				if (arr1.get(k) == 2 || arr1.get(k) == 3 || arr1.get(k) == 5)
				{
					arr1.set(k, null);
				}
				else{
					System.out.print(arr1.get(k) + " ");
				}
			}		
		}
		
		arr1.removeAll(Collections.singleton(null));
		
		System.out.println("\nArray without prime numbers: " + arr1);
		
		
	
	
		
	}

}
