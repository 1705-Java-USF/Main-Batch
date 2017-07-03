package com.corvusanalyzes.dao;

import java.util.List;

import com.corvusanalyzes.pojos.User;

public interface UsersDAOInterface {
	void createUser(User user);
	List<User> selectAllUsers();
	String selectPasswordByUsername(String username);
	User selectUserByUsername(String username);
	void updateUser(String username, String password, String firstname, String lastname, String email, String oldusername);
	List<String> selectAllUsernames();
	String selectUsernameById(int author_id);
	int selectIdByUsername(String username);
	void updateUserRole(String username, int newRole);
}
