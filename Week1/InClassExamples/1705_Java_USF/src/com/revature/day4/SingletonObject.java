package com.revature.day4;

public class SingletonObject {
	//To keep track of how many instances exist at a time.
	//This is for demonstration purposes only.
	static int instanceCount;
	
	//You must make the single reference private, AND static in order to access it.
	private static SingletonObject so;
	
	/*
	 * The constructor of a singleton MUST be private in order to prevent outside classes from invoking
	 * their own instance of it.
	 */
	private SingletonObject(){
		instanceCount++;
	}
	
	/*
	 * You will need a getter that will check if an instance already exists, if it doesn't,
	 * you will create the new instance then return it.
	 * If the instance CURRENTLY exists, you can simply just pass the existing one.
	 */
	static public SingletonObject getSingleton(){
		if(so == null){
			so = new SingletonObject();
		}
		return so;
	}
	
	
}
