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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="LEAGUE")
public class League {
	@Id
	@Column(name="LID")
	@SequenceGenerator(name="LID_SEQ", sequenceName="LID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LID_SEQ")
	private int leagueID;
	
	@Column(name="LEAGUE_NAME")
	private String leagueName;
	
	@OneToMany(mappedBy="league")
	private List<Team> teams;
	public League(){
		
	}
	public League(String leagueName, List<Team> teams) {
		super();
		this.leagueName = leagueName;
		this.teams = teams;
	}
	public League(int leagueID, String leagueName, List<Team> teams) {
		super();
		this.leagueID = leagueID;
		this.leagueName = leagueName;
		this.teams = teams;
	}
	public int getLeagueID() {
		return leagueID;
	}
	public void setLeagueID(int leagueID) {
		this.leagueID = leagueID;
	}
	public String getLeagueName() {
		return leagueName;
	}
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	public List<Team> getTeams() {
		return teams;
	}
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	@Override
	public String toString() {
		return "League [leagueID=" + leagueID + ", leagueName=" + leagueName + ", teams=" + teams + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + leagueID;
		result = prime * result + ((leagueName == null) ? 0 : leagueName.hashCode());
		result = prime * result + ((teams == null) ? 0 : teams.hashCode());
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
		League other = (League) obj;
		if (leagueID != other.leagueID)
			return false;
		if (leagueName == null) {
			if (other.leagueName != null)
				return false;
		} else if (!leagueName.equals(other.leagueName))
			return false;
		if (teams == null) {
			if (other.teams != null)
				return false;
		} else if (!teams.equals(other.teams))
			return false;
		return true;
	}
}
