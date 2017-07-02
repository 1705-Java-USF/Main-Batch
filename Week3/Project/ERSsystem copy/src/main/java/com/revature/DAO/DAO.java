package main.java.com.revature.DAO;

import java.util.List;

import main.java.com.revature.pojo.ERS_REIMBURSEMENTS;
import main.java.com.revature.pojo.ERS_USERS;

public interface DAO {
	//read
	public String getPassword(String uname);
	public ERS_USERS getERS_USERS(String uname);
	public ERS_USERS getERS_USERS(int uid);
	public ERS_REIMBURSEMENTS getRequest(int id);
	public List<ERS_REIMBURSEMENTS> getResolvedRequests(int uid);
	public List<ERS_REIMBURSEMENTS> getPendingRequests(int uid);
	public List<ERS_REIMBURSEMENTS> getDeniedRequests(int uid);
	public int checkERS_USERSname(String uname);
	//update
	public boolean setPassword(int id, String newPass);
	public ERS_USERS updateInfo(ERS_USERS ERS_USERS);
	//create
	public void createRequest(ERS_REIMBURSEMENTS re);
	public ERS_USERS registerERS_USERS(ERS_USERS newERS_USERS);
	public List<ERS_REIMBURSEMENTS> getAllRequests();
	
}
