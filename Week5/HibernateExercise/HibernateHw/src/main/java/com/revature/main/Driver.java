package com.revature.main;

import java.util.List;

import org.hibernate.Session;

import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOInterface;
import com.revature.mappings.Company;
import com.revature.mappings.Employee;
import com.revature.mappings.Manager;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		EmployeeDAOInterface empDAO = new EmployeeDAO();
		
		// CRUD
		
		// CREATE (insert)
		//createThreeEmployees();
		
		// RETRIEVE (get all)
		//selectAllEmployees();

		// RETRIEVE (get one)
		//selectOneEmployee();
		
		// UPDATE (set)
		//empDAO.setEmployee((Employee) session.get(Employee.class, 150), "Joe");
		
		// DELETE (delete)
		empDAO.deleteEmployee(250);
	}

	private static void createThreeEmployees() {
		Session session = HibernateUtil.getSession();
		EmployeeDAOInterface empDAO = new EmployeeDAO();
		//empDAO.insertEmployee(new Employee("Unu", "Octium", (Manager) session.get(Manager.class, 3), (Company) session.get(Company.class, 2)));
		empDAO.insertEmployee(new Employee("Jojo", "Antler", (Manager) session.get(Manager.class, 4), (Company) session.get(Company.class, 3)));
		//empDAO.insertEmployee(new Employee("Muchi", "Pistako", (Manager) session.get(Manager.class, 6), (Company) session.get(Company.class, 1)));
	}

	private static void selectAllEmployees() {
		EmployeeDAOInterface empDAO = new EmployeeDAO();
		List<Employee> employees = empDAO.getAllEmployees();
		
		for(Employee employee : employees) {
			System.out.println(employee);
		}
	}
	
	private static void selectOneEmployee() {
		EmployeeDAOInterface empDAO = new EmployeeDAO();
		Employee emp1 = empDAO.getEmployeeById(150);
		
		System.out.println("id: " + emp1.getEmpId());
		System.out.println("fname: " + emp1.getFirstName());
		System.out.println("lname: " + emp1.getLastName());
	}
}
