package com.revature.bean;

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

@Entity
@Table(name = "Athlete")
public class Athlete 
{
	@Id
	@Column(name = "a_id")
	@SequenceGenerator(name = "a_id_seq", sequenceName = "a_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "a_id_seq")
	private int athleteId;
	
	@Column(name = "a_fname")
	private String fname;
	
	@Column(name = "a_lname")
	private String lname;
	
	@Column(name = "number")
	private Integer number;
	
	@Column(name = "position")
	private String position;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "Team")
	private Team team;
	
	public Athlete(){}
	
	public Athlete(int athleteId, String fname, String lname, Integer number, String position, Team team) {
		this.athleteId = athleteId;
		this.fname = fname;
		this.lname = lname;
		this.number = number;
		this.position = position;
		this.team = team;
	}
	
	public Athlete(String fname, String lname, Integer number, String position, Team team) {
		this.fname = fname;
		this.lname = lname;
		this.number = number;
		this.position = position;
		this.team = team;
	}

	public int getAthleteId() {
		return athleteId;
	}

	public void setAthleteId(int athleteId) {
		this.athleteId = athleteId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Athlete [athleteId=" + athleteId + ", fname=" + fname + ", lname=" + lname + ", number=" + number
				+ ", position=" + position + ", team=" + team + "]";
	}
	
}
