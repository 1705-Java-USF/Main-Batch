package com.revature.main;

import java.util.List;

import com.revature.bean.Employee;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;

public class Driver {

	public static void main(String[] args) {
		EmployeeDao dao = new EmployeeDaoImpl();
		Employee e1 = new Employee("Bobbert", "Bobson", "Bob@bob.bom", 2500);
		Employee e2 = new Employee("Adam", "Adamska", "A@D.AM", 2550);
		Employee e3 = new Employee("Ryan", "Lessley", "ryan.lessley@revature.com", 0);
		
		
		System.out.println("Inserted an employee with ID: " 
				+ dao.insertEmployee(e1));
		System.out.println("Inserted an employee with ID: " 
				+ dao.insertEmployee(e2));
		System.out.println("Inserted an employee with ID: " 
				+ dao.insertEmployee(e3));
		
		List<Employee> emps = dao.getAllEmployees();
		
		for(Employee e: emps){
			System.out.println(e);
		}
		
		System.out.println(dao.getEmployeeById(2));
		
	}

}
