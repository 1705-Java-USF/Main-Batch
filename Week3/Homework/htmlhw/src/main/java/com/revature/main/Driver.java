package com.revature.main;

import com.revature.dao.PersonnelDAO;
import com.revature.dao.PersonnelDAOImpl;
import com.revature.pojos.Personnel;

public class Driver {

	public static void main(String[] args) {
		PersonnelDAO pdao = new PersonnelDAOImpl();
		/*
		 * ID #
		 * USER
		 * PASS
		 * FNAME
		 * LNAME
		 * EMAIL
		 * ROLE #
		 *  1: FBI manager
		 *  2: Counter-Terrorist
		 */
		Personnel fc = new Personnel(
				1,
				"fbitop",
				"imthebest",
				"Carlos",
				"Rubiano",
				"fbi@gmail.com",
				1
				);
		
		
		pdao.createPersonnel(fc);
		System.out.println(pdao.selectPersonnels().toString());
		
		System.out.println("did this run and compile");
	}

}
