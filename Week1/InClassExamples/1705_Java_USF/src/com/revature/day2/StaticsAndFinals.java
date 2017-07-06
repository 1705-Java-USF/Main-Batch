package com.revature.day2;

public class StaticsAndFinals{

	public static void main(String[] args) {
		//There are no active instances of StaticObject, so it's shared "count" variable is 0
		System.out.println(StaticObject.count);
		
		//Upon creating an instance of StaticObject, the constructor raises the shared variable
		//"count" by 1.
		StaticObject so = new StaticObject();
		
		//The specific instance "so" has a count of 1, since there is only one instance of StaticObject
		System.out.println(so.count);
		
		//We create a different StaticObject, which raises the shared variable "count" by 1, making it
		//2
		StaticObject so2 = new StaticObject();
		
		
		//Grabbing count from a specific instance will yield 2
		System.out.println(so2.count);
		//Grabbing count statically also yields 2.
		System.out.println(StaticObject.count);
		
		//Calling a static method statically
		System.out.println("====Static Method=====");
		StaticObject.printCount();
		
		//Final modifier
		/*
		 * Final enforces immutability for elements
		 */
		
		final int finalInt = 10; //We have created a constant! 
		//finalInt = 15; This is not allowed
		//Convention for constants is as such:
		final int FINAL_INT = 20;
		//Typically these will be stored in the instance scope as well
		
	}
/*
	public void doStuff(){
		System.out.println("Still doin stuff.");
	}
	Can NOT override final methods
	*/
}
