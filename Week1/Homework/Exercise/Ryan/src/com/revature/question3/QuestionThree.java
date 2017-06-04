package com.revature.question3;

public class QuestionThree {

	public static void main(String[] args) {
		
		//Declare the string
		String helloWorld = "hello world!";
		
		
		//Loop to reverse string
		for(int i = 0; i < helloWorld.length(); i++){
			helloWorld = helloWorld.substring(1, helloWorld.length() - i)
					+ helloWorld.substring(0 , 1)
					+ helloWorld.substring(helloWorld.length() - i, helloWorld.length());
		}
		
		System.out.println(helloWorld);

	}

}
