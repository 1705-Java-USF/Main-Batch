package com.revature.service;

import java.util.List;

import com.revature.dao.UserDaoImp;
import com.revature.pojo.ErsUser;

//ABSTRACT ALL INTERACTIONS WITH USER DAO
public class UserInteract 
{
	public void updateUser(ErsUser eu)
	{
		UserDaoImp dao = new UserDaoImp();
		dao.updateUser(eu);
	}
	
	public List<ErsUser> getAllUsers()
	{
		UserDaoImp dao = new UserDaoImp();
		List<ErsUser> list = dao.selectAllUsers();
		return list;
	}
	
	public void promoteUSer(Integer id)
	{
		UserDaoImp dao = new UserDaoImp();
		dao.promoteUser(id);
	}
}
