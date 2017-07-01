package com.revature.dao;

import java.util.List;

import com.revature.pojos.ReimbursementStatus;

public interface ReimbursementStatusDAO {


	public void createReimbursementStatus(ReimbursementStatus r);
	public ReimbursementStatus selectReimbursementStatusById(int id);
	public List<ReimbursementStatus> selectReimbursementStatus();
	public void deleteReimbursementStatusById(int id);
}
