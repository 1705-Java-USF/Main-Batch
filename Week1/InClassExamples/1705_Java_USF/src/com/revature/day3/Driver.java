package com.revature.day3;

public class Driver {

	public static void main(String[] args) {
		SuperClass sp = new SuperClass();
		System.out.println("sp.s: " + sp.s);
		System.out.print("sp.supermethod: ");
		sp.superMethod();
		
		System.out.println("==================");
		
		SubClass sc = new SubClass();
		System.out.println("sc.s: " + sc.s);
		System.out.print("sc.supermethod: ");
		sc.superMethod();
		System.out.print("sc.submethod: ");
		sc.subMethod();
		
		System.out.println("==================");
		SuperClass sp2 = new SubClass();
		
		/*
		 * When you to "parent var = new child()"
		 * the object will take the parents instance varibles. (Variable shadowing)
		 * the object will take the childs implementation of methods.
		 * BUT, the object will only have access to the parents available methods.
		 */
		System.out.println(sp2.s);
		sp2.superMethod();
		//sp2.subMethod();
		
		//sp = sc;
		sc = (SubClass)sp;
		
		SuperClass parent = new SubClass();
		sc = (SubClass)parent;
		
		
		System.out.println("\n" + sc.s);
		
	}

}
