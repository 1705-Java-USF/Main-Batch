package com.revature.question7;

import java.util.ArrayList;

import com.revature.question7.EmployeeComparer.Settings;

public class CompareEmployees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1 = new Employee("A Name", "Z Deparment", 4000005);
		Employee e2 = new Employee("Different Name", "A department", 378);

		EmployeeComparer ec = new EmployeeComparer(Settings.AGE);
		ArrayList<Employee> al = new ArrayList<Employee>();
		al.add(e1);
		al.add(e2);
		al.sort(ec);
		System.out.println(al);
		System.out.println("AGE: " + ec.compare(e1, e2));
		ec.setSetting(Settings.NAME);
		al.sort(ec);
		System.out.println(al);
		System.out.println("Name: " + ec.compare(e1,e2));
		ec.setSetting(Settings.DEPARTMENT);
		al.sort(ec);
		System.out.println(al);
		System.out.println("Deparment: " + ec.compare(e1, e2));
	}

}
