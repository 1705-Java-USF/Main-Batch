package com.revature.service;

import java.util.LinkedList;
import java.util.List;

import com.revature.dao.ReinBurstDaoImp;
import com.revature.pojo.ErsUser;
import com.revature.pojo.ReinBurst;

//ABSTRACT ALL INTERACTIONS WITH REIMBURSEMENT DAO
public class GetReinBurst 
{
	public List<ReinBurst> getPending(ErsUser eu)
	{
		ReinBurstDaoImp dao = new ReinBurstDaoImp();
		List<ReinBurst> list = dao.selectReinBurstByAuthorPending(eu);
		
		return list;
	}
	
	public List<ReinBurst> getResolved(ErsUser eu)
	{
		ReinBurstDaoImp dao = new ReinBurstDaoImp();
		List<ReinBurst> list = dao.selectReinBurstByAuthorResolved(eu);
		
		return list;
	}
	
	public List<ReinBurst> getAll(int res)
	{
		ReinBurstDaoImp dao = new ReinBurstDaoImp();
		List<ReinBurst> list = dao.selectAllReinBurst(res);
		
		return list;
	}
	
	public void createRein(ErsUser eu, Double ammount, String descrip, String receipt, Integer type)
	{
		ReinBurstDaoImp dao = new ReinBurstDaoImp();
		dao.createReinBurstSP(eu, ammount, descrip, receipt, type);
	}
	
	public void updateReinBurst(Integer resolver, Integer reinId)
	{
		System.out.println("in service "+resolver + " " + reinId);
		ReinBurstDaoImp dao = new ReinBurstDaoImp();
		dao.updateReinBurst(reinId, resolver);
	}
	
	public List<ReinBurst> getAllByAuthor(Integer id)
	{
		ReinBurstDaoImp dao = new ReinBurstDaoImp();
		List<ReinBurst> list = dao.selectAllReinBurstByID(id);
		
		return list;
	}
}
