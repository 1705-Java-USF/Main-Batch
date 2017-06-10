package com.revature.day2;

public class Driver extends AccessModifiers{

	public static void main(String[] args) {
		AccessModifiers am = new AccessModifiers();

		System.out.println(am.pub);
		System.out.println(am.pro);
		System.out.println(am.def);
		//System.out.println(am.pri); only accessible to the class itself
		
		Driver d = new Driver();
		System.out.println(d.pub);
		System.out.println(d.pro);
		System.out.println(d.def);	
		//System.out.println(d.pri); only accessible to the class itself
		
		PojoExample pe = new PojoExample("Tim", 20);
		System.out.println("========Pojo Example======");
		System.out.println(pe.getName());
		pe.setName("Bobbert");
		System.out.println(pe.getName());
		
		System.out.println(pe); //Anything passed in a system.out.println will get its toString() value.
		
		PojoExample pe1 = new PojoExample("Todd", 25);
		PojoExample pe2 = new PojoExample("Todd", 25);
		
		System.out.println(pe1.equals(pe2)); //You must override equals() in order to get accurate value comparisons.
		
		
	}

}
