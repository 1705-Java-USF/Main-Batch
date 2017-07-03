package com.revature.ers.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.revature.ers.DataObjects.Reimbursement;
import com.revature.ers.dao.ReimbursementDaoImpl;
import com.revature.util.ColumnNameUtil;

public class GetRequestsService {
	private static Logger logger = Logger.getLogger(GetRequestsService.class);
	public static List<Reimbursement> getRequestByUserId(int uid)
	{
		ReimbursementDaoImpl rdi = new ReimbursementDaoImpl();
		Map<String, String> columnValueMap = new HashMap<String, String>();
		columnValueMap.put(ColumnNameUtil.AUTHOR, String.valueOf(uid));
		return rdi.selectBy(columnValueMap);
	}
	public static List<Reimbursement> getAllRequests()
	{
		ReimbursementDaoImpl rdi = new ReimbursementDaoImpl();
		return rdi.selectAll();
	}
	public static List<Reimbursement> getAllRequestsByStatus(String status)
	{
		logger.debug("status: " + status);
		ReimbursementDaoImpl rdi = new ReimbursementDaoImpl();
		Map<String,String> nameValue = new HashMap<String, String>();
		String cname = ColumnNameUtil.STATUS;
		if(status.trim().equals("resolved"))
		{
			nameValue.put(cname, "approved");
			List<Reimbursement> a = rdi.selectBy(nameValue);
			nameValue.put(cname, "denied");
			List<Reimbursement> b = rdi.selectBy(nameValue);
			a.addAll(b);
			return a;
		}
		nameValue.put(cname, status.trim());
		logger.debug("Status: " + status);
		return rdi.selectBy(nameValue);
	}
	public static Reimbursement getRequestById(int rid)
	{
		ReimbursementDaoImpl rdi = new ReimbursementDaoImpl();
		return rdi.selectById(rid);
	}

}
