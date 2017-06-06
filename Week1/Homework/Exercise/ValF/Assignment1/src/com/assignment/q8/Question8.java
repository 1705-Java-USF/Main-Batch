package com.assignment.q8;

import java.util.ArrayList;

public class Question8 {

	public static void main(String[] args) 
	{
		//Variables: original array, array to hold palindromes
		ArrayList<String> arr = new ArrayList<>();
		ArrayList<String> paliArr = new ArrayList<>();
		
		//populate original array
		arr.add("karan");
		arr.add("madam");
		arr.add("tom");
		arr.add("civic");
		arr.add("radar");
		arr.add("sexes");
		arr.add("jimmy");
		arr.add("kayak");
		arr.add("john");
		arr.add("refer");
		arr.add("billy");
		arr.add("did");
		
		//Cycle through original array, call isPalidrome() on each string
		//If isPalidrome returns true add to palindromes array
		for(String s : arr)
		{
			if(isPalindrome(s))
			{
				paliArr.add(s);
			}
		}
		
		System.out.println("Original Array: " + arr);
		System.out.println("Palidrome Array: " + paliArr);
		
	}
	
	//Recursive Palindrome function
	public static boolean isPalindrome(String str)
	{
		//If string is empy return true, word with even number of letters
		if(str.isEmpty())
			return true;
		//If here is one letter left return true, work with odd number of letters
		if(str.length() == 1)
			return true;
		//Compare first and last letters, if they're the same letter
		//make recursive call, pass substring without first and last letter
		if(str.charAt(0) == str.charAt(str.length() -1 ))
		{
			return isPalindrome(str.substring(1, str.length() - 1));
		}
		return false;
	}

}
