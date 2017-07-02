package com.revature.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.GunRequestsDAO;
import com.revature.dao.GunRequestsDAOImpl;
import com.revature.dao.PersonnelDAO;
import com.revature.dao.PersonnelDAOImpl;
import com.revature.pojos.Personnel;

public class ManageProfiles {
	
	public String[][] getProfiles(){
		PersonnelDAO pdao = new PersonnelDAOImpl();
		
		//Get all the current people
		List<Personnel> allPeople = pdao.selectPersonnels();
		
		//List of string arrays to restrict direct access to
		//Personnel objects in the front controller,
		//and not include sensitive details like passwords
		String[][] stringOfPeople = new String[allPeople.size()][6];
		

		int i = 0;
		for(Personnel person : allPeople){
			stringOfPeople[i][0] = person.getUsername();
			stringOfPeople[i][1] = person.getFirstname();
			stringOfPeople[i][2] = person.getLastname();
			stringOfPeople[i][3] = person.getEmail();
			stringOfPeople[i][4] = person.getPrid() == 1 ? "FBI Manager" : "Counter-Terrorist";
			stringOfPeople[i][5] = String.valueOf(person.getId());
			i++;
		}
		
		return stringOfPeople;
	}
	
	public void updatePersonnelInfo(
			String username,
			String password,
			String firstname,
			String lastname,
			String email,
			int prid){
		
		PersonnelDAO pdao = new PersonnelDAOImpl();
		if(password == ""){
			pdao.updatePersonnelByUser(username, firstname, lastname, email, prid);	
		}else{
			pdao.updatePersonnelByUser(username, password, firstname, lastname, email, prid);	
		}
		
	}	
	
	public void promoteById(String reqId){
		PersonnelDAO dao = new PersonnelDAOImpl();
	
		dao.promoteToManagerById(Integer.parseInt(reqId));
	
	}
}
