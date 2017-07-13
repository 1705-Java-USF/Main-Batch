package com.revature.service;

import org.springframework.stereotype.Component;

import com.revature.bean.User;

//Use components for all classes you want to be recognized by the
//component scan from the spring container
@Component
public class UserService {
	
	public User auth(User user){
		
		User authUser = null;
		if(user.getUsername().equals("bobbert")&&user.getPassword().equals("stuff")){
			authUser = user;
		}
		
		return authUser;
		/*
		 * This authentication will return null in all situations where
		 * both the password and the username are not correct.
		 */
	
		
	}
}
