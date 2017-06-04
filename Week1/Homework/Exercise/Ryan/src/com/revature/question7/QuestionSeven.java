package com.revature.question7;

import java.util.ArrayList;
import java.util.List;

public class QuestionSeven {

	public static void main(String[] args) {
		
		List<Person> p = new ArrayList<>();
		//add the people to the array list
		p.add(new Person("Ryan", 24, "Development"));
		p.add(new Person("Steve", 45, "Accounting"));
		//need to have try/catch here as it the p.sort(null) line leads to exception
		try {
			p.sort(null); 
			for (Person a : p) {
				System.out.println(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//compare person by name
		p.sort(new PersonComparator());
		for (Person a : p) {
			System.out.println(a);
		}
		
		System.out.println("======DepartmentCompare=======");
		
		//compare person by department
		p.sort(new PersonComparatorDepartment());
		for (Person a : p) {
			System.out.println(a);
		}
		
		System.out.println("============AgeCompare=============");
		//compare person by age
		p.sort(new PersonComparatorAge());
		for (Person a : p){
			System.out.println(a);
		}
	

	}

}
