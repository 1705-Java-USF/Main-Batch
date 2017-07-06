package com.revature.dao;

import java.util.List;

import com.revature.mappings.Employee;

public interface EmployeeDao {
	
	public int insertEmployee(Employee e);
	public Employee getEmployeeById(Integer id);
	public List<Employee> getAllEmployees();
	public void updateEmployee(Employee e);
	public void deleteEmployee(Integer id);
	
	
}
