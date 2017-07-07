package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.bean.League;
import com.revature.util.HibernateUtil;

public class LeagueDaoImp implements LeagueDao
{

	@Override
	public int insertLeague(League league) 
	{
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Integer leagueId = null;
		
		try
		{
			tx = session.beginTransaction();
			leagueId = (Integer) session.save(league);
			tx.commit();
		}
		catch(HibernateException e)
		{
			if(tx != null)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return leagueId;
	}

	@Override
	public League getLeague(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<League> getAllLeagues() {
		// TODO Auto-generated method stub
		return null;
	}

}
