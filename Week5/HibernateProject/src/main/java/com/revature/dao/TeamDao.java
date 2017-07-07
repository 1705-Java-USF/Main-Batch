package com.revature.dao;

import java.util.List;

import com.revature.bean.Team;

public interface TeamDao
{
	public int insertTeam(Team team);
	public Team getAthlete(Integer id);
	public List<Team> getAllTeams();
}
