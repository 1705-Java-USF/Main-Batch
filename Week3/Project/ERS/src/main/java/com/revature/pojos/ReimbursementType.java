package com.revature.pojos;

import org.apache.log4j.Logger;

public class ReimbursementType {
	
	final static Logger logger = Logger.getLogger(ReimbursementType.class);
	
	private int id;
	private String type;
	
	public ReimbursementType(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ReimbursementType [id=" + id + ", type=" + type + "]";
	}
}
