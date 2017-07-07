package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.revature.bean.NBAPlayer;
import com.revature.bean.NBATeam;
import com.revature.bean.Position;
import com.revature.util.HibernateUtil;

public class NBADaoImpl implements NBADao {

	@Override
	public NBAPlayer getNBAPlayerByName(String playerName) {
		Session session = HibernateUtil.getSession();
		NBAPlayer p = (NBAPlayer) session.get(NBAPlayer.class, playerName);
		session.close();
		return p;
	}

	@Override
	public void createNBAPlayer() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		NBAPlayer player1 = new NBAPlayer("Steph Curry",new NBATeam("Warriors","WEST","OAK"),new Position("Point Guard","Shooting Guard",1), 30, 29, 75, 190, "American");
		NBAPlayer player2 = new NBAPlayer("Russell WestBook",new NBATeam("OKC","WEST","OKC"),new Position("Point Guard","Shooting Guard",2), 0, 28, 75, 200, "American");
		NBAPlayer player3 = new NBAPlayer("Lebron James",new NBATeam("Cavs","EAST","CLE"),new Position("Small Forward","Shooting Guard",1), 23, 32, 80, 250, "American");
		NBAPlayer player4 = new NBAPlayer("James Harden",new NBATeam("Rockets","WEST","HOU"),new Position("Shooting Guard","Point Guard",1), 13, 27, 77, 220, "American");
		NBAPlayer player5 = new NBAPlayer("Kawhi Leonard",new NBATeam("Spurs","WEST","SAN"),new Position("Small Forward","Shooting Guard",1), 2, 26, 79, 230, "American");
		NBAPlayer player6 = new NBAPlayer("Manu Ginobli",new NBATeam("Spurs","WEST","SAN"),new Position("Shooting Guard","Small Forward",50), 20, 39, 78, 205, "Argentinian");
		NBAPlayer player7 = new NBAPlayer("Paul George",new NBATeam("OKC","WEST","OKC"),new Position("Small Forward","Shooting Guard",3), 13, 27, 81, 220, "American");
		NBAPlayer player8 = new NBAPlayer("Giannis Antetokounmpo",new NBATeam("Bucks","EAST","MIL"),new Position("Small Forward","Shooting Guard",8), 34, 22, 83, 222, "Greek");
		NBAPlayer player9 = new NBAPlayer("Kristaps Porzingis",new NBATeam("Knicks","EAST","NYC"),new Position("Power Forward","Center",1), 6, 21, 87, 240, "Latavian");

		session.save(player1);
		session.save(player2);
		session.save(player3);
		session.save(player4);
		session.save(player5);
		session.save(player6);
		session.save(player7);
		session.save(player8);
		session.save(player9);
		
		tx.commit();
		
		session.close();
	}
	
	public void deleteNBAPlayerByName(String playerName){
		Session session = HibernateUtil.getSession(); 
		Transaction tx = null;
		NBAPlayer p = null; 
	    
	    try{
	    	tx = session.beginTransaction();
	    	p = (NBAPlayer) session.get(NBAPlayer.class, playerName);
	    	session.delete(p);
	    	tx.commit();
	    	
	    	
	    }catch(HibernateException e){
	    	if(tx!=null){
	    		tx.rollback();
	    	}
	    	e.printStackTrace();
	    }finally{
	    	session.close();
	    }	
	}
	
	public NBAPlayer updateNBAPlayer(NBAPlayer p){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		p = null;
		
		 try{
		    	tx = session.beginTransaction();
		    	p = (NBAPlayer) session.createQuery("UPDATE PLAYER SET PLAYER_NUMBER = :?"
		    			+ "WHERE PLAYER_NAME = :? ").list();	//This method persists the object.
		    	
		    	tx.commit();
		    
		    	
		    }catch(HibernateException e){
		    	if(tx!=null){
		    		tx.rollback();
		    	}
		    	e.printStackTrace();
		    }finally{
		    	session.close();
		    }
		 return p;
	}

	@Override
	public void setNBAPlayer(NBAPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<NBAPlayer> getAllPlayers() {
		List<NBAPlayer> p = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null; 
		
		 try{
		    	tx = session.beginTransaction();
		    	p = session.createQuery("FROM PLAYER").list();	//HQL syntax FROM Employee
		    	
		    }catch(HibernateException e){
		    	if(tx!=null){
		    		tx.rollback();
		    	}
		    	e.printStackTrace();
		    }finally{
		    	session.close();
		    }
		return p;
	}

	@Override
	public NBATeam getTeamByName(String teamName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNBATeam(NBATeam team) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<NBATeam> getAllTeams() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position getPositionByName(String Position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPosition(Position position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Position> getAllHoneyPositions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NBAPlayer getOrLoad(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void criteriaDemo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void queryDemo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testCache() {
		// TODO Auto-generated method stub
		
	}

}
