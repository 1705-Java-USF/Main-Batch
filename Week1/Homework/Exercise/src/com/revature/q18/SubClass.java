package com.revature.q18;

public class SubClass extends SuperClass{

	@Override
	public boolean hasUpperCase(String s) {
		//checks to see if there is an upper case letter in the string
		for(int i = 0; i < s.length(); i++){
			//ranges for the uppercase letters
			if(s.charAt(i) >= 65 && s.charAt(i) <= 90){
				return true;
			}
		}
		//if it hasn't returned yet there is no Upper Case letter
		return false;
	}

	@Override
	public String toUpperCase(String s) {
		String result = "";
		for(int i = 0; i < s.length(); i++){
			//if the character is in the lower case range, it subtracts 32 to get into the
			//Upper Case range
			if(s.charAt(i) >= 97 && s.charAt(i) <= 122){
				result += (char)(s.charAt(i)-32);
			}
			else{
				//if its already upper case, keep it that way
				result += s.charAt(i);
			}
		}
		return result;
	}

	@Override
	public void printNumber(String s) {
		String result = "";
		for(int i = 0; i < s.length(); i++){
			//converts the character to the integer
			result += "" + (int)s.charAt(i);
		}
		//adds the newline character
		result+="10";
		//prints it out
		System.out.println(result);
	}

}
