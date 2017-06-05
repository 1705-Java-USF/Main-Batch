package com.revature.hmwk1;

import java.util.ArrayList;

public class Question8 {

	// Q8. Write a program that stores an ArrayList 
	// and saves palindromes in separate ArrayList
	
	final protected String[] LIST_GIVEN = {"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john",  "refer", "billy", "did"};
	protected ArrayList<String> list;
	protected ArrayList<String> palin;
	
	public Question8 () {
		// create arraylists and call the array method
		list = new ArrayList<String>();
		palin = new ArrayList<String>();
		array();
	}

	private void array() {
		// array method adds each string to an array
		// checks to see if the string is a palindrome by comparing it to it's reverse
		for (int i = 0; i < LIST_GIVEN.length; i++) {
			list.add(LIST_GIVEN[i]);
			String temp = new StringBuilder(LIST_GIVEN[i]).reverse().toString();
			if ( LIST_GIVEN[i].equals(temp) ) {
				palin.add(LIST_GIVEN[i]);
			}
		}
		System.out.println(list);
		System.out.println(palin);
	}
}
