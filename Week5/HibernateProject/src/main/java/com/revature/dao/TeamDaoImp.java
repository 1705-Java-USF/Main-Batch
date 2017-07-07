package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.bean.Team;
import com.revature.util.HibernateUtil;

public class TeamDaoImp implements TeamDao
{

	@Override
	public int insertTeam(Team team) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Integer teamId = null;
		
		try
		{
			tx = session.beginTransaction();
			teamId = (Integer) session.save(team);
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
		return teamId;
	}

	@Override
	public Team getAthlete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Team> getAllTeams() {
		// TODO Auto-generated method stub
		return null;
	}

}
