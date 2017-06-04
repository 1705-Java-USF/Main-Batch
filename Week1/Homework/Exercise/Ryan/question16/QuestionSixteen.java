package com.revature.question16;

public class QuestionSixteen {

	public static void main(String[] args) {
		
		//shows the arguments and what they are after put into the command line. (run > run config > arguments tab > type arguments 
		//Separated by space
		System.out.println("arguments: " + args.length);
		for(int i = 0; i < args.length; i++){
			System.out.println(args[i]);
		}

	}

}
