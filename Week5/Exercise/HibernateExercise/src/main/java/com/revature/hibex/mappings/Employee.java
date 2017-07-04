package com.revature.hibex.mappings;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="EMPLOYEE")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE) // READ_ONLY
@Cacheable

public class Employee {
	
	@Id
	@Column(name="EMP_ID")
	@SequenceGenerator(sequenceName="EMP_SEQ", name="EMP_SEQ")
	@GeneratedValue(generator="EMP_SEQ", strategy=GenerationType.SEQUENCE)
	private int empId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="MANAGER_ID")
	private Manager manager;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="COMPANY_ID")
	private Company company;
	
	public Employee() { // MANDATORY
		
	}
	
	public Employee(String firstName, String lastName, Manager manager, Company company) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.manager = manager;
		this.company = company;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", manager="
				+ manager + ", company=" + company + "]";
	}
}
