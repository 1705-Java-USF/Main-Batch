package com.revature.mappings;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@NamedQueries({
	@NamedQuery(name="getAllPeople", query="FROM com.revature.mappings.Person")
})

@Entity
@Table(name="PERSON")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class Person {

	/*
	 * Sets column name to PERSON_ID
	 * Generates a sequence to increment the id and uses it
	 */
	@Id
	@Column(name="PERSON_ID")
	@SequenceGenerator(sequenceName="PERSON_SEQ", name = "PERSON_SEQ")
	@GeneratedValue(generator="PERSON_SEQ", strategy=GenerationType.SEQUENCE)
	private int personId;
	
	/*
	 * Sets up a column with a foreign key to the houses table
	 */
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="PERSON_HOME")
	private House home;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="VEHICLE_ID")
	private Vehicle vehicle;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="PARENT_CHILD", joinColumns=@JoinColumn(name="PERSON_ID"), inverseJoinColumns=@JoinColumn(name="CHILD_ID"))
	private Set<Person> children;
	
	@Column(name="PERSON_NAME")
	private String name;
	
	@Column(name="PERSON_WEIGHT")
	private double weight;
	
	@Column(name="PERSON_SALARY")
	private double salary;

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public House getHome() {
		return home;
	}

	public void setHome(House home) {
		this.home = home;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Set<Person> getChildren() {
		return children;
	}

	public void setChildren(Set<Person> children) {
		this.children = children;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", home=" + home + ", vehicle=" + vehicle + ", children=" + children
				+ ", name=" + name + ", weight=" + weight + ", salary=" + salary + "]";
	}
	

	public Person(House home, Vehicle vehicle, String name, double weight, double salary) {
		super();
		this.children = new HashSet<Person>();
		this.home = home;
		this.vehicle = vehicle;
		this.name = name;
		this.weight = weight;
		this.salary = salary;
	}
	
	public Person(){
		super();
		this.children = new HashSet<Person>();
	}
	
}
