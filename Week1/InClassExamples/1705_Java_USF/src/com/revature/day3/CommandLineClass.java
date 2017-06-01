package com.revature.day3;

public class CommandLineClass {

	public static void main(String[] args) {
		/*
		 * String[] args is required for every main method.
		 * It serves to provide arguments passed at the start of the
		 * execution.
		 */
		
		/*
		 * Passing arguments the easy way:
		 * Click in the menu:
		 * 	run > run configurations > (click the arguments tab) > write arguments separated by 'space'
		 * 
		 * Passing arguments the fun way:
		 * 1. Navigate to the "src" folder of your project via commandPrompt (or terminal)
		 * 2. invoke compiler via: "javac"
		 * 3. as a parameter for you javac, write the path to your java file that contains the main method.
		 * 	3.5: e.g.: java com/revature/day3/CommandLineClass.java
		 * 4. Next execute the application using "java"
		 * 	4.5 e.g. java com.revature.day3.CommandLineClass arg1 arg2 arg3 etc
		 * 
		 */
		System.out.println("arguments: " + args.length);
		for(int i = 0; i < args.length; i++){
			System.out.println(args[i]);
		}
		
	}
}
