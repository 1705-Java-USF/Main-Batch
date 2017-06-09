package com.revature.main;

import com.revature.dao.FlashCardDAO;
import com.revature.dao.FlashCardDAOImpl;
import com.revature.pojos.FlashCard;

public class Driver {

	public static void main(String[] args) {
		FlashCardDAO dao = new FlashCardDAOImpl();
		
		FlashCard fc = new FlashCard("Can I insert with jave?", "Yes, with JDBC!");
		
		dao.createFlashCard(fc);
		
	}

}
