package dao;

import java.util.List;

import pojo.ErsUser;

public interface UserDao {
	public void createUserFull(ErsUser eu);
	public ErsUser selectUserByID(int id);
	public List<ErsUser> selectErsUsers();
	public void deleteUsersById(int id);
	public void createUserMinReq(ErsUser eu);
	public String returnUserNameById(int id);
	public ErsUser selectUserByUserName(String username);
	public String returnRoleByRoleId(int id);
	public int returnIdByUsername(String username);
}
