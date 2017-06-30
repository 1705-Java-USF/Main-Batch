package com.revature.dao;

import java.util.List;

import com.revature.bean.Employee;

public interface EmployeeDao {

	public int insertEmployee(Employee emp);
	public Employee getEmployeeById(Integer Id);
	public List<Employee> getAllEmployees();
	public void setEmployee(Employee emp);
	public void deleteEmployee(Integer id);
	
}
