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

@Entity
@Table(name = "BEAR")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "myAwesomeCache")
public class Bear {

	@Id
	@Column(name = "BEAR_ID")
	@SequenceGenerator(name = "BEARID_SEQ", sequenceName = "BEARID_SEQ")
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

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "CAVE_ID")
	private Cave bearHome;

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
