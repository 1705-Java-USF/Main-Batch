package com.revature.question8;

import java.util.ArrayList;

public class Palindromes {

	public static void main(String[] args) {
		
		//Array list palindrome to hold list of words to be checked if 
		//it is a palindrome or not
		
		ArrayList<String> palindrome = new ArrayList<String>(); 
		
		//adding string of words to the array list palindrome
		
		palindrome.add("karan");
		palindrome.add("madam");
		palindrome.add("tom");
		palindrome.add("civic");
		palindrome.add("radar");
		palindrome.add("sexes");
		palindrome.add("jimmy");
		palindrome.add("kayak");
		palindrome.add("refer");
		palindrome.add("john");
		palindrome.add("billy");
		palindrome.add("did");
		
		System.out.println("Is a Palidrome? True or False: ");
		
		System.out.println();
		
		//for each loop to print out the array list created from the string of 
		//words that were added to the array 
		for(String string : palindrome){ 
			System.out.println( string + " = " + isPalindrome(string));
		}
	
	//new array list to hold the words from the previous array 
	//the new array will only contain string of words that are
	//actually palindromes 
		
	ArrayList<String> newPalindromeList = new ArrayList<String>();
	
	//for each loop to check which string of words returned true value
	//if true the string of words will be added to the new array list
	
	for(String string : palindrome){
		if(isPalindrome(string) == true ) {
			newPalindromeList.add(string);
			}
		}
	System.out.println();
	
	System.out.println("====New Array List With Palindromes!=====");
	
	System.out.println();
	
	//for each loop to print out the new array list 
	
	for(String string : newPalindromeList){
		System.out.println(string);
		}
	
	}
	
	//constructor method used to check if string is a palindrome or not
	//method divides length of string into two parts
	//after divided iterates through characters to check if the last 
	//characters match
	//ex: (madam --> (mad)(am) --> (mm)(ad)(a) --> (a)(a) --> (d)
	//all characters would match so the word madam would return true! 
	public static boolean isPalindrome(String str) {    
	    int n = str.length();
	    for( int i = 0; i < n/2; i++ )
	        if (str.charAt(i) != str.charAt(n-i-1)) 
	    return false;
	    return true;    
	}
	
	
	
}