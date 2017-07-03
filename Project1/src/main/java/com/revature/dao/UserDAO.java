package com.revature.dao;

import java.util.ArrayList;

import com.revature.pojo.EmployeeObject;

public interface UserDAO {

	public void createEmployee(EmployeeObject employee);
	public EmployeeObject selectEmployeeByUsername(String username);
	public ArrayList<EmployeeObject> selectEmployee();
	public EmployeeObject updateEmployee(EmployeeObject employee);
	public void deleteEmployeeById(int id);

}
