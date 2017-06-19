package com.revature.pojos;

public class GunRequests {
	private int gid;
	private int cost;
	private String desc;
	private String rf;
	private String sub;
	private String clo;
	
	public GunRequests(){
		
	}
	
	public GunRequests(int gid, int cost, String desc, String rf, String sub, String clo) {
		super();
		this.gid = gid;
		this.cost = cost;
		this.desc = desc;
		this.rf = rf;
		this.sub = sub;
		this.clo = clo;
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

	public String getRf() {
		return rf;
	}

	public void setRf(String rf) {
		this.rf = rf;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public String getClo() {
		return clo;
	}

	public void setClo(String clo) {
		this.clo = clo;
	}

	@Override
	public String toString() {
		return "GunRequests [gid=" + gid + ", cost=" + cost + ", desc=" + desc + ", rf=" + rf + ", sub=" + sub
				+ ", clo=" + clo + "]";
	}
	
	
	
}
