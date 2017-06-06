package com.revature.java_hw.q8;

import java.util.ArrayList;
import java.util.Arrays;

public class Palindromes {

	public static void main(String[] args) {
		//ArrayList of strings (given)
		ArrayList<String> words = new ArrayList<String>(Arrays.asList("karan", "madam", "tom", "civic", "radar",
				"sexes", "jimmy", "kayak", "john", "refer", "billy", "did"));
		
		//ArrayList palindromes to store result
		ArrayList<String> palindromes = new ArrayList<String>();
		
		//Loop through each word in the list of words
		for(String word : words) {
			//Set it as a palindrome
			boolean palindrome = true;
			//Loop through half the letters, comparing them to the other half in reverse order.
			//If they don't match, change palindrome to false and end the loop.
			for(int i=0; i<word.length()/2.0; i++) {
				if(word.charAt(i) != word.charAt(word.length()-1-i)) {
					palindrome = false;
					break;
				}
			}
			//If palindrome is still true, the word is a palindrome and gets added to the ArrayList.
			if(palindrome)
				palindromes.add(word);
		}
		
		//Prints out the palindromes
		System.out.println("Palindromes: " + palindromes);
	}

}
