package com.revature.day3;

public class CastingExample {

	public static void main(String[] args) {
		int i = 1000;
		short s = 1000;
		long l = 1000l;
		double d = 1000.0;
		byte b = 127;
		char c = 'a';
		float f = 5f;
		boolean bool = false;
		
		/*
		 * Casting is changing a datatype or object type through the use of (date/objecttype)
		 */
		
		i = (int)d; //Explicit casting
		d = i; 		//Implicit Casting
		
		//downcasting and upcasting
		//upcasting: Casting from a larger memory allocation to a smaller
		//downcasting: Casting from a smaller memory allocation to a bigger
		
		i = s;
		s = (short)i;
		d = f;
		f = (float)d;
		
		c = (char)b;
		b = (byte)c;
		
		i = c;
		s = (short)c;
		l = c;
	
	}

}
