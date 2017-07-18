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

@Entity		//Entity indicates a database entity, written above class
@Table(name = "BEAR")	//Table tag describes the table name for the class
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "myAwesomeCache")
//Cache annotation invokes a xml file describing second level cache
// 	Tells hibernate to utilize the cache at this entity.
public class Bear {
	
	//@Id maps a primary key, main identifier of table
	@Id
	@Column(name = "BEAR_ID") //Column name of property. If no name set, property name is used for column name
	@SequenceGenerator(name = "BEARID_SEQ", sequenceName = "BEARID_SEQ")
	//Produce a sequence for auto-incrementing id.
	//If no name given, defaults to "hibernate_sequence"
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BEARID_SEQ")
	//Auto incrementing method to be used. In this case we use SEQUENCE, which simply
	//follows typical flow of a sequence (1 by 1)
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
	 * EAGER = pull records from db stored to bject with has-a relationship to other objects and
	 * then populate all those objects which can have huge connections due to other possible has-a relationships
	 * LAZY = pull only the object of information needed. Recomended and faster but more difficult to set up.
	 * Fetch type defaults to LAZY as of hibernate 3 and above.
	 * Cascade type indicates how hibernate will maintain referential integrity. ie. delete a record with foreign key
	 * connections deletes that record and all other records referencing it. (Same goes for updates)
	 */
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "CAVE_ID")
	/*
	 * Use @JoinColumn with the name attribute matching the column you want as a reference.
	 */
	private Cave bearHome;
	
	/*
	 * @ManyToMany requires a join table/joint table to link the two tables together. Ergo, the @JoinTable annotation.
	 * Here, the name attribute represents the jointable we are creating/using.
	 * joinColumns(note the 's') indicates the two columns that ultimately represent the many to many relationship.
	 * 		-We connect the tables using a @JoinColumn, with it's connecting inverseJoinColumns
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
