package com.example.bean;

import java.util.HashSet;
import java.util.Set;

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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity //Entity indicates a db entity, written above class
@Table(name = "BEAR") //Table tag describes the table name for the class
//Cache annotation invokes a xml file describing second level cache
//	Tells hibernate to utilize the cache at this entitty.
/*
 * Essentially, the session cache which is at first level is at session 
 * level where it is only available for the individual, whereas SessionFactory
 * has a higher level scope cache where multiple users can get the cached
 * data from instead of hitting the database
 */
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "myAwesomeCache")
public class Bear {

	//@Id maps a primary key (unique, not null)
	//Main identifier of table
	@Id
	@Column(name = "BEAR_ID") //Column name of property, 
	//if no name set, property is used for column name (ie bearId in this case)
	
	//produce a sequence for auto-incrementing id
	//if no name given, defaults to "hibernate_sequence" which is BAD
	@SequenceGenerator(name = "BEARID_SEQ", sequenceName = "BEARID_SEQ")
	
	//Auto incrementing method (we used .SEQUENCE) which follows the 
	//typical flow of a sequence/ (1 by 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BEARID_SEQ")
	private int bearId;

	@Column(name = "BEAR_COLOR")
	private String bearColor;

	@Column(name = "BREED")
	private String breed;

	@Column(name = "HEIGHT")
	private double height;

	@Column(name = "WEIGHT")
	private double weight;

	/*
	 * @ManyToOne will create a relationship between two different entities/tables.
	 * These cardinality annotations apply to has-a relationships.
	 * (Many bears To One cave)
	 * 
	 * Fetch type defaults to LAZY as of hibernate 3 and above.
	 * EAGER = pull records from db stored to object with has-a relationship to other object
	 * 	and then populate all those objects which can have huge connections due to other objects
	 * 	possible has-a relationships
	 * LAZY = pull only the object of information needed (Recommended and faster
	 * but harder to set up)
	 * 
	 * CASCADETYPE = If main object is changed, all connecting objects are changed as well.
	 * The updates "cascade" down updating all the information
	 * Basically, cascadetype indicates how hibernate will maintain referential integrity.
	 * ie. delete a record with foregin key connections deletes that record and all 
	 * other records referencing it (Same for updates)
	 */
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	/*
	 * Use @JoinColumn with name: using cave_id column of the Cave table
	 */
	@JoinColumn(name = "CAVE_ID")
	private Cave bearHome;
	
	/*
	 * @ManyToMany require a join table/joint table to link the two tables together
	 * Ergo, the @JoinTable annotation.
	 * Here, the name attribute represents the join table we are creating/using.
	 *  joinColumns indicates the two columns that ultimate represent the many to many 
	 *  relationships
	 *  -We connect the tables using @JoinColumn with it's connecting inverseJoinCoumns
	 */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "PARENT_CUB", joinColumns = @JoinColumn(name = "PARENT_ID"), inverseJoinColumns = @JoinColumn(name = "CUB_ID"))
	private Set<Bear> bearCubs = new HashSet<>();

	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "HONEYPOT_ID")
	private HoneyPot honeyPot;

	public Bear() {

	}

	public Bear(String bearColor, String breed, double height, double weight, HoneyPot honeyPot) {
		super();
		this.bearColor = bearColor;
		this.breed = breed;
		this.height = height;
		this.weight = weight;
		this.honeyPot = honeyPot;
	}

	@Override
	public String toString() {
		return "Bear [bearId=" + bearId + ", bearColor=" + bearColor + ", breed=" + breed + ", height=" + height
				+ ", weight=" + weight + ", bearHome=" + bearHome + ", honeyPot=" + honeyPot + "]";
	}

	public Set<Bear> getBearCubs() {
		return bearCubs;
	}

	public void setBearCubs(Set<Bear> bearCubs) {
		this.bearCubs = bearCubs;
	}

	public int getBearId() {
		return bearId;
	}

	public void setBearId(int bearId) {
		this.bearId = bearId;
	}

	public String getBearColor() {
		return bearColor;
	}

	public void setBearColor(String bearColor) {
		this.bearColor = bearColor;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Cave getBearHome() {
		return bearHome;
	}

	public void setBearHome(Cave bearHome) {
		this.bearHome = bearHome;
	}

	public HoneyPot getHoneyPot() {
		return honeyPot;
	}

	public void setHoneyPot(HoneyPot honeyPot) {
		this.honeyPot = honeyPot;
	}

}
