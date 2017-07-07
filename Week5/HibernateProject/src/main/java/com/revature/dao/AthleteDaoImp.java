package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.bean.Athlete;
import com.revature.util.HibernateUtil;

public class AthleteDaoImp implements AthleteDao
{

	@Override
	public int insertAthlete(Athlete athlete) 
	{
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Integer athleteId = null;
		
		try
		{
			tx = session.beginTransaction();
			athleteId = (Integer) session.save(athlete);
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
		
		return athleteId;
	}
	

	@Override
	public Athlete getAthlete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Athlete> getAllAthletes() {
		// TODO Auto-generated method stub
		return null;
	}

}
