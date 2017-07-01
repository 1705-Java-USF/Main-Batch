package com.revature.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
import com.revature.services.Select;

public class SelectTest {

	Select selector = new Select();

	UserDAO uDao = new UserDAOImp();
	UserRoleDAO urDao = new UserRoleDAOImp();
	ReimbursementDAO rDao = new ReimbursementDAOImp();
	ReimbursementTypeDAO rtDao = new ReimbursementTypeDAOImp();
	ReimbursementStatusDAO rsDao = new ReimbursementStatusDAOImp();

	User u;
	User selectedUser;
	UserRole ur;
	UserRole selectedRole;
	Reimbursement r;
	Reimbursement selectedReimbursement;
	ReimbursementType rt;
	ReimbursementType selectedType;
	ReimbursementStatus rs;
	ReimbursementStatus selectedStatus;
	
	int id;
	int rid;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		id = 1;
		u = uDao.selectUserById(id);
		selectedUser = selector.getUser(id);
		ur = urDao.selectUserRoleById(id);
		selectedRole = selector.getUserRole(id);
		
		rid = 21;
		r = rDao.selectReimbursementById(rid);
		selectedReimbursement = selector.getReimbursement(rid);
		rt = rtDao.selectReimbursementTypeById(id);
		selectedType = selector.getReimbursementType(id);
		rs = rsDao.selectReimbursementStatusById(id);
		selectedStatus = selector.getReimbursementStatus(id);
	}

	@After
	public void tearDown() throws Exception {
		u = null;
		selectedUser = null;
		ur = null;
		selectedRole = null;
		r = null;
		selectedReimbursement = null;
		rt = null;
		selectedType = null;
		rs = null;
		selectedStatus = null;
		System.gc();
	}

	@Test
	public void getUserTest() {
		assertNotNull(u);
		assertNotNull(selectedUser);
		assertEquals(selectedUser.getId(), u.getId());
		assertEquals(selectedUser.getFirstname(), u.getFirstname());
		assertEquals(selectedUser.getLastname(), u.getLastname());
		assertEquals(selectedUser.getEmail(), u.getEmail());
		assertEquals(selectedUser.getUsername(), u.getUsername());
		assertEquals(selectedUser.getPassword(), u.getPassword());
	}
	
	@Test
	public void getReimbursementTest(){
		assertNotNull(r);
		assertNotNull(selectedReimbursement);
		assertEquals(selectedReimbursement.getId(), r.getId());
		assertEquals(selectedReimbursement.getAuthor_id(), r.getAuthor_id());
		assertEquals(selectedReimbursement.getDescription(), r.getDescription());
		assertEquals(selectedReimbursement.getReceipt(), r.getReceipt());
		assertEquals(selectedReimbursement.getReimb_status(), r.getReimb_status());
		assertEquals(selectedReimbursement.getReimb_type(), r.getReimb_type());
		assertEquals(selectedReimbursement.getResolved(), r.getResolved());
		assertEquals(selectedReimbursement.getResolver_id(), r.getResolver_id());
		assertEquals(selectedReimbursement.getSubmitted(), r.getSubmitted());
	}
	
	@Test
	public void getReimbursementTypeTest(){
		assertNotNull(rt);
		assertNotNull(selectedType);
		assertEquals(selectedType.getId(), rt.getId());
		assertEquals(selectedType.getType(), rt.getType());
	}
	
	@Test
	public void getReimbursementStatusTest(){
		assertNotNull(rs);
		assertNotNull(selectedStatus);
		assertEquals(selectedStatus.getId(), rs.getId());
		assertEquals(selectedStatus.getStatus(), rs.getStatus());
	}
	
	@Test
	public void getUserRoleTest(){
		assertNotNull(ur);
		assertNotNull(selectedRole);
		assertEquals(selectedRole.getId(), ur.getId());
		assertEquals(selectedRole.getRole(), ur.getRole());
	}
}
