package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.mappings.Employee;
import com.revature.util.HibernateUtil;

public class EmployeeDAO implements EmployeeDAOInterface {

	@Override
	public void insertEmployee(Employee emp) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(emp);
			tx.commit();
		} catch(HibernateException e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		Session session = HibernateUtil.getSession();
		
		String hql = "FROM com.revature.hibex.mappings.Employee";
		Query query = session.createQuery(hql);
		List employees = query.list();
		
		session.close();
		
		return employees;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Session session = HibernateUtil.getSession();
		
		String hql = "FROM com.revature.hibex.mappings.Employee WHERE empId = :empId";
		Query query = session.createQuery(hql);
		query.setInteger("empId", id);
		Employee emp = (Employee) query.uniqueResult();
		
		session.close();
		
		return emp;
	}

	@Override
	public void setEmployee(Employee emp, String newFirstName) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			String hql = "UPDATE Employee SET firstName = :fname WHERE empId = :empId";
			tx = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setString("fname", newFirstName);
			query.setInteger("empId", emp.getEmpId());
			query.executeUpdate();
			tx.commit();
		} catch(HibernateException e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteEmployee(int id) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			//Employee emp = (Employee) session.get(Employee.class, id);
			tx = session.beginTransaction();
			String hql = "DELETE Employee WHERE empId = :id";
		    Query query = session.createQuery(hql);
		    query.setInteger("id", id);
		    query.executeUpdate();
		    tx.commit();
		   
		} catch(HibernateException e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
