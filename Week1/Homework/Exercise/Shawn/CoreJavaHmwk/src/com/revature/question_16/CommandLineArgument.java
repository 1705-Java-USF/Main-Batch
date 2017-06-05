package com.revature.question_16;

public class CommandLineArgument {

	public static void main(String[] args) {
		int chars = 0;
		for(String s : args)
			chars += s.length();
		System.out.println(chars);
	}
}