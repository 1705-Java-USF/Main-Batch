package com.revature.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity 
@Table(name = "NBA_TEAM")
public class NBATeam {
	
	@Id 
	@Column(name = "TEAM_NAME")
	@SequenceGenerator(name = "TEAM_SEQ", sequenceName = "TEAM_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEAM_SEQ")
	private String teamName; 
	
	@Column(name = "CONFERENCE")
	private String conference;
	
	@Column(name = "CITY")
	private String city;
	
	@OneToMany(mappedBy = "playerTeam")
	private List<NBAPlayer> player;
	
	
	public NBATeam() {}
	
	public NBATeam(String teamName, String conference, String city) {
		super();
		this.teamName = teamName;
		this.conference = conference;
		this.city = city;
		//this.players = players;
	}

	public NBATeam(String teamName, String conference, String city, List<NBAPlayer> player) {
		super();
		this.teamName = teamName;
		this.conference = conference;
		this.city = city;
		//this.players = players;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getConference() {
		return conference;
	}

	public void setConference(String conference) {
		this.conference = conference;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<NBAPlayer> getPlayers() {
		return player;
	}

	public void setPlayers(List<NBAPlayer> player) {
		this.player = player;
	}

	@Override
	public String toString() {
		return "NBATeam [teamName=" + teamName + ", conference=" + conference + ", city=" + city + "]";
	}
	
	
	
	
	
}
