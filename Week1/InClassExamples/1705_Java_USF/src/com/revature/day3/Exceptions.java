package com.revature.day3;

import java.io.FileInputStream;

public class Exceptions {

	public static void main(String[] args) {
		int[] arr = new int[4];
		
		//Runtime Exceptions
		//The following exceptions are not checked for by the compiler, thus the risk of them
		//occurring unhandled exists.
		
		//Place risky code into a try block
		try{
			//ArrayIndexOutOfBounds Exception
			for(int i = 0; i < 5; i++){
				arr[i] = 0;
			}
			
			//ArithmeticException
			System.out.println(5/arr[0]);
			
			FileInputStream fio = new FileInputStream("test.txt");
			/*
			 * The above risks a FileNotFoundException, which is part of IOException.
			 * This is an example of a CHECKED exception, since the compiler will consider unhandled
			 * code to be an error.
			 */
			
		}catch(ArithmeticException e){ //If an exception occurs, it is encapsualted as an object, "e" and you can interact with it
			System.out.println("An arithmetic exception occurred!");
			e.printStackTrace();
			
		}catch(Exception e){
			System.out.println("Exception in general, caught");
			e.printStackTrace();
		}finally{
			//All code within this block, WILL execute, regardless if an exception is caught or not!
			System.out.println("Finally block runs!");
			
			//Finally block ALWAYS runs, except for two exceptions:
			//-System.exit(0);
			//-An error occurs, such as StackOverflow, or OutOfMemory
		}
		
		
		System.out.println("End of execution.");
		
		
	}

}
