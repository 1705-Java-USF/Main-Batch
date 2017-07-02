package com.revature.pojos;

import java.io.InputStream;
import java.sql.Timestamp;




public class GunRequests {
	private int gid;
	private int cost;
	private String desc;
	private InputStream rf;
	private Timestamp sub;
	private Timestamp clo;
	private int pidauth;
	private int pidclo;
	private int gtype;
	private int gstatus;
	byte[] imageData;
		
	public GunRequests(){
		
	}
	

	public GunRequests(int gid, int cost, String desc, InputStream rf, Timestamp sub, Timestamp clo, int pidauth, int pidclo, int gtype,
			int gstatus) {
		super();
		this.gid = gid;
		this.cost = cost;
		this.desc = desc;
		this.rf = rf;
		this.sub = sub;
		this.clo = clo;
		this.pidauth = pidauth;
		this.pidclo = pidclo;
		this.gtype = gtype;
		this.gstatus = gstatus;
	}
  
	

	public byte[] getImageData() {
		return imageData;
	}


	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}


	public int getPidauth() {
		return pidauth;
	}

	public void setPidauth(int pidauth) {
		this.pidauth = pidauth;
	}

	public int getPidclo() {
		return pidclo;
	}

	public void setPidclo(int pidclo) {
		this.pidclo = pidclo;
	}

	public int getGtype() {
		return gtype;
	}

	public void setGtype(int gtype) {
		this.gtype = gtype;
	}

	public int getGstatus() {
		return gstatus;
	}

	public void setGstatus(int gstatus) {
		this.gstatus = gstatus;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public InputStream getRf() {
		return rf;
	}

	public void setRf(InputStream rf) {
		this.rf = rf;
	}

	public Timestamp getSub() {
		return sub;
	}


	public void setSub(Timestamp sub) {
		this.sub = sub;
	}



	public Timestamp getClo() {
		return clo;
	}



	public void setClo(Timestamp clo) {
		this.clo = clo;
	}



	@Override
	public String toString() {
		return "GunRequests [gid=" + gid + ", cost=" + cost + ", desc=" + desc + ", rf=" + rf + ", sub=" + sub
				+ ", clo=" + clo + "]";
	}
	
	
	
}
