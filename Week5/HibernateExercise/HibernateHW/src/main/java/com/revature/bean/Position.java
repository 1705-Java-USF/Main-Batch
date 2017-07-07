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
@Table(name = "POSITION")
public class Position {
	
	@Id
	@Column(name = "STARTING_POSTION")
	@SequenceGenerator(name = "STARTING_POSITION_SEQ", sequenceName = "STARTING_POSITION_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STARTING_POSITION_SEQ")
	private String startingPosition;
	
	@Column(name = "SECONDARY_POSITION")
	private String secPosition;
	
	@Column(name = "POSITION_RANK")
	private int positonRank;
	
	@OneToMany(mappedBy = "playerPostion")
	private List<NBAPlayer> position; 
	
	
	public Position() {
		super();
	}
	
	public Position(String startingPosition, String secPosition, int positonRank) {
		super();
		this.startingPosition = startingPosition;
		this.secPosition = secPosition;
		this.positonRank = positonRank;
	}

	public Position(String startingPosition, String secPosition, int positonRank,List<NBAPlayer> position) {
		super();
		this.startingPosition = startingPosition;
		this.secPosition = secPosition;
		this.positonRank = positonRank;
	}
	

	public String getStartingPosition() {
		return startingPosition;
	}


	public void setStartingPosition(String startingPosition) {
		this.startingPosition = startingPosition;
	}


	public String getSecPosition() {
		return secPosition;
	}


	public void setSecPosition(String secPosition) {
		this.secPosition = secPosition;
	}


	public int getPositonRank() {
		return positonRank;
	}


	public void setPositonRank(int positonRank) {
		this.positonRank = positonRank;
	}


	public List<NBAPlayer> getPosition() {
		return position;
	}


	public void setPosition(List<NBAPlayer> position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Position [startingPosition=" + startingPosition + ", secPosition=" + secPosition + ", positonRank="
				+ positonRank + "]";
	}

}
