package com.revature.dao;

import java.util.List;

import com.revature.pojo.ErsUser;

public interface UserDao 
{
	public void createUser(ErsUser eu);
	public void createUserSP(ErsUser eu);
	public void updateUser(ErsUser eu);
	public ErsUser selectUserById(int id);
	public ErsUser selectUserByUserName(String userName);
	public List<ErsUser> selectAllUsers();
	public void promoteUser(Integer id);
}
