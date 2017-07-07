package com.revature.main;

import com.revature.dao.NBADao;
import com.revature.dao.NBADaoImpl;

public class Driver {
			
			public static void main(String[] args) {
				NBADao p = new NBADaoImpl();
//				p.createNBAPlayer();
//				
//				p.createNBAPlayer();
				
//				p.deleteNBAPlayerByName("Kawhi Leonard");
				
				p.getNBAPlayerByName("Lebron James");
	}
}
