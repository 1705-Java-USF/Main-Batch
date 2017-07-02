package com.revature.dao;

import java.util.List;

import com.revature.pojo.Users;

public interface DaoUser {
	
	public void createUser(Users u);
	public Users selectUserByUsername(String u);
	public void deleteUserByUsername(String u);
	public String getRole(int id);
	public boolean updateUser(Users u);
	public Users getUserById(int id);
	public List<Users> getUsersExcludingId(int id);
}
