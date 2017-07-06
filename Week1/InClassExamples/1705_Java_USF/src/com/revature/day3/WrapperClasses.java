package com.revature.day3;

import java.util.ArrayList;

public class WrapperClasses {

	public static void main(String[] args) {
		/*
		 * Wrapper classes are teh object form wrapped around primitive values.
		 */
		
		int i = 0;
		
		Integer in = new Integer(2);
		System.out.println(in*in);
		
		double d = in.doubleValue();
		System.out.println(d);
		
		Integer i2 = 5; //<-- also autoboxing
		Double d2;
		Float f;
		Character c;
		Boolean bool;
		Short s;
		Long l = 0L;
		Byte b;
		
		ArrayList al = new ArrayList();
		al.add(5); //Storing the primitive integer 5, gets automatically converted to its wrapper class.
		System.out.println(al);
		
		System.out.println(al.get(0).getClass());
		//When a primitive is implicitly wrapped by its wrapper class, this is called autoboxing.
		
		WrapperClasses wc = new WrapperClasses();
		wc.takePrimitive(i2);
		
		System.out.println(l.MAX_VALUE);
		
		//Syntax for numbers
		long l2 = 120_398__109_283l;
		System.out.println(l2);
		
		double d3 = 91_23123_12.1_2312_3;
		
	}
	public void takePrimitive(int i){
		//Though I pass in an object, it gets autounboxed to its primitive state.
	}

}
