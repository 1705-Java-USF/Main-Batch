package com.revature.dao;

import java.util.List;

import com.revature.pojo.ReimStatus;
import com.revature.pojo.ReimType;
import com.revature.pojo.Reimbursement;

public interface DaoReimbursement {
	
	public void createReim(Reimbursement r);
	public int getTypeByString(String type);
	public List<Reimbursement> getReimById(int id);
	public List<Reimbursement> getReimExcludeId(int id);
	public List<Reimbursement> getReimByUsername(String un);
	public Reimbursement getReimbursementById(int id);
	public int getResolveById(int id);
	public ReimType getTypeById(int id);
	public ReimStatus getStatusById(int id);
	public void updateReim(Reimbursement r);
	//View all employees (Manager)
	//View all pending requests (Manager)
	//View all reimbursements by employee id/username (Manager)
	//View images of all receipts (blob, Manager)
	//View all approved/denied (!pending) requests from all employees, and see which manager resolved it (Manager)
	//
	
}
