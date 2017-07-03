package com.revature.pojos;

import java.sql.Blob;

public class Reimbursement {

	private int r_id, author, resolved_by;
	private double amount;
	private String report, type, status, submitted, resolved;
	private Blob receipt;

	public Reimbursement(int id, double amt, String summary, Blob receipt, String submitted, String resolved, 
			int auth, int resolved_by, String stat, String type) {
		this.r_id = id;
		this.amount = amt;
		this.author = auth;
		this.resolved_by = resolved_by;
		this.type = type;
		this.status = stat;
		this.report = summary;
		this.submitted = submitted;
		this.resolved = resolved;
		this.receipt = receipt;
	}

	@Override
	public String toString() {
		return "Reimbursement " + r_id + " BY " + author + " FOR " + amount + " IS " + status;
	}
	
	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getResolved_by() {
		return resolved_by;
	}

	public void setResolved_by(int resolved_by) {
		this.resolved_by = resolved_by;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public String getSubmitted() {
		return submitted;
	}

	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}

	public String getResolved() {
		return resolved;
	}

	public void setResolved(String resolved) {
		this.resolved = resolved;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Blob getReceipt() {
		return receipt;
	}

	public void setReceipt(Blob receipt) {
		this.receipt = receipt;
	}
	
}
