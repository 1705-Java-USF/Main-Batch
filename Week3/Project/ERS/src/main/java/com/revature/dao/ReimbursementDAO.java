package com.revature.dao;

import java.util.List;

import com.revature.pojos.Reimbursement;

public interface ReimbursementDAO {

	public void createReimbursement(Reimbursement r);
	public void updateReimbursement(Reimbursement r);
	public Reimbursement selectReimbursementById(int id);
	public List<Reimbursement> selectReimbursements();
	public void deleteReimbursementById(int id);
	public List<Reimbursement> selectReimbursementsById(int id);
	public List<Reimbursement> selectPendingReimbursementsById(int id);
	public List<Reimbursement> selectPendingReimbursementsExcludingId(int id);
	public List<Reimbursement> selectResolvedReimbursementsById(int id);
	public List<Reimbursement> selectResolvedReimbursementsExcludingId(int id);
	
}
