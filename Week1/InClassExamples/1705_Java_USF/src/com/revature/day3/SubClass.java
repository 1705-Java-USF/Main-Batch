package com.revature.day3;

public class SubClass extends SuperClass{
	String s = "Subclass!";
	
	public void superMethod(){
		System.out.println("SuperMethod: SubClass edition");
	}
	public void subMethod(){
		System.out.println("SubClass Method.");
	}
}
