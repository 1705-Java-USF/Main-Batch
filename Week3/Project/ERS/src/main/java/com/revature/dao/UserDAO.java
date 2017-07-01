package com.revature.dao;

import java.util.List;

import com.revature.pojos.User;

public interface UserDAO {
	public void createUser(User u);
	public User selectUserById(int id);
	public List<User> selectUsers();
	public List<User> selectUsersExcludingId(int id);
	public void deleteUserById(int id);
	public User selectFromLogin(String user, String pass);
	public void updateUser(User u);
}
