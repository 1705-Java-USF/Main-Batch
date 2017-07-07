package com.revature.hibernate.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PLAYER")
public class Player {
	
	@Id
	@Column(name="PID")
	@SequenceGenerator(name="PID_SEQ", sequenceName="PID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PID_SEQ")
	private int playerID;
	
	@Column(name="PLAYER_FNAME")
	private String fName;
	
	@Column(name="PLAYER_LNAME")
	private String lName;
	
	@Column(name = "POSITION")
	private String positions;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="TID")
	private Team team;
	
	@Column(name="PLAYER_SAL")
	private double salary;
	
	@Column(name="PLAYER_AGE")
	private int age;
	
	public Player(){
		
	}

	public Player(String fName, String lName, String positions, Team team, double salary, int age) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.positions = positions;
		this.team = team;
		this.salary = salary;
		this.age = age;
	}

	public Player(int playerID, String fName, String lName, String positions, Team team, double salary, int age) {
		super();
		this.playerID = playerID;
		this.fName = fName;
		this.lName = lName;
		this.positions = positions;
		this.team = team;
		this.salary = salary;
		this.age = age;
	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getPositions() {
		return positions;
	}

	public void setPositions(String positions) {
		this.positions = positions;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Player [playerID=" + playerID + ", fName=" + fName + ", lName=" + lName + ", positions=" + positions
				+ ", team=" + team + ", salary=" + salary + ", age=" + age + "]";
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((fName == null) ? 0 : fName.hashCode());
		result = prime * result + ((lName == null) ? 0 : lName.hashCode());
		result = prime * result + playerID;
		result = prime * result + ((positions == null) ? 0 : positions.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((team == null) ? 0 : team.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (age != other.age)
			return false;
		if (fName == null) {
			if (other.fName != null)
				return false;
		} else if (!fName.equals(other.fName))
			return false;
		if (lName == null) {
			if (other.lName != null)
				return false;
		} else if (!lName.equals(other.lName))
			return false;
		if (playerID != other.playerID)
			return false;
		if (positions == null) {
			if (other.positions != null)
				return false;
		} else if (!positions.equals(other.positions))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		if (team == null) {
			if (other.team != null)
				return false;
		} else if (!team.equals(other.team))
			return false;
		return true;
	}
	
		
}
