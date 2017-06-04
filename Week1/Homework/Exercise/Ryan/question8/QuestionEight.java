package com.revature.question8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class QuestionEight {
	
	

	public static void main(String[] args) {
		
		// create the array list
		List<String> list = new ArrayList<>(Arrays.asList("karan" , "madam" , "tom" , "civic" , "radar" , "sexes" , "jimmy" , "kayak" , "john" , "refer" , "billy" , "did"));
		
		//create space for the new arraylist for the palindrome
		List<String> palindromeList = new ArrayList<String>();
		
		//Get the individual strings out of the array list
		for(int i = 0; i < list.size(); i++){
			
			String s = list.get(i);
			
			//reverse that string and check if equal. if it is add it to the palindromelist
			if(new StringBuilder(s).reverse().toString().equals(s)){
				palindromeList.add(s);
				System.out.println(s);
			}
			
			
			
			
		}
		
		
		
		
		
		
		

	}

}
