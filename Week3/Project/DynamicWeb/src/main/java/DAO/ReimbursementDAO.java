package DAO;

import java.util.List;

import Database.ReimbursementPOJO;

public interface ReimbursementDAO {
	
	public void AddReimbursement(ReimbursementPOJO emp);
	public void DeleteReimbursement(int id);
	public List<ReimbursementPOJO> getAllReimbs();
	public List<ReimbursementPOJO> getPendReimbs();
	public List<ReimbursementPOJO> selectReimbByID(int id);
	public void ApproveReimb (int id, int action, int mgrId);
	public int GetMaxId();

}
