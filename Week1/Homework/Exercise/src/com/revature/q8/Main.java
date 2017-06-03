package com.revature.q8;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args){
		//List of words being compared
		ArrayList<String> words = new ArrayList<String>();
		words.add("karan");
		words.add("madam");
		words.add("tom");
		words.add("civic");
		words.add("radar");
		words.add("sexes");
		words.add("jimmy");
		words.add("kayak");
		words.add("john");
		words.add("refer");
		words.add("billy");
		words.add("did");
		
		//empty list that will contain palindromes
		ArrayList<String> pals = new ArrayList<String>();
		for(String s : words){
			//if the value of the base string is equals to it reversed
			//add it to the palindrome list
			if(s.equals(new StringBuilder(s).reverse().toString())){
				pals.add(s);
			}
		}
		//print palindrome list
		for(String s: pals)
			System.out.println(s);
	}
}
