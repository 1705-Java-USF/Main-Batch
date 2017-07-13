package dao;

import java.util.List;

import pojo.ErsReimburse;

public interface ReimDao {
	public ErsReimburse selectReimburseById(int id);
	public List<ErsReimburse> selectAllPendingReimbursements();
	public List<ErsReimburse> selectAllResolvedReimbursements();	
	public List<ErsReimburse> selectPendingReimbursementsById(int id);
	public List<ErsReimburse> selectResolvedReimbursementsById(int id);
	public void createReimbursementMinReq(ErsReimburse er);
	public void updateDescriptionAndAmount(int type_id);
	public void resolveReimbursement(int r_id, int resolver_id);
}
