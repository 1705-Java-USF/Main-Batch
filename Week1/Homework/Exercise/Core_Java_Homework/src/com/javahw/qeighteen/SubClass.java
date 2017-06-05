package com.javahw.qeighteen;

//Subclass inherits from abstract parent class
public class SubClass extends SuperClass {

	//Check if any uppercase characters are in a string
	@Override
	boolean isAnyCharUpperCase(String str) {
		char[] arr = str.toCharArray();
		
		//Iterate through string 
		for(char c : arr){
			//Check for uppercase
			if(Character.isUpperCase(c))
				return true;
		}
		
		return false;
	}

	//Convert any lowercase characters to uppercase
	@Override
	String lowerToUpper(String str) {
		char[] arr = str.toCharArray();
		String arrU = "";
		
		for(char c : arr){
			c = (Character.toUpperCase(c));
			arrU += c;
		}
		
		return arrU;
	}
	
	//Parse integer from string and add 10 to it
	@Override
	Integer stringToIntegerPlusTen(String str) {
		return Integer.parseInt(str) + 10;
	}

}
