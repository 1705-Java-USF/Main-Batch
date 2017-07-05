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
@Table(name="MANAGER")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Cacheable

public class Manager {
	@Id
	@Column(name="MGR_ID")
	@SequenceGenerator(sequenceName="MGR_SEQ", name="MGR_SEQ")
	@GeneratedValue(generator="MGR_SEQ", strategy=GenerationType.SEQUENCE)
	private int mgrId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="COMPANY_ID")
	private Company company;
	
	public Manager() {
		
	}

	public Manager(String firstName, String lastName, Company company) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
	}

	public int getMgrId() {
		return mgrId;
	}

	public void setMgrId(int mgrId) {
		this.mgrId = mgrId;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Manager [mgrId=" + mgrId + ", firstName=" + firstName + ", lastName=" + lastName + ", company="
				+ company + "]";
	}
}
