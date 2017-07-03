package com.revature.dao;

import com.revature.pojo.ErsUser;
import com.revature.pojo.UserRoles;

public interface UserRolesDao 
{
	public void createUserRole(ErsUser eu);
	public UserRoles selectUserRoleById(int id);
}
