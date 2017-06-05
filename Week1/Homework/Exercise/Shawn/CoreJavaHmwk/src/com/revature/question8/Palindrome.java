package com.revature.question8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Palindrome {

	public static void main(String[] args) {
		List<String> words = new ArrayList<String>(
			Arrays.asList("karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy", "did"));
		List<String> palindromes = new ArrayList<String>();
		
		String reversedWord;
		
		// Iterate through words and store palindromes.
		for(String s : words) {
			reversedWord = "";
			
			// Reverse word.
			for(int i = s.length() - 1; i >= 0; i--) {
				reversedWord += s.substring(i, i + 1);
			}
			
			// Compare word with reversed word. If true, add to palindromes.
			if(s.equals(reversedWord)) {
				palindromes.add(s);
			}
		}
		
		// Print out palindromes.
		for(String s2 : palindromes) {
			System.out.println(s2);
		}
	}
}