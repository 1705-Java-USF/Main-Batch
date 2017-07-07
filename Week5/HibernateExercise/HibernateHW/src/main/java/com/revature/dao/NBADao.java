package com.revature.dao;

import java.util.List;

import com.revature.bean.NBAPlayer;
import com.revature.bean.NBATeam;
import com.revature.bean.Position;

public interface NBADao {
	public NBAPlayer getNBAPlayerByName(String playerName);

	public void createNBAPlayer();

	public void setNBAPlayer(NBAPlayer player);
	
	public void deleteNBAPlayerByName(String playerName);
	
	public NBAPlayer updateNBAPlayer(NBAPlayer p);

	public List<NBAPlayer> getAllPlayers();

	public NBATeam getTeamByName(String teamName);

	public void setNBATeam(NBATeam team);

	public List<NBATeam> getAllTeams();

	public Position getPositionByName(String Position);

	public void setPosition(Position position);

	public List<Position> getAllHoneyPositions();

	public NBAPlayer getOrLoad(int id);

	public void criteriaDemo();

	public void queryDemo();

	public void testCache();
}
