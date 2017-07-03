package com.revature.ers.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.revature.ers.DataObjects.User;
import com.revature.ers.dao.Dao;
import com.revature.ers.dao.UserDaoImpl;
import com.revature.util.ColumnNameUtil;

public class Authenticator {
	private static Logger logger = Logger.getLogger(Authenticator.class);
	public static User authenticate(String username, String password)
	{
		logger.debug(username + " " + password);
		Map<String, String> columnVal = new HashMap<String, String>();
		columnVal.put(ColumnNameUtil.USERNAME, username);
		columnVal.put(ColumnNameUtil.PASSWORD, password);
		Dao<User> dao = new UserDaoImpl();
		List<User> match = dao.selectBy(columnVal);
		if(match.size() == 1)
		{
			return match.get(0);
		}
		return null;
	}

}
