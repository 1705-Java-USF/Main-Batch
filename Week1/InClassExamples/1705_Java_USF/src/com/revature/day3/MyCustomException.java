package com.revature.day3;

import java.io.IOException;

public class MyCustomException extends IOException{ //Simply extend the exception class choice to make this class a custom exception
	@Override //Proceed to customize your exception how you see fit.
	public String getMessage() {
		System.out.println("This was my custom exception!!!");
		return super.getMessage();
	}
	
	
}
