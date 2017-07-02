package com.revature.dao;

import java.util.List;

import com.revature.pojo.Reimbursement;
import com.revature.pojo.Users;

public interface ReimbursementDao {
	
	public  void createReimbursement(Reimbursement reim);
	
	public Reimbursement selectReimById(int r_id);
	
	public  boolean deleteReim(int id);
	
	public boolean denyRequest(int uid, int rid);

	public boolean approveRequest(int uid, int rid);
	
	public List<Reimbursement> listAllReimsE(int uid);
	
	public List<Reimbursement> listAllReimsM(int uid);
	
	public List<Reimbursement> listAllRReimsM();
	public List<Reimbursement> listAllDeimsM();
	public List<Reimbursement> listAllReimsById(int ruid);

}
