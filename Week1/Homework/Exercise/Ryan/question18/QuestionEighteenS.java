package com.revature.question18;

public class QuestionEighteenS extends QuestionEighteenA{
	
	@Override
	public boolean checkUpperCase(String s) {
		//checks to see if there is an upper case letter
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) >= 65 && s.charAt(i) <= 90){
				return true;
			}
		}
		return false;
	}

	@Override
	public String changeUpperCase(String s) {
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
	public void convertToNumber(String s) {
		String result = "";
		for(int i = 0; i < s.length(); i++){
			//converts the string to the integer
			result += "" + (int)s.charAt(i);
		}
		//adds 10 to the newly found number
		result+="10";
		//prints it out
		System.out.println(result);
	}

}

