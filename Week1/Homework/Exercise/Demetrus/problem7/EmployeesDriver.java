/* Demetrus Atkinson
 * 
 */
package com.revature.problem7;

import java.util.ArrayList;
import java.util.List;

public class EmployeesDriver {

	public static void main(String[] args) {

		// new List of Employees
		List<Employees> emp = new ArrayList<>();

		// add these Employees to the ArrayList
		emp.add(new Employees("Saul", 26, "boxer"));
		emp.add(new Employees("Gennady", 35, "puncher"));

		// print original contents
		System.out.println("====Original List=====");
		System.out.println(emp);
		System.out.println("--------------------");

		// print sorted by name
		System.out.println("=====Sorted by name====");
		emp.sort(new EmployeeNameComparator());
		System.out.println(emp);
		System.out.println("--------------------");

		// sorted by department
		System.out.println("=====Sorted by department====");
		emp.sort(new EmployeeDepartmentComparator());
		System.out.println(emp);
		System.out.println("--------------------");

		// print sorted by age
		System.out.println("=====Sorted by age====");
		emp.sort(new EmployeeAgeComparator());
		System.out.println(emp);
	}
}
