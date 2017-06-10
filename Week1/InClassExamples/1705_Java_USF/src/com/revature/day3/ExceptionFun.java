package com.revature.day3;

public class ExceptionFun {

	public static void main(String[] args) {
		ExceptionFun ef = new ExceptionFun();
		String s = ef.method();
		System.out.println(s);
		
		
	}
	public String method(){
		try{
			System.out.println(1/0);
		}catch(ArithmeticException e){
			return "CAUGHT";
		}finally{
			return "FINALLY";
		}
		//return "END";
	}

}
