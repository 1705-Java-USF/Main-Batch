package com.revature.ers.services;

import java.io.IOException;
import java.sql.Blob;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.revature.ers.DataObjects.Reimbursement;
import com.revature.ers.DataObjects.User;
import com.revature.ers.dao.ReimbursementDaoImpl;
import com.revature.util.PartBlobConverter;

public class CreateReimbursementService {
	
	private Logger logger = Logger.getLogger(CreateReimbursementService.class);
	public int createReimbursement(HttpServletRequest request)
	{
		int scode = 0;
		try {
			double amount = Double.parseDouble(request.getParameter("amount"));
			int authorId =(Integer) request.getSession().getAttribute("uid");
			User u = new User();
			u.setUserId(authorId);
			String descr = request.getParameter("description");
			Blob receipt = PartBlobConverter.getBlob(request.getPart("receipt"));
			String status = "pending";
			String type = request.getParameter("type");
			Reimbursement r = new Reimbursement();
			r.setAmount(amount);
			r.setAuthor(u);
			r.setDescription(descr);
			r.setReceipt(receipt);
			r.setReimbursementStatus(status);
			r.setReimbursementType(type);
			r.setSubmittedTime(LocalDateTime.now());
			ReimbursementDaoImpl rdi = new ReimbursementDaoImpl();
			scode = rdi.create(r);
			return scode;
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} catch (ServletException e) {
			logger.error(e.getMessage(), e);
		}
		return 0;
	}
}
