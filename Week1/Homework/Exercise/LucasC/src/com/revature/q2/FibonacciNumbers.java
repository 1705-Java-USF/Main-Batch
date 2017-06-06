package com.revature.q2;
import java.util.*;

public class FibonacciNumbers {

	public static void main(String[] args) {
		System.out.println("Fibonacci numbers can be found by adding the 2 numbers before that one");
		System.out.println("Ex: 0, 1. Next number will be 1, as 0 + 1 = 1");
	
		fibonacciAddition();   // calling the method
		
	}
	
	static void fibonacciAddition()
	{
		int tempIndex = 0;       // initialized temporary variable
		ArrayList<Integer> list = new ArrayList<Integer>();   // creating an array list of type int
		
		//System.out.println("Array list length now: " + list.size());  // testing out list.get() method
		
		list.add(0);   // adding two first entries manually
		list.add(1);
		
		// tempIndex = list.get(1) + list.get(0);  // testing array lists index addition
		
		for (int i = 0; i < 23; i++)   // for loop adds 23 items to array list
		{
			tempIndex = list.get(i) + list.get(i + 1);   // adding item i + the one next to it
			list.add(tempIndex);     // add that item to the end of the list
		}
		
		System.out.println("List size: " + list.size());
		System.out.println("List: " + list);
	}
}
