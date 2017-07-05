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
@Table(name="COMPANY")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Cacheable

public class Company {
	@Id
	@Column(name="COMP_ID")
	@SequenceGenerator(sequenceName="COMP_SEQ", name="COMP_SEQ")
	@GeneratedValue(generator="COMP_SEQ", strategy=GenerationType.SEQUENCE)
	private int compId;
	
	@Column
	private String name;
	
	public Company() {
		
	}

	public Company(String name) {
		this.name = name;
	}

	public int getCompId() {
		return compId;
	}

	public void setCompId(int compId) {
		this.compId = compId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Company [mgrId=" + compId + ", name=" + name + "]";
	}
	
}
