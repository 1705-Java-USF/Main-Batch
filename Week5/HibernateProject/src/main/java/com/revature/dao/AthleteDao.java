package com.revature.dao;

import java.util.List;

import com.revature.bean.Athlete;

public interface AthleteDao 
{
	public int insertAthlete(Athlete athlete);
	public Athlete getAthlete(Integer id);
	public List<Athlete> getAllAthletes();
}
