package com.revature.mappings;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="VEHICLE")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class Vehicle {

	@Id
	@Column(name="VEHICLE_ID")
	@SequenceGenerator(sequenceName="VEHICLE_SEQ", name="VEHICLE_SEQ")
	@GeneratedValue(generator="VEHICLE_SEQ", strategy=GenerationType.SEQUENCE)
	private int vehicleId;
	
	@OneToOne(mappedBy="vehicle", fetch=FetchType.EAGER)
	private Person owner;

	@Column(name="VEHICLE_TYPE")
	private String type;

	@Column(name="VEHICLE_MAKE")
	private String make;
	
	@Column(name="VEHICLE_MODEL")
	private String model;

	@Column(name="VEHICLE_YEAR")
	private int year;

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public Vehicle(Person owner, String type, String make, String model, int year) {
		super();
		this.owner = owner;
		this.type = type;
		this.make = make;
		this.model = model;
		this.year = year;
	}

	public Vehicle(){
		super();
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", owner=" + owner + ", type=" + type + ", make=" + make + ", model="
				+ model + ", year=" + year + "]";
	}
	
	
}
