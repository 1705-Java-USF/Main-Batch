package dao;

import java.util.List;

import pojo.ErsReimburse;

public interface ReimDao {
	public ErsReimburse selectReimburseById(int id);
	public List<ErsReimburse> selectAllReimbursements();
	public List<ErsReimburse> selectReimbursementsById(int id);
	public void createReimbursementMinReq(ErsReimburse er);
}
