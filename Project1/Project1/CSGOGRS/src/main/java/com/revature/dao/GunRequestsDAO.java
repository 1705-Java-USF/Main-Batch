package com.revature.dao;

import java.sql.Timestamp;
import java.util.List;

import com.revature.pojos.GunRequests;

public interface GunRequestsDAO {
	
	public void createGunRequest(GunRequests fc);
	public GunRequests selectGunRequestById(int id);
	public List<GunRequests> selectGunRequests();
	public void deleteGunRequestById(int id);
	
	public byte[] getImageByGunId(int gid);
	public int getCurrentMaxId();	
	public void updateGunRequestStatusById(int status, int mid, Timestamp closed, int id);

}
