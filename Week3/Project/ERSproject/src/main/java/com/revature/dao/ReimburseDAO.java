package com.revature.dao;

import java.util.Collection;

import com.revature.pojos.Reimbursement;

public interface ReimburseDAO {

	public void createReimbursement(Reimbursement r);
	public Collection<Reimbursement> selectPendingReimbursements();
	public Collection<Reimbursement> selectResolvedReimbursements();
	public Collection<Reimbursement> selectEmployPendingReimbursements(int id);
	public Collection<Reimbursement> selectEmployResolvedReimbursements(int id);
	public void resolveReimbursement(Reimbursement r, int m_id);
	public Reimbursement selectReimbursement(int r_id);
	
}
