package com.revature.q8;

import java.util.ArrayList;

public class ArrayListPalindromes {

	public static void main(String[] args) {

		String text = "Write a program that stores the following strings in an ArrayList and "
				+ "saves all the palindromes in another ArrayList:";
		String items[] = {"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy","billy", "did"};
		
		System.out.println(text);
		
		ArrayList<String> stringList = new ArrayList<String>(); // instantiating a new arrayList
		ArrayList<String> reverseList = new ArrayList<String>();
		
		for (String i : items)  // populating the array list with elements from items array
		{
			stringList.add(i);
		}
		
		System.out.println("Full ArrayList: " + stringList);   // displaying the populated array list
				
		for (String j : stringList)   // checking every item in the stringList
		{
			StringBuilder palindromes = new StringBuilder(j);  // instanciating new object 'palindromes' with StringBuilder, with iterable variable from String
			
			/*
			 * String tester = palindromes.reverse().toString();
			 * j.equals(tester)
			 */
			
			if (j.equals(palindromes.reverse().toString()))  // if the first words (unchaged) is the same as its palindromes,
			
			{
				reverseList.add(j);  // add it to the list
			}
			
		}
		System.out.println("Reversed ArrayList: " + reverseList);
	}

}
