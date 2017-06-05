package com.revature.question18;

public class SubClass extends SuperClass {

	@Override
	public boolean hasCapital(String input) {
		for (int i = 0; i < input.length(); i++) { //Loop through characters checking to see if one is capital
			input.charAt(i);
			if (input.charAt(i) >= 65 && input.charAt(i) <= 90) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String upperCase(String input) {
		return input.toUpperCase(); //Simply return toUpperCase result
	}

	@Override
	public int getIntValue(String input) {
		int total = 0;
		for(int i = 0; i< input.length(); i++) //Loop through and add up the value of the char.
		{
			total += input.charAt(i);
		}
		return total;
	}

}
