package com.corvusanalyzes.dao;

import java.util.List;

import com.corvusanalyzes.pojos.Reimbursement;

public interface ReimbursementsDAOInterface {
	void createReimbursement(Reimbursement reimbursement);
	List<Reimbursement> selectAllReimbursements();
	String selectTypeFromTypeId(int type);
	String selectStatusFromStatusId(int status);
	void updateStatusAndResolver(String newStatus, int reimbId, int u_id);
	List<Reimbursement> selectAllReimbursementsByAuthorId(int author_id);
	List<Reimbursement> selectAllReimbursementsByAuthorIdAndStatus(int author_id, int status);
	List<Reimbursement> selectAllReimbursementsByStatus(int status);
}
