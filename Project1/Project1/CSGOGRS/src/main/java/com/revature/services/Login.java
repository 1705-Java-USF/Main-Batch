package com.revature.services;

import java.util.List;

import com.revature.dao.PersonnelDAO;
import com.revature.dao.PersonnelDAOImpl;
import com.revature.pojos.Personnel;


public class Login {
	public boolean validateLogin(String user, String pass){
		PersonnelDAO pd = new PersonnelDAOImpl();
		List<Personnel> persons = pd.selectPersonnels();
		
		//Check each person in the database
		for(Personnel person : persons){
			//Return true if there is a username AND password match
			System.out.println(person.getUsername());
			if( user.equals(person.getUsername()) && pass.equals(person.getPassword()) ){
				return true;
			}
		}
		return false;
	}
	
	public String[] getAttributes(String user){
		PersonnelDAO pd = new PersonnelDAOImpl();
		Personnel u = pd.selectPersonnelByUser(user);
		
		//Want to return personnel (for now)
		// - fname
		// - lname
		// - email
		// - role
		String[] attributes = new String[5];
		attributes[0] = u.getFirstname();
		attributes[1] = u.getLastname();
		attributes[2] = u.getEmail();
		attributes[3] = u.getPrid() == 1 ? "FBI Manager" : "Counter-Terrorist";
		attributes[4] = String.valueOf(u.getId());
		return attributes;
	}
}
