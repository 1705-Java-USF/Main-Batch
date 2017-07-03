package com.revature.service;

import com.revature.dao.UserDaoImp;
import com.revature.pojo.ErsUser;

//CREATE ACCOUNT
public class CreateAccount 
{
	public void create(String username, String pass)
	{
		UserDaoImp dao = new UserDaoImp();
		ErsUser eu = new ErsUser(username, pass);
		eu.setUrId(1);
		dao.createUserSP(eu);
	}
}
