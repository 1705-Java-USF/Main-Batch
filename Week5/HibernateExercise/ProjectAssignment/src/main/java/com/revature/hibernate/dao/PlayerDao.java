package com.revature.hibernate.dao;

import java.util.List;

import com.revature.hibernate.bean.Player;

public interface PlayerDao {

	public void createPlayer(Player p);
	public Player getPlayer(int id);
	public Player getPlayer(String fname, String lname);
	public List<Player> getPlayers();
	public void updatePlayer(Player p);
	public void deletePlayer(Player p);
}
