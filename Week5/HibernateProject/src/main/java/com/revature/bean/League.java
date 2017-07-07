package com.revature.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "League")
public class League 
{
	@Id
	@Column(name = "l_id")
	@SequenceGenerator(name = "l_id_seq", sequenceName = "l_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "l_id_seq")
	private int leagueId;
	
	@Column(name = "l_name")
	private String name;
	
	@Column(name = "sport")
	private String sport;

	@OneToMany(mappedBy = "league")
	private List<Team> teams;
	
	public League(){}
	
	public League(int leagueId, String name, String sport, List<Team> teams) {
		this.leagueId = leagueId;
		this.name = name;
		this.sport = sport;
		this.teams = teams;
	}
	
	public League(String name, String sport, List<Team> teams) {
		this.name = name;
		this.sport = sport;
		this.teams = teams;
	}

	public int getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(int leagueId) {
		this.leagueId = leagueId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	@Override
	public String toString() {
		return "League [leagueId=" + leagueId + ", name=" + name + ", sport=" + sport + ", teams=" + teams + "]";
	}

	
}
