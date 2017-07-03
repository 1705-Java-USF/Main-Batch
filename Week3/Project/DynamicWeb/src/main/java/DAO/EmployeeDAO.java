package DAO;

import java.util.List;

import Database.EmployeePOJO;

public interface EmployeeDAO {
	
	public void AddEmployee(EmployeePOJO emp);
	public void DeleteEmployee(int id);
	public List<EmployeePOJO> getAllEmps();
	public EmployeePOJO selectEmpByID(int id);
	public String selectPassByLogin(String name);
	public EmployeePOJO selectEmpByUser(String user);
	public void UpdateEmployee(EmployeePOJO emp);
	public void ChangePassword(String username, String password);
	public void UpdateEmpInfo(String username,
							  String address,
							  String city,
							  String state,
							  String zip,
							  String phone,
							  String email);
	public int GetMaxId();

}
