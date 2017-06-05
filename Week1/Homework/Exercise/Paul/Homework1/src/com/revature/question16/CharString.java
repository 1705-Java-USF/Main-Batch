package com.revature.question16;



public class CharString {

	//local variable counter named total
	private static int total;
	
	public static void main(String[] args) {
		
		//enhanced for loop to iterate through characters in 
		//a string from the Command Arguments 
		 for(String string : args){
			 total += string.length();		//returns length of the number of characters in string array
	          
	      }
		System.out.println("Total Number of Characters "
				+ "From Command Line Argument:  "
				 + total);
	}
	
}
