package main;

import dao.ReimDao;
import dao.ReimDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import pojo.ErsReimburse;

public class Driver {

	public static void main(String[] args) {
		UserDao ud = new UserDaoImpl();
		ReimDao rd = new ReimDaoImpl();
		//Create new user testing
//		ErsUser eu = new ErsUser(1,"LucasV","p4ssw0rd","Lucas","Vance","Lucas.P.Vance@gmail.com",1);
//		ErsUser eu = new ErsUser(2,"KeyV","p4ssw0rd","Key","Vance","key.vance@gmail.com",2);
//		ErsUser eu = new ErsUser(3,"Hunter1","p4ssw0rd","Hunter","Huntington","hunter.huntington@gmail.com",3);
//		ErsUser eu = new ErsUser(4,"Hunter2","p4ssw0rd","Hunter2","Huntington","hunter2.huntington@gmail.com",4);
//		ErsUser eu = new ErsUser(5,"Bobbert","p4ssw0rd","Bobbert","Bobson","bobbert.bobson@gmail.com",9);
//		ud.createUserFull(eu);
		
		//Select * by user ID
//		ErsUser eu =ud.selectUserByID(2);
//		System.out.println(ud);
//		System.out.println(eu);
//		System.out.println(eu.getU_USERNAME());
//		
//		System.out.println(ud.returnUserNameById(1));
		
//		ud.deleteUsersById(2);
		
//		List<ErsUser> al = new ArrayList<ErsUser>();
//		al = ud.selectErsUsers();
//		String a1 = (String) al;
//		System.out.println(al.get(1).toString());
//		System.out.println(ud.selectUserByUserName("Hunter1"));
		
//		System.out.println(ud.returnRoleByRoleId(3));
		
		ErsReimburse er = new ErsReimburse(1, 3, 11);
		rd.createReimbursementMinReq(er);
		
//		System.out.println(ud.returnIdByUsername("Bobbert"));
		
//		List<ErsReimburse> al = new ArrayList<ErsReimburse>();
//		al = rd.selectReimbursementsById(3);
//		System.out.println(al.toString());		
	}

}