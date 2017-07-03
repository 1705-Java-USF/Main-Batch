package com.revature.dao;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.List;

import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;

public interface ReimbursementDao {
	public void createReimbursement(Reimbursement reimbursement);
	public boolean updateReimbursement(Reimbursement reimbursement);
	public void updateReimbursementReceipt(int id, Blob receipt);
	public Reimbursement selectReimbursementById(int id);
	public List<Reimbursement> selectReimbursements();
	public List<Reimbursement> selectReimbursementsByAuthorId(int id);
	public List<Reimbursement> selectReimbursementsByStatus(String status);
	public List<Reimbursement> selectReimbursementsByAuthorIdAndStatus(int id, String status);
	public int getTypeId(String type);
	public String getTypeById(int id);
	public int getStatusId(String status);
	public String getStatusById(int id);
	public void deleteReimbursementById(int id);
}
