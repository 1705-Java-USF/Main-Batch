package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.revature.mappings.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	static SessionFactory sessionFactory;
	
	public SessionFactory createSessionFactory() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
		return sessionFactory;
	}
	
	@Override
	public int insertEmployee(Employee emp) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer empId = null;
        
        try {
            tx = session.beginTransaction();
            empId = (Integer)session.save(emp); //This method persists the object.
            tx.commit();
            
        }
        catch(HibernateException e) {
            if(tx != null) {
            	tx.rollback();
            }
            e.printStackTrace();
        }
        finally {
        	session.close();
        }
        
        return empId;
    }

	@Override
	public Employee getEmployeeById(Integer id) {
		Session session = sessionFactory.openSession();
        Transaction tx = null;
        Employee emp = null;
        
        try {
            tx = session.beginTransaction();
            emp = (Employee)session.get(Employee.class, id);
            
            //session.delete(emp);
            //commit();
            //emp.setFirstName("asdkjflksdjf");
            
        }
        catch(HibernateException e) {
            if(tx != null) {
            	tx.rollback();
            }
            e.printStackTrace();
        }
        finally {
        	session.close();
        }
        
        return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> emps = null;
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
	            tx = session.beginTransaction();
		        emps = session.createQuery("FROM Employee").list(); //HQL
	            
	        }
	        catch(HibernateException e) {
	            if(tx != null) {
	            	tx.rollback();
	            }
	            e.printStackTrace();
	        }
	        finally {
	        	session.close();
	        }
	        
	     return emps;
	}

	@Override
	public void updateEmployee(Employee emp) {
		
		Session session = sessionFactory.openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            emp = (Employee)session.get(Employee.class, emp.getId());
            tx.commit();
            
        }
        catch(HibernateException e) {
            if(tx != null) {
            	tx.rollback();
            }
            e.printStackTrace();
        }
        finally {
        	session.close();
        }
	}

	@Override
	public void deleteEmployee(Integer id) {
		Session session = sessionFactory.openSession();
        Transaction tx = null;
        Employee emp = null;
        
        try {
            tx = session.beginTransaction();
            emp = (Employee)session.get(Employee.class, id);
            session.delete(emp);
            tx.commit();
            
        }
        catch(HibernateException e) {
            if(tx != null) {
            	tx.rollback();
            }
            e.printStackTrace();
        }
        finally {
        	session.close();
        }		
	}
	
}
