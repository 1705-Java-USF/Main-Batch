package main.java.com.revature.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.com.revature.DAO.ERS_DAO;
import main.java.com.revature.pojo.ERS_REIMBURSEMENTS;
import main.java.com.revature.pojo.ERS_USERS;

@WebServlet("/getReqs")
public class GetRequests extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		ERS_DAO dao = new ERS_DAO();
		List<ERS_REIMBURSEMENTS> ERS_REIMBURSEMENTSs = new ArrayList<>();
		//if a ERS_USERSname has been sent, get all requests associated with that ERS_USERS if it exists
		if (req.getParameter("ERS_USERSname")!=null && req.getParameter("ERS_USERSname")!=""){
			if (dao.checkERS_USERSname(req.getParameter("ERS_USERSname")) > 0){
				ERS_USERS ERS_USERS = dao.getERS_USERS(req.getParameter("ERS_USERSname"));
				ERS_REIMBURSEMENTSs = dao.getAllERS_USERSRequests(ERS_USERS.getId());
			}else{
				//else send no result, attempted to get requests from nonexistent ERS_USERS
			}
		}else{
			//if no ERS_USERSname was sent, get all requests
			ERS_REIMBURSEMENTSs = dao.getAllRequests();
		}
		//Next check for and apply filter variables
		
		//If a resolver has been specified, make sure it exists
		if (req.getParameter("reso")!=null && req.getParameter("reso")!=""){
			ERS_USERS resolver;
			if (dao.checkERS_USERSname(req.getParameter("reso")) > 0){
				//If so, remove all results where the resolver does not match
				resolver = dao.getERS_USERS(req.getParameter("reso"));
				Iterator<ERS_REIMBURSEMENTS> it = ERS_REIMBURSEMENTSs.iterator();
				while(it.hasNext()){
					ERS_REIMBURSEMENTS r = it.next();
					if(r.getResolver()!=null && r.getResolver().getId() != resolver.getId()){
						it.remove();
					}
				}
			}else{
				//otherwise remove all requests (searching for requests from a nonexistent ERS_USERS should return none)
				ERS_REIMBURSEMENTSs.clear();
			}
		}
		//if status has been specified, remove all results that don't match
		//do nothing if no selection (or all)
		if(req.getParameter("stat")!=null && !req.getParameter("stat").equals("All")){
			String status = req.getParameter("stat");
			Iterator<ERS_REIMBURSEMENTS> it = ERS_REIMBURSEMENTSs.iterator();
			while(it.hasNext()){
				ERS_REIMBURSEMENTS r = it.next();
				if (!r.getStatus().equals(status)){
					it.remove();
				}
			}
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(ERS_REIMBURSEMENTSs);
		resp.getWriter().write(json);
	}
}