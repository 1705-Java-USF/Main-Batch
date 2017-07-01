package com.revature.dao;

import java.util.List;

import com.revature.pojos.ReimbursementType;

public interface ReimbursementTypeDAO {

	public void createReimbursementType(ReimbursementType r);
	public ReimbursementType selectReimbursementTypeById(int id);
	public List<ReimbursementType> selectReimbursementTypes();
	public void deleteReimbursementTypeById(int id);

}
