package com.revature.pojo;

import java.sql.Blob;
import java.sql.Timestamp;

import javax.servlet.http.Part;

public class Reimbursement {
	private int R_ID;
	private double R_AMOUNT;
	private String description;
	private Part receipt;
	private Timestamp R_Submitted;
	private Timestamp R_resolved;
	private int U_ID_AUTHOR;
	private int U_ID_RESOLVER;
	private int RT_ID;
	private int RS_ID;
	private Blob b;
	
	public Reimbursement(){
		
	}
	
	public Reimbursement(double r_AMOUNT, String description,  Timestamp r_Submitted,
			 int u_ID_AUTHOR, int rT_ID, Part receipt) {
		super();
		R_AMOUNT = r_AMOUNT;
		this.description = description;
		this.receipt = receipt;
		R_Submitted = r_Submitted;
		
		U_ID_AUTHOR = u_ID_AUTHOR;
		
		RT_ID = rT_ID;
	}
	public int getR_ID() {
		return R_ID;
	}
	public void setR_ID(int r_ID) {
		R_ID = r_ID;
	}
	public double getR_AMOUNT() {
		return R_AMOUNT;
	}
	public void setR_AMOUNT(double r_AMOUNT) {
		R_AMOUNT = r_AMOUNT;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Part getReceipt() {
		return receipt;
	}
	public void setReceipt(Part receipt) {
		this.receipt = receipt;
	}
	public Timestamp getR_Submitted() {
		return R_Submitted;
	}
	public void setR_Submitted(Timestamp r_Submitted) {
		R_Submitted = r_Submitted;
	}
	public Timestamp getR_resolved() {
		return R_resolved;
	}
	public void setR_resolved(Timestamp r_resolved) {
		R_resolved = r_resolved;
	}
	public int getU_ID_AUTHOR() {
		return U_ID_AUTHOR;
	}
	public void setU_ID_AUTHOR(int u_ID_AUTHOR) {
		U_ID_AUTHOR = u_ID_AUTHOR;
	}
	public int getU_ID_RESOLVER() {
		return U_ID_RESOLVER;
	}
	public void setU_ID_RESOLVER(int u_ID_RESOLVER) {
		U_ID_RESOLVER = u_ID_RESOLVER;
	}
	public int getRT_ID() {
		return RT_ID;
	}
	public void setRT_ID(int rT_ID) {
		RT_ID = rT_ID;
	}
	public int getRS_ID() {
		return RS_ID;
	}
	public void setRS_ID(int rS_ID) {
		RS_ID = rS_ID;
	}
	@Override
	public String toString() {
		return "Reimbursement [R_ID=" + R_ID + ", R_AMOUNT=" + R_AMOUNT + ", description=" + description + ", R_Submitted=" + R_Submitted + ", R_resolved=" + R_resolved + ", U_ID_AUTHOR="
				+ U_ID_AUTHOR + ", U_ID_RESOLVER=" + U_ID_RESOLVER + ", RT_ID=" + RT_ID + ", RS_ID=" + RS_ID + "]";
	}

	public Blob getB() {
		return b;
	}

	public void setB(Blob b) {
		this.b = b;
	}
}
	
	