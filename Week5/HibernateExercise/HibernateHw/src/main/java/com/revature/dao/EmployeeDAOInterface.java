package com.revature.dao;

import java.util.List;

import com.revature.mappings.Employee;

public interface EmployeeDAOInterface {
	void insertEmployee(Employee emp);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(int id);
	void setEmployee(Employee emp, String newFirstName);
	void deleteEmployee(int id);
}
