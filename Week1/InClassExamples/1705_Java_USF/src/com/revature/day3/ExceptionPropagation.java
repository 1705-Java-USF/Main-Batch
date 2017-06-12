package com.revature.day3;

public class ExceptionPropagation {

	public static void main(String[] args) {
		ExceptionPropagation ep = new ExceptionPropagation();
/*		try{
			ep.method1();
		}catch(Exception e){
			e.getMessage();
		}*/
		try{
			ep.method1();
		}catch(Exception e){
			
		}
	}
	
	public void method1() throws MyCustomException{
		System.out.println("This is method1!");
		method2();
	}
	
	public void method2() throws MyCustomException{
		System.out.println("This is method2!");
		method3();

	}
	
	public void method3() throws MyCustomException{ //Use "throws" to propagate the exception to the calling method
		System.out.println("This is method3!");
		throw new MyCustomException(); //Use "throw" for testing your try catch blocks
	}

}
