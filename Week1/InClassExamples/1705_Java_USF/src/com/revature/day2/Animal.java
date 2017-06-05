package com.revature.day2;

public interface Animal {
	/*
	 * Interfaces serve as a contract.
	 * You typically will only have method signatures with no bodies.
	 * So whichever class implements an interface, MUST provide a body for all
	 * methods included. (That are abstract)
	 */
	public void eat();
	public void sleep();
	
	//Default lets you bypass abstraction of methods
	default public void speak(){
		System.out.println("Animals make speaking sounds...");
	}
	
	static public void action(){
		System.out.println("Stuff");
	}
	
}
