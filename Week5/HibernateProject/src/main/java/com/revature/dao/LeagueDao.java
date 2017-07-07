package com.revature.dao;

import java.util.List;

import com.revature.bean.League;

public interface LeagueDao 
{
	public int insertLeague(League league);
	public League getLeague(Integer id);
	public List<League> getAllLeagues();
}
