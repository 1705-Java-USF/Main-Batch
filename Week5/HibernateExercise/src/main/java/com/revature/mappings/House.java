package com.revature.mappings;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="HOUSE")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class House {
	
	@Id
	@Column(name="HOUSE_ID")
	@SequenceGenerator(sequenceName="HOUSE_SEQ", name="HOUSE_SEQ")
	@GeneratedValue(generator="HOUSE_SEQ", strategy=GenerationType.SEQUENCE)
	private int houseId;
	
	@OneToMany(mappedBy="home", fetch=FetchType.EAGER)
	private Set<Person> people = new HashSet<Person>();
	
	@Column(name="HOUSE_FLOORS")
	private int floors;
	
	@Column(name="HOUSE_COLORS")
	private String colors;
	
	@Column(name="HOUSE_BEDS")
	private int beds;
	
	@Column(name="HOUSE_BATHS")
	private int baths;

	public int getHouseId() {
		return houseId;
	}

	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}

	public Set<Person> getPeople() {
		return people;
	}

	public void setPeople(Set<Person> people) {
		this.people = people;
	}

	public int getFloors() {
		return floors;
	}

	public void setFloors(int floors) {
		this.floors = floors;
	}

	public String getColors() {
		return colors;
	}

	public void setColors(String colors) {
		this.colors = colors;
	}

	public int getBeds() {
		return beds;
	}

	public void setBeds(int beds) {
		this.beds = beds;
	}

	public int getBaths() {
		return baths;
	}

	public void setBaths(int baths) {
		this.baths = baths;
	}

	
	@Override
	public String toString() {
		return "House [houseId=" + houseId + ", people=" + people + ", floors=" + floors + ", colors=" + colors
				+ ", beds=" + beds + ", baths=" + baths + "]";
	}

	
	public House(int floors, String colors, int beds, int baths) {
		super();
		this.floors = floors;
		this.colors = colors;
		this.beds = beds;
		this.baths = baths;
	}
	
	public House(){
		super();
	}
	
}
