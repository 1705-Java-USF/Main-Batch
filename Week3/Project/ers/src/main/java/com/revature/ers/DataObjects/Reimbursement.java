package com.revature.ers.DataObjects;

import java.sql.Blob;
import java.time.LocalDateTime;

public class Reimbursement {
	private int id;
	private double amount;
	private String description;
	private Blob receipt;
	private LocalDateTime submittedTime;
	private LocalDateTime resolvedTime;
	private User  author;
	private User resolver;
	private String reimbursementStatus;
	private String reimbursementType;
	
	public Reimbursement()
	{
		super();
	}
	public Reimbursement(int id, double amount, String description, Blob receipt, LocalDateTime submittedTime,
			LocalDateTime resolvedTime, User author, User resolver, String reimbursementStatus, String reimbursementType) {
		super();
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.receipt = receipt;
		this.submittedTime = submittedTime;
		this.resolvedTime = resolvedTime;
		this.author = author;
		this.resolver = resolver;
		this.reimbursementStatus = reimbursementStatus;
		this.reimbursementType = reimbursementType;
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
	public Blob getReceipt() {
		return receipt;
	}
	public void setReceipt(Blob receipt) {
		this.receipt = receipt;
	}
	public LocalDateTime getSubmittedTime() {
		return submittedTime;
	}
	public void setSubmittedTime(LocalDateTime submittedTime) {
		this.submittedTime = submittedTime;
	}
	public LocalDateTime getResolvedTime() {
		return resolvedTime;
	}
	public void setResolvedTime(LocalDateTime resolvedTime) {
		this.resolvedTime = resolvedTime;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public User getResolver() {
		return resolver;
	}
	public void setResolver(User resolver) {
		this.resolver = resolver;
	}
	public String getReimbursementStatus() {
		return reimbursementStatus;
	}
	public void setReimbursementStatus(String reimbursementStatus) {
		this.reimbursementStatus = reimbursementStatus;
	}
	public String getReimbursementType() {
		return reimbursementType;
	}
	public void setReimbursementType(String reimbursementType) {
		this.reimbursementType = reimbursementType;
	}
	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", description=" + description + ", receipt="
				+ receipt + ", submittedTime=" + submittedTime + ", resolvedTime=" + resolvedTime + ", author=" + author
				+ ", resolver=" + resolver + ", reimbursementStatus=" + reimbursementStatus + ", reimbursementType="
				+ reimbursementType + "]";
	}
	
	
	
}
