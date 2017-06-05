package com.revature.question5;

public class SubstringMethod {

	
	 
	  
	  public static void main(String [] args) {
		  String str = "Test string for question 5 !"; //string to be tested
		  char array[] = str.toCharArray();			  //array to hold string 
		  boolean flag = false;
		  String result = "";

		  
		  for(int idx = 0; idx < array.length; idx++) //loop to go through substring
		  {
			  if(array[idx] == 'T'){
				  flag = true;
				  continue; 
			  }
			  if (array[idx] == '!')
				  break;
			  if(flag)
				  result += array[idx - 1]; //substring returned between 0 and index - 1
		  }
		System.out.println(result);
	  }
}
