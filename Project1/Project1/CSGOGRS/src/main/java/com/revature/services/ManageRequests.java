package com.revature.services;

import java.io.InputStream;
import java.sql.Timestamp;
import java.util.List;

import com.revature.dao.GunRequestsDAO;
import com.revature.dao.GunRequestsDAOImpl;
import com.revature.dao.PersonnelDAO;
import com.revature.dao.PersonnelDAOImpl;
import com.revature.pojos.GunRequests;
import com.revature.pojos.Personnel;

public class ManageRequests {
	public void sendPedReqFormToDB(InputStream file, String desc, String guntype, int cost, String username,
			int status) {
		GunRequestsDAO grdao = new GunRequestsDAOImpl();
		PersonnelDAO pdao = new PersonnelDAOImpl();
		Personnel user = pdao.selectPersonnelByUser(username);

		int gt = 0;
		switch (guntype) {
		case "rifle":
			gt = 1;
			break;
		case "submachine":
			gt = 2;
			break;
		case "machine":
			gt = 3;
			break;
		case "shotgun":
			gt = 4;
			break;
		case "pistol":
			gt = 5;
			break;
		}

		// If the closer id is the same as submitter, then obviously the request
		// hasnt been resolved
		if (gt != 0) {
			GunRequests gr = new GunRequests(0, cost, desc, file, new Timestamp(System.currentTimeMillis()), null,
					user.getId(), user.getId(), gt, status);

			gr.setGid(grdao.getCurrentMaxId() + 1);
			grdao.createGunRequest(gr);
		}
	}

	public String[][] getAllRequests() {
		GunRequestsDAO pdao = new GunRequestsDAOImpl();
		// String b64 = null;
		// Get all the current people
		List<GunRequests> allReqs = pdao.selectGunRequests();
		String[][] stringOfReqs = new String[allReqs.size()][11];

		//BufferedImage image = allReqs.get(0).getImage();
		
//		System.out.println(image);
		
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		try {
//			ImageIO.write(image, "png", baos);
//			baos.flush();
//			byte[] imageInByteArray = baos.toByteArray();
//			baos.close();
//			b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(imageInByteArray);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		int i = 0;
		for (GunRequests req : allReqs) { // finish fbipage as well
			stringOfReqs[i][0] = getGunType(Integer.parseInt(String.valueOf(req.getGtype()))); 
			stringOfReqs[i][1] = String.valueOf(req.getCost());
			stringOfReqs[i][2] = req.getDesc();
			stringOfReqs[i][3] = getNameById(Integer.parseInt(String.valueOf(req.getPidauth()))); 
			stringOfReqs[i][4] = req.getSub().toString();
			stringOfReqs[i][5] = req.getClo() == null ? "Unresolved" : req.getClo().toString(); 
			stringOfReqs[i][6] = getGunStatus(Integer.parseInt(String.valueOf(req.getGstatus()))); 
			stringOfReqs[i][7] = String.valueOf(req.getGid());
			stringOfReqs[i][8] = getNameById(Integer.parseInt(String.valueOf(req.getPidclo())));
			stringOfReqs[i][9] = String.valueOf(req.getPidauth());
			stringOfReqs[i][10] = String.valueOf(req.getGstatus()); 

//			if (b64 != null) {
//				stringOfReqs[i][5] = b64;
			i++;
			}
			
		return stringOfReqs;
	}
	
	public void updateRequestStatusById(String what, String resolver,String reqId){
		GunRequestsDAO gdao = new GunRequestsDAOImpl();
		if(what.equals("approve")){
			gdao.updateGunRequestStatusById(2, Integer.parseInt(resolver), new Timestamp(System.currentTimeMillis()),Integer.parseInt(reqId));
		}else if(what.equals("deny")){
			gdao.updateGunRequestStatusById(3, Integer.parseInt(resolver), new Timestamp(System.currentTimeMillis()),Integer.parseInt(reqId));
		}
	}
	
	public byte[] getImageByGid(int gid){
		GunRequestsDAO gdao = new GunRequestsDAOImpl();
		
		return gdao.getImageByGunId(gid);
	}
	
	//Helper methods
	static String getGunType(int type){
		String stringType = null;
		switch(type){
		case 1:
			stringType = "Rifle";
			break;
		case 2:
			stringType = "Submachine";			
			break;
		case 3:
			stringType = "Machine";
			break;
		case 4:
			stringType = "Shotgun";
			break;
		case 5:
			stringType = "Pistol";
			break;
		}
		return stringType;
	}
	
	static String getGunStatus(int status){
		String stringStatus = null;
		switch(status){
		case 1:
			stringStatus = "Pending";
			break;
		case 2:
			stringStatus = "Approved";			
			break;
		case 3:
			stringStatus = "Denied";
			break;
		}
		return stringStatus;
	}
	
	static String getNameById(int pid){
		String requestor = null;
		PersonnelDAO dao = new PersonnelDAOImpl();
		Personnel p = dao.selectPersonnelById(pid);
		requestor = p.getFirstname() + " " + p.getLastname();
		return requestor;
	}
	
	
	
}
