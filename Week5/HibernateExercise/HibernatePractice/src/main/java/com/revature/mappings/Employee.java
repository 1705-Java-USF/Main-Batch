package com.revature.mappings;

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
@Table(name="Employee")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class Employee {
	
	@Id
	@Column(name="EMP_ID")
	@SequenceGenerator(sequenceName="EMP_SEQ", name="EMO_SEQ")
	@GeneratedValue(generator="EMP_SEQ",
		strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="MNG_ID")
	private Manager manager;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="COMP_ID")
	private Company company;
	
	public Employee() { //MANDATORY
		
	}
	
	public Employee(String firstName, String lastName, Manager manager, Company company) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.setManager(manager);
		this.setCompany(company);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", manager=" + manager
				+ ", company=" + company + "]";
	}
	
}
