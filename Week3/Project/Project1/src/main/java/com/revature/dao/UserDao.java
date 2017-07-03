package com.revature.dao;

import java.util.List;

import com.revature.pojos.User;

public interface UserDao {
	public void createUser(User user);
	public User selectUserById(int id);
	public User selectUserByUsername(String username);
	public User selectUserByEmail(String email);
	public boolean updateUser(User user);
	public List<User> selectUsersByName(String firstname, String lastname);
	public List<User> selectEmployees();
	public void fireUser(int id);
	public String getRoleById(int roleId);
	public int getRoleId(String role);
	public void deleteUserById(int id);
}
