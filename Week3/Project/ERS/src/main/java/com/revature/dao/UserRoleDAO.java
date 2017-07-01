package com.revature.dao;

import java.util.List;

import com.revature.pojos.UserRole;

public interface UserRoleDAO {

	public void createUserRole(UserRole u);
	public UserRole selectUserRoleById(int id);
	public List<UserRole> selectUserRoles();
	public void deleteUserRoleById(int id);
	public void createUserRoleSP(UserRole u);
}
