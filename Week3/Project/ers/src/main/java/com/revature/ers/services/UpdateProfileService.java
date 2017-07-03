package com.revature.ers.services;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.revature.ers.DataObjects.User;
import com.revature.ers.dao.Dao;
import com.revature.ers.dao.UserDaoImpl;
import com.revature.util.ColumnNameUtil;

public class UpdateProfileService {

	public static int updateProfileService(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		Map<String,String> nameValue = new HashMap<String, String>();
		Map<String,String> conditions = new HashMap<String, String>();
		conditions.put(ColumnNameUtil.UID, Integer.toString((Integer)session.getAttribute("uid")));
		
		String cFname = request.getParameter("firstname");
		String cLname = request.getParameter("lastname");
		String cEmail = request.getParameter("email");
		String password = request.getParameter("password");
		String columnName;
		String valName;
		if(cFname != null && !cFname.equals("") && !cFname.equals(session.getAttribute("firstname")))
		{
			columnName = ColumnNameUtil.FIRSTNAME;
			valName = cFname;
			session.setAttribute("firstname", cFname);
			nameValue.put(columnName, valName);
		}
		if(cLname != null && !cLname.equals("") && !cLname.equals(session.getAttribute("lastname")))
		{
			columnName = ColumnNameUtil.LASTNAME;
			valName = cLname;
			session.setAttribute("lastname", cLname);
			nameValue.put(columnName, valName);
		}
		if(cEmail != null && !cEmail.equals("") && !cEmail.equals(session.getAttribute("email")))
		{
			columnName = ColumnNameUtil.EMAIL;
			valName = cEmail;
			session.setAttribute("email", cEmail);
			nameValue.put(columnName, valName);
		}
		if(password != null && !password.equals(""))
		{
			columnName = ColumnNameUtil.PASSWORD;
			valName = password;
			nameValue.put(columnName, valName);
		}
		if(nameValue.size() > 0)
		{
			Dao<User> dao = new UserDaoImpl();
			return dao.updateBy(nameValue, conditions);
		}
		return 0;
		
	}
}
