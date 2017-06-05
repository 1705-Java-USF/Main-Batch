package com.revature.question_18;

public class ConcreteClass extends AbstractClass {

	@Override
	boolean isUpperCase(String input) {
		for(char c : input.toCharArray()){
			if(Character.isLowerCase(c))
				return false;
		}
		return true;
	}

	@Override
	String convertToUpperCase(String input) {
		return input.toUpperCase();
	}

	@Override
	Integer convertStringToInteger(String input) {
		return Integer.parseInt(input) + 10;
	}

}
