package com.revature.dao;

import java.util.List;

import com.revature.pojo.ErsUser;
import com.revature.pojo.ReinBurst;

public interface ReinBurstDao 
{
	public void createReinBurstSP(ErsUser eu, Double ammount, String desc, String receipt, Integer type);
	
	public List<ReinBurst> selectAllReinBurst(int res);

	public List<ReinBurst> selectReinBurstByAuthorPending(ErsUser eu);

	public List<ReinBurst> selectReinBurstByAuthorResolved(ErsUser eu);

	public List<ReinBurst> selectAllReinBurstByID(int id);
}
