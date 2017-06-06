package Question7;

import java.util.ArrayList;
import java.util.Collections;

public class CompareEmployees  {

	public static void main(String[] args) {
		
		//Array list for employees and adds 3 different ones to it
		ArrayList<Employee> employees = new ArrayList<>();
		
		employees.add(new Employee("Michael", "Software Engineering", 23));
		employees.add(new Employee("Aaron", "Sales", 25));
		employees.add(new Employee("Steve", "HR", 21));
		
		//Sort by Age using the Collections class, then prints to console in order.
		Collections.sort(employees);
		System.out.println("Sort by age:" + employees);
		
		//Sort by Name using Collections class, then prints to console in order.
		Collections.sort(employees, new EmployeeComparatorByName());
		System.out.println("Sort by name:" + employees);
		
		//Sort by Department using Collections, then prints to console in order.
		Collections.sort(employees, new EmployeeComparatorByDepartment());
		System.out.println("Sort by department:" + employees);
	}
}
