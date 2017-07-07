package com.revature.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.hibernate.bean.Player;
import com.revature.hibernate.util.HibernateUtil;

public class PlayerDaoImpl implements PlayerDao {

	@Override
	public void createPlayer(Player p) {
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			
			session.saveOrUpdate(p.getTeam());
			session.save(p);
			
			tx.commit();
			
		}finally{
			if(tx != null && !tx.wasCommitted())
			{
				tx.rollback();
			}
			if(session != null)
			{
				session.close();
			}
			
		}
	}

	@Override
	public Player getPlayer(int id) {
		Session session = null;
		try{ 
			session = HibernateUtil.getSession();
			return (Player) session.get(Player.class, id);
		}finally{
			if(session != null)
			{
				session.close();
			}
			
		}

	}

	@Override
	public Player getPlayer(String fname, String lname) {
		return null;
	}

	@Override
	public List<Player> getPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePlayer(Player p) {
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.update(p);
			
			tx.commit();
			
		}finally{
			if(session != null)
			{
				session.close();
			}
			if(tx != null && !tx.wasCommitted())
			{
				tx.rollback();
			}
		}

	}

	@Override
	public void deletePlayer(Player p) {
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.delete(p);
			
			tx.commit();
			
		}finally{
			if(tx != null && !tx.wasCommitted())
			{
				tx.rollback();
			}
			if(session != null)
			{
				session.close();
			}
		}

	}

}
