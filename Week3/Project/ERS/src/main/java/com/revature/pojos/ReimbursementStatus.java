package com.revature.pojos;

import org.apache.log4j.Logger;

public class ReimbursementStatus {

	final static Logger logger = Logger.getLogger(ReimbursementStatus.class);
	
	private int id;
	private String status;
	
	public ReimbursementStatus(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ReimbursementStatus [id=" + id + ", status=" + status + "]";
	}
}
