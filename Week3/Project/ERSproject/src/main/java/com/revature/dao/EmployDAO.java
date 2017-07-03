package com.revature.dao;

import java.util.Collection;

import com.revature.pojos.Employee;

public interface EmployDAO {

	public int loginEmployee(String username, String password);
	public void createEmployee(Employee e);
	public Collection<Employee> selectAllEmployees();
	public Employee selectEmployee(int employee_id);
	public void updateEmployee(Employee e);
	public void promoteEmployee(int employee_id);
	
}
