package com.revature.main;

import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.mappings.Company;
import com.revature.mappings.Employee;
import com.revature.mappings.Manager;



public class Driver {

	public static void main(String[] args) {
		
		EmployeeDao dao = new EmployeeDaoImpl();
		Company comp = new Company();
		Manager mng = new Manager();
		Employee e1 = new Employee("Stephen", "Georg", mng, comp);
		Employee e2 = new Employee("Adam", "Adamska", mng, comp);
		Employee e3 = new Employee("Derek", "Sirp", mng, comp);
		
		System.out.println("Inserted an employee with ID: " + dao.insertEmployee(e1));
		System.out.println("Inserted an employee with ID: " + dao.insertEmployee(e2));
		System.out.println("Inserted an employee with ID: " + dao.insertEmployee(e3));
		
		List<Employee> emps = dao.getAllEmployees();
		
		for(Employee e: emps) {
			System.out.println(e);
		}
		
		System.out.println(dao.getEmployeeById(4));
	}

}
