package services;

import dao.UserDao;
import dao.UserDaoImpl;
import pojo.ErsUser;

public class login {
		
	public boolean validateLogin(String user, String pass){
		UserDao ud = new UserDaoImpl();
		ErsUser eu = ud.selectUserByUserName(user);
		String a = eu.getU_USERNAME();
		String b = eu.getU_PASSWORD();
	
		if(user.equals(a) && pass.equals(b)){
			return true;
		}else{
			return false;
		}
	}
}
