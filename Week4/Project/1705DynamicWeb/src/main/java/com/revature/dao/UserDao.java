package com.revature.dao;

import java.util.List;

import com.revature.pojo.Users;

public interface UserDao {
	
	public boolean createUser(Users us);
	
	public Users selectUsersByUsername(String Username);
	public Users selectUserById(int uid);

	public boolean deleteUserByUsername(String Username);
	
	public boolean updateUserUsername(String us, String username);
	public List<Users> selectUsers();
	public void updateUserPass(String us, String password);
	public void updateUserFname(String us, String fname);
	public void updateUserLname(String us, String lname);
	public void updateUserEmail(String us, String email);

}
