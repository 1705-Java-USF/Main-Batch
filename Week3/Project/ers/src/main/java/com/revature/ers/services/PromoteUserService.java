package com.revature.ers.services;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.revature.ers.DataObjects.User;
import com.revature.ers.dao.Dao;
import com.revature.ers.dao.UserDaoImpl;
import com.revature.util.ColumnNameUtil;

public class PromoteUserService {
	private static Logger logger = Logger.getLogger(PromoteUserService.class);
	public static int promoteUser(int id)
	{
		try{
			Dao<User> udi = new UserDaoImpl();
			Map<String, String> optionMap = new HashMap<String, String>();
			Map<String, String> conditionMap = new HashMap<String, String>();
			optionMap.put(ColumnNameUtil.ROLE, "manager");
			conditionMap.put(ColumnNameUtil.UID, Integer.toString(id));
			return udi.updateBy(optionMap,  conditionMap);
			
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}finally{
			
		}
		return 0;
	}
}
