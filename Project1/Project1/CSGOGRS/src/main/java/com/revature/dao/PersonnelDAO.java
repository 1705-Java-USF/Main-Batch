package com.revature.dao;

import java.util.List;

import com.revature.pojos.Personnel;

//Data Access Object
public interface PersonnelDAO {
	
	public void createPersonnel(Personnel fc);
	public Personnel selectPersonnelById(int id);
	public List<Personnel> selectPersonnels();
	public void deletePersonnelById(int id);
	
	public Personnel selectPersonnelByUser(String user);
	public void updatePersonnelByUser(
			String username,
			String password,
			String firstname,
			String lastname,
			String email,
			int prid
			);
	public void updatePersonnelByUser(
			String username,
			String firstname,
			String lastname,
			String email,
			int prid
			);
	
	public void promoteToManagerById(int id);
	
	
	//
	public void createPersonnelSP(Personnel fc);
	
}
