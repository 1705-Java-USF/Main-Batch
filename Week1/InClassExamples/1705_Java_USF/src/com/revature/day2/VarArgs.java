package com.revature.day2;

public class VarArgs {

	public static void main(String[] args) {
		System.out.println("My second main class...");
		
		VarArgs dr = new VarArgs();
		System.out.println(dr.sum(10));
		System.out.println(dr.sum(10, 15));
		System.out.println(dr.sum(10, 15, 20));
		System.out.println(dr.sum(10, 15, 20, 25, 30, 35));

		
	}
	
	
	
	//Method overloading
	//Same method signature, different parameters. All within the same class.
	//Compiler determines which method to call based on passed parameters.
	public int sum(int a){
		System.out.println("Version 1");
		return a;
	}
	
	public int sum(int a, int b){
		System.out.println("Version 2");
		return a + b;
	}
	
	public int sum(int a, int b, int c){
		System.out.println("Version 3");
		return a + b + c;
	}
	
	//varargs:
	//allows dynamic amount of variable parameters
	public int sum(int... is){
		//initialization; condition; incrementation
		
		int result = 0;
		for(int i = 0; i<is.length; i++){
			result += is[i];
		}
		
		return result;
	}
	
	//Signatures have the following format:
	//accessModifier(s) returnType name(parameters)
	public void methodSignature(){
		
	}

}
