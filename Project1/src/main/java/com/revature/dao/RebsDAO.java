package com.revature.dao;

import java.util.ArrayList;

import com.revature.pojo.RebsObj;

public interface RebsDAO {

		public void createReimbursement(RebsObj reb);
		public RebsObj selectReimbursementById(String username);
		public ArrayList<RebsObj> selectReimbursements();
		public RebsObj updateReimbursement(RebsObj reb);
		public void deleteReimbursementById(int id);
	
}
