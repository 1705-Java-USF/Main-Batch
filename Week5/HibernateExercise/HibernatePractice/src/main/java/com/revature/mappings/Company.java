package com.revature.mappings;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="Manager")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class Company {
	@Id
	@Column(name="COMP_ID")
	@SequenceGenerator(sequenceName="COMP_SEQ", name="COMP_SEQ")
	@GeneratedValue(generator="COMP_SEQ",
		strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="NAME")
	private String name;

	public Company(String name) {
		this.name = name;
	}
	
	public Company() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + "]";
	}	

}
