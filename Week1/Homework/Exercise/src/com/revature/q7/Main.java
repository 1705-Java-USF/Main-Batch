package com.revature.q7;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String [] args){
		ArrayList<Employee> emps = new ArrayList<Employee>();
		emps.add(new Employee("DOT", "Nathan", 21));
		emps.add(new Employee("DOT", "Nathan", 22));
		emps.add(new Employee("DEM", "Nathan", 22));
		emps.add(new Employee("DEM", "Frank", 22));
		Collections.sort(emps, new Employee());
		System.out.println(emps);
	}
}