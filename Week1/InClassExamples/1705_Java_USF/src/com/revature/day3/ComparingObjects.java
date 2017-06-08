package com.revature.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparingObjects {

	public static void main(String[] args) {
		List<Person> l = new ArrayList<>();
		l.add(new Person("Bobbert", 65));
		l.add(new Person("Adam", 42));
		l.add(new Person("Charles", 25));

		System.out.println(l);
		for (Person p : l) {
			System.out.println(p);
		}

		/*
		 * the sort() method expects a Comparator object to aid in sorting. If
		 * you do not use one then you will rely on the natural ordering of the
		 * object. ie. numbers from lowest to highest, letters in alphabetical
		 * order.
		 */

		try {
			l.sort(null); //This will yeild an exception
			for (Person p : l) {
				System.out.println(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * There is no natural ordering to custom objects. So in order to sort them, you have to
		 * define what makes the natural ordering of an object manually.
		 * This is achieved by implementing the comparable interface.
		 */
		
		System.out.println("=======Using a comparator=====");
		l.sort(new PersonComparatorByName());
		for (Person p : l) {
			System.out.println(p);
		}
		
		
		System.out.println("========Collections class======");
		Collections.sort(l);
		System.out.println(l);
		Collections.sort(l, new PersonComparatorByName());
		System.out.println(l);
		
		
	}
}
