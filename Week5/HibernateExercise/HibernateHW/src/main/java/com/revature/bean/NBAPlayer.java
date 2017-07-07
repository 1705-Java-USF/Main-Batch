package com.revature.bean;

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
@Table(name = "PLAYER")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "myAwesomeCache")



public class NBAPlayer {

	@Id
	@Column(name = "PLAYER_NAME")
	@SequenceGenerator(name = "PLAYERID_SEQ", sequenceName = "PLAYERID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PLAYERID_SEQ")
	private String playerName;
	
	
	@Column(name = "PLAYER_NUMBER")
	private int playerNum;
	
	@Column(name = "PLAYER_AGE")
	private int playerAge;
	
	@Column(name = "PLAYER_HEIGHT")
	private double playerHeight;
	
	@Column(name = "PLYAER_WEIGHT")
	private double playerWeight;
	
	@Column(name = "PLAYER_NATIONALITY")
	private String playerNat;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "STARTING_POSTION")
	private Position playerPosition;
	
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "NBA_PLAYER_POSITION", joinColumns = @JoinColumn(name = "STARTING_POSITION"), inverseJoinColumns = @JoinColumn(name = "POSTION_RANK"))
//	private Set<NBAPlayer> players = new HashSet<>();
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "TEAM_NAME")
	private NBATeam playerTeam;
	
	
	public NBAPlayer(String playerName, NBATeam playerTeam, Position playerPosition, int playerNum, 
			int playerAge, double playerHeight, double playerWeight,String playerNat) {
		super();
		this.playerName = playerName;
		this.playerNum = playerNum;
		this.playerAge = playerAge;
		this.playerHeight = playerHeight;
		this.playerWeight = playerWeight;
		this.playerNat = playerNat;
		this.playerTeam = playerTeam;
		this.playerPosition = playerPosition;
	}

	public NBAPlayer() {}

	public NBATeam getPlayerTeam() {
		return playerTeam;
	}

	public void setPlayerTeam(NBATeam playerTeam) {
		this.playerTeam = playerTeam;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerID(String playerName) {
		this.playerName = playerName;
	}

	public int getPlayerNum() {
		return playerNum;
	}

	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}

	public int getPlayerAge() {
		return playerAge;
	}

	public void setPlayerAge(int playerAge) {
		this.playerAge = playerAge;
	}

	public double getPlayerHeight() {
		return playerHeight;
	}

	public void setPlayerHeight(double playerHeight) {
		this.playerHeight = playerHeight;
	}

	public double getPlayerWeight() {
		return playerWeight;
	}

	public void setPlayerWeight(double playerWeight) {
		this.playerWeight = playerWeight;
	}

	public String getPlayerNat() {
		return playerNat;
	}

	public void setPlayerNat(String playerNat) {
		this.playerNat = playerNat;
	}

	public Position getPlayerPosition() {
		return playerPosition;
	}

	public void setPlayerPosition(Position playerPosition) {
		this.playerPosition = playerPosition;
	}

	@Override
	public String toString() {
		return "NBAPlayer [playerName=" + playerName + ", playerNum=" + playerNum + ", playerAge=" + playerAge
				+ ", playerHeight=" + playerHeight + ", playerWeight=" + playerWeight + ", playerNat=" + playerNat
				+ ", playerPosition=" + playerPosition + ", playerTeam=" + playerTeam + "]";
	}
	
	
	
	
}
