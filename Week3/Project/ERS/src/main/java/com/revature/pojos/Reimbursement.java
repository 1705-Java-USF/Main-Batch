package com.revature.pojos;

import java.sql.Blob;
import java.sql.Timestamp;

import org.apache.log4j.Logger;

public class Reimbursement {

	final static Logger logger = Logger.getLogger(Reimbursement.class);
	
	private int id;
	private double amount;
	private String description;
	private String receipt;
	private Timestamp submitted;
	private Timestamp resolved;
	private int author_id;
	private int resolver_id;
	private int reimb_type;
	private int reimb_status;
	
	public Reimbursement(int id, double amount, String description, String receipt, Timestamp submitted, Timestamp resolved,
			int author_id, int resolver_id, int reimb_type, int reimb_status) {
		super();
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.receipt = receipt;
		this.submitted = submitted;
		this.resolved = resolved;
		this.author_id = author_id;
		this.resolver_id = resolver_id;
		this.reimb_type = reimb_type;
		this.reimb_status = reimb_status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public Timestamp getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public int getResolver_id() {
		return resolver_id;
	}

	public void setResolver_id(int resolver_id) {
		this.resolver_id = resolver_id;
	}

	public int getReimb_type() {
		return reimb_type;
	}

	public void setReimb_type(int reimb_type) {
		this.reimb_type = reimb_type;
	}

	public int getReimb_status() {
		return reimb_status;
	}

	public void setReimb_status(int reimb_status) {
		this.reimb_status = reimb_status;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", description=" + description + ", receipt="
				+ receipt + ", submitted=" + submitted + ", resolved=" + resolved + ", author_id=" + author_id
				+ ", resolver_id=" + resolver_id + ", reimb_type=" + reimb_type + ", reimb_status=" + reimb_status
				+ "]";
	}
}
