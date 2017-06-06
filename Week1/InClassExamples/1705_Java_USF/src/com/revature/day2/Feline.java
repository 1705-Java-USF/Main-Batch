package com.revature.day2;

public abstract class Feline implements Animal{
	
	int age = 10;
	
	//Note that in an abstract class, we can have both abstract and concrete methods.
	public Feline(){
		System.out.println("Constructed feline!");
	}

	@Override
	public void speak(){
		System.out.println("Feline noises!");
	}
	
	abstract void specificFelineThing();
}
