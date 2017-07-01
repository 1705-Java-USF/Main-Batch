package com.revature.services;

import java.util.List;

import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImp;
import com.revature.dao.ReimbursementStatusDAO;
import com.revature.dao.ReimbursementStatusDAOImp;
import com.revature.dao.ReimbursementTypeDAO;
import com.revature.dao.ReimbursementTypeDAOImp;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImp;
import com.revature.dao.UserRoleDAO;
import com.revature.dao.UserRoleDAOImp;
import com.revature.pojos.Reimbursement;
import com.revature.pojos.ReimbursementStatus;
import com.revature.pojos.ReimbursementType;
import com.revature.pojos.User;
import com.revature.pojos.UserRole;

public class Select {

	UserDAO uDao = new UserDAOImp();
	UserRoleDAO urDao = new UserRoleDAOImp();
	ReimbursementDAO rDao = new ReimbursementDAOImp();
	ReimbursementStatusDAO rsDao = new ReimbursementStatusDAOImp();
	ReimbursementTypeDAO rtDao = new ReimbursementTypeDAOImp();
	
	public User getUser(int id){
		return uDao.selectUserById(id);
	}
	
	public Reimbursement getReimbursement(int id){
		return rDao.selectReimbursementById(id);
	}
	
	public UserRole getUserRole(int id){
		return urDao.selectUserRoleById(id);
	}
	
	public ReimbursementStatus getReimbursementStatus(int id){
		return rsDao.selectReimbursementStatusById(id);
	}
	
	public ReimbursementType getReimbursementType(int id){
		return rtDao.selectReimbursementTypeById(id);
	}
	
	public List<Reimbursement> getPendingExcept(int id){
		return rDao.selectPendingReimbursementsExcludingId(id);
	}

	public List<Reimbursement> getResolvedExcept(int id){
		return rDao.selectResolvedReimbursementsExcludingId(id);
	}
	
	public List<Reimbursement> getPendingFor(int id){
		return rDao.selectPendingReimbursementsById(id);
	}

	public List<Reimbursement> getResolvedFor(int id){
		return rDao.selectResolvedReimbursementsById(id);
	}
	
	public List<User> getUsersExcept(int id){
		return uDao.selectUsersExcludingId(id);
	}
	
	public List<ReimbursementType> getReimbursementTypes(){
		return rtDao.selectReimbursementTypes();
	}
}
