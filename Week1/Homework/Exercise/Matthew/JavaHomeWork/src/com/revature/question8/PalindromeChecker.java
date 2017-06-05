package com.revature.question8;

import java.util.ArrayList;
import java.util.Arrays;

import com.revature.question3.StringReverser;

public class PalindromeChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Array of strings
		String[] words = {"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy", "did"};
		ArrayList<String> wordList = new ArrayList<String>(Arrays.asList(words)); //add words to array list
		ArrayList<String> palindromes = new ArrayList<String>(); //create and instantiate palindromes array list
		for(String s : wordList) //go through each word checking if it is a palindrome
		{
			boolean result = isPalindrome(s);
			if(result)
			{
				palindromes.add(s); // if it is a palindrome add it to the palindrome array list
				System.out.println(s + " is a palindrome");
			}else
			{
				System.out.println(s + " is not a palindrome");
			}
		}
	}
	public static boolean isPalindrome(String in)
	{
		String reverse = StringReverser.reverseString(in); //use StringReverser from com.revature.question3
		
		if(reverse.equals(in)) //check to see if the reverse string equals the input string
		{
			return true;
		}else
		{
			return false;
		}
	}

}
