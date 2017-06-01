package com.revature.day3;

import java.util.Comparator;

public class PersonComparatorByName implements Comparator<Person>{

	@Override
	public int compare(Person a, Person b) {
		return a.getName().compareTo(b.getName());
	}

	/*
	 * Use comparators to sort objects of your choice, by whatever you dictate the ordering should be.
	 * In this case, we made a comparator that will order our custom objects via the name field.
	 */
}
