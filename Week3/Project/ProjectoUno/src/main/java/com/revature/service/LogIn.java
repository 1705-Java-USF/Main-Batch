package com.revature.service;

import com.revature.dao.UserDaoImp;
import com.revature.pojo.ErsUser;

//ABSTRACT LOG IN PROCADURE
public class LogIn 
{
	public ErsUser validate(String user, String pass)
	{
		UserDaoImp dao = new UserDaoImp();
		ErsUser ersUser = dao.selectUserByUserNameAndPass(user, pass);
		
		if(ersUser == null)
		{
			System.out.println("Null user");
			return null;
		}
		else
		{
			System.out.println(ersUser.toString());
			System.out.println("not null user");
			return ersUser;
		}
	}
}
