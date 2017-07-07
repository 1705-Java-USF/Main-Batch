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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TEAM")
public class Team {
	
	@Id
	@Column(name="TID")
	@SequenceGenerator(name="TID_SEQ", sequenceName="TID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TID_SEQ")
	private int teamId;
	
	@Column(name="TEAM_NAME")
	private String teamName;
	
	@OneToMany(mappedBy="team")
	private List<Player> roster;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="MINOR_TID")
	private Team minorAffiliateTeam;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="LID")
	private League league;
	public Team(){
		
	}
	public Team(String teamName, List<Player> roster, Team minorAffiliateTeam, Team majorAffiliateTeam, League league) {
		super();
		this.teamName = teamName;
		this.roster = roster;
		this.minorAffiliateTeam = minorAffiliateTeam;
		this.league = league;
	}
	public Team(int teamId, String teamName, List<Player> roster, Team minorAffiliateTeam, Team majorAffiliateTeam,
			League league) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.roster = roster;
		this.minorAffiliateTeam = minorAffiliateTeam;
		this.league = league;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public List<Player> getRoster() {
		return roster;
	}
	public void setRoster(List<Player> roster) {
		this.roster = roster;
	}
	public Team getMinorAffiliateTeam() {
		return minorAffiliateTeam;
	}
	public void setMinorAffiliateTeam(Team minorAffiliateTeam) {
		this.minorAffiliateTeam = minorAffiliateTeam;
	}
	public League getLeague() {
		return league;
	}
	public void setLeague(League league) {
		this.league = league;
	}
	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + ", roster=" + roster + ", minorAffiliateTeam="
				+ minorAffiliateTeam + ", league=" + league + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((league == null) ? 0 : league.hashCode());
		result = prime * result + ((minorAffiliateTeam == null) ? 0 : minorAffiliateTeam.hashCode());
		result = prime * result + ((roster == null) ? 0 : roster.hashCode());
		result = prime * result + teamId;
		result = prime * result + ((teamName == null) ? 0 : teamName.hashCode());
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
		Team other = (Team) obj;
		if (league == null) {
			if (other.league != null)
				return false;
		} else if (!league.equals(other.league))
			return false;
		if (minorAffiliateTeam == null) {
			if (other.minorAffiliateTeam != null)
				return false;
		} else if (!minorAffiliateTeam.equals(other.minorAffiliateTeam))
			return false;
		if (roster == null) {
			if (other.roster != null)
				return false;
		} else if (!roster.equals(other.roster))
			return false;
		if (teamId != other.teamId)
			return false;
		if (teamName == null) {
			if (other.teamName != null)
				return false;
		} else if (!teamName.equals(other.teamName))
			return false;
		return true;
	}
	

}
