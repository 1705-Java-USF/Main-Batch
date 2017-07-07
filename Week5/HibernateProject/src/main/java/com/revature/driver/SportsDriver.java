package com.revature.driver;

import com.revature.bean.Athlete;
import com.revature.bean.League;
import com.revature.bean.Team;
import com.revature.dao.AthleteDaoImp;
import com.revature.dao.LeagueDaoImp;
import com.revature.dao.TeamDaoImp;

public class SportsDriver 
{

	public static void main(String[] args) 
	{
		LeagueDaoImp ldi = new LeagueDaoImp();
		TeamDaoImp tdi = new TeamDaoImp();
		//AthleteDaoImp adi = new AthleteDaoImp();
		
		
		League l1 = new League("NBA", "Basketball", null);
		League l2 = new League("NFL", "Football", null);
		
		Team t1 = new Team("MiamiHeat", l1);
		Team t2 = new Team("MiamiDolphins", l2);
		
		//Athlete a1 = new Athlete("Hassan", "Whiteside", 11, "Center", t1); 
		
		ldi.insertLeague(l1);
		ldi.insertLeague(l2);
		tdi.insertTeam(t1);
		tdi.insertTeam(t2);
		
		System.out.println("done.");
	}
}
