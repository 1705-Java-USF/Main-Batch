package com.revature.main;

import java.sql.Connection;
import java.util.List;

import com.revature.dao.ReinBurstDaoImp;
import com.revature.dao.UserDaoImp;
import com.revature.dao.UserRolesDaoImp;
import com.revature.pojo.ErsUser;
import com.revature.pojo.ReinBurst;
import com.revature.pojo.UserRoles;

public class ErsDriver 
{
	public static void main(String[] args) 
	{
		UserDaoImp dao = new UserDaoImp();
		UserRolesDaoImp dao2 = new UserRolesDaoImp();
		ReinBurstDaoImp d3 = new ReinBurstDaoImp();
		
		//ErsUser testEr = new ErsUser("dudre", "hackthas", "jim", "bean", "dog@that.net", 1);
		//dao.createUser(testEr);
		
		//ErsUser testEr = new ErsUser("bart", "default", 1);
		//dao.createUserSP(testEr);
		
		//testEr.setPassWord("poop");
		//testEr.setFirstName("natalia");
		//testEr.setLastName("miLLAA");
		//testEr.setEmail("PUMPmyhoorns@yahoo.com");
		
		//dao.updateUser(testEr);
		
		//System.out.println("in driver");
		//ErsUser testEr = dao.selectUserByUserName("nat");
		
		
		//ErsUser testEr = dao.selectUserByUserNameAndPass("nat", "poop");
		//System.out.println(testEr.toString());
		
		//dao2.createUserRole(testEr);
		ErsUser testEr = dao.selectUserById(21);
		System.out.println(testEr.toString());	
		d3.createReinBurstSP(testEr, 15.0, "plumb", "rec", 1);
		
		System.out.println("\n\nEnd!!");
	}
}
