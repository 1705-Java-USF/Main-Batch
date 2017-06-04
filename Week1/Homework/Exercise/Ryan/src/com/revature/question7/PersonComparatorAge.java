package com.revature.question7;

import java.util.Comparator;

public class PersonComparatorAge implements Comparator<Person>{
	//method to compare person by age
	@Override
	public int compare(Person a, Person b) {
		if(a.getAge() > b.getAge()){
			return a.getAge();
		}
		return 0;
	}
	
}

