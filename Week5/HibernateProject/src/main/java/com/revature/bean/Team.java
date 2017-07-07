package com.revature.bean;

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
@Table(name = "Team")
public class Team 
{
	@Id
	@Column(name = "t_id")
	@SequenceGenerator(name = "t_id_seq", sequenceName = "t_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_id_seq")
	private int teamId;
	
	@Column(name = "t_name")
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "League")
	private League league;
	
	/*
	@OneToMany(mappedBy = "team")
	private List players;
	*/	
	public Team(){}
	
	public Team(int teamId, String name, League league) {
		this.teamId = teamId;
		this.name = name;
		this.league = league;
	}
	
	public Team(String name, League league) {
		this.name = name;
		this.league = league;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", name=" + name + ", league=" + league + "]";
	}

	/*
	public List getPlayers() {
		return players;
	}

	public void setPlayers(List players) {
		this.players = players;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", name=" + name + ", league=" + league + ", players=" + players + "]";
	}*/

}
