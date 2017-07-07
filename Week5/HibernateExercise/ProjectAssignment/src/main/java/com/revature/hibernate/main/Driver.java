package com.revature.hibernate.main;

import java.util.ArrayList;
import java.util.List;

import com.revature.hibernate.bean.League;
import com.revature.hibernate.bean.Player;
import com.revature.hibernate.bean.Team;
import com.revature.hibernate.dao.PlayerDao;
import com.revature.hibernate.dao.PlayerDaoImpl;

public class Driver {
	public static void main(String[] args)
	{
		PlayerDao pd = new PlayerDaoImpl();
		
		League nhl = new League();
		League ahl = new League();
		nhl.setLeagueName("NHL");
		ahl.setLeagueName("AHL");
		List<Team> nhlTeams = new ArrayList<Team>();
		List<Team> ahlTeams = new ArrayList<Team>();
		Team oil = new Team();
		Team red = new Team();
		Team pan = new Team();
		Team grr = new Team();
		oil.setTeamName("Edmonton Oilers");
		oil.setLeague(nhl);
		oil.setRoster(new ArrayList<Player>());
		red.setLeague(nhl);
		red.setTeamName("Detroit Red Wings");
		red.setRoster(new ArrayList<Player>());
		red.setMinorAffiliateTeam(grr);
		pan.setTeamName("Florida Panthers");
		pan.setLeague(nhl);
		pan.setRoster(new ArrayList<Player>());
		grr.setTeamName("Grand Rapid Griffins");
		grr.setLeague(ahl);
		
		Player mcJesus = new Player();
		Player jagr = new Player();
		Player sheahan = new Player();
		
		mcJesus.setAge(20);
		mcJesus.setfName("Connor");
		mcJesus.setlName("McDavid");
		mcJesus.setPositions("center");
		mcJesus.setTeam(oil);
		mcJesus.setSalary(0.832);
		
		pd.createPlayer(mcJesus);
		
		mcJesus.setSalary(12.5);
		
		pd.updatePlayer(mcJesus);
		
		jagr.setAge(45);
		jagr.setfName("Jaromir");
		jagr.setlName("Jagr");
		jagr.setPositions("Right Wing");
		jagr.setSalary(4.0);
		jagr.setTeam(pan);
		pd.createPlayer(jagr);
		
		pd.deletePlayer(jagr); 
		
		sheahan.setAge(25);
		sheahan.setfName("Riley");
		sheahan.setlName("Sheahan");
		sheahan.setPositions("AHLer center");
		sheahan.setSalary(2.075);
		sheahan.setTeam(red);
		
		pd.createPlayer(sheahan);
		
		sheahan.setTeam(grr);
		
		pd.updatePlayer(sheahan);
	
		
		
		
	}
}
