package com.corvusanalyzes.pojos;

import java.sql.Blob;
import java.sql.Timestamp;

import com.corvusanalyzes.dao.ReimbursementsDAO;
import com.corvusanalyzes.dao.ReimbursementsDAOInterface;
import com.corvusanalyzes.dao.UsersDAO;
import com.corvusanalyzes.dao.UsersDAOInterface;

public class Reimbursement {
	private int id;
	private float amount;
	private String description;
	private Blob receipt;
	private Timestamp submitted;
	private Timestamp resolved;
	private int author_id;
	private int resolver_id;
	private int type_id;
	private int status_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
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
	public Timestamp getSubmitted() {
		return submitted;
	}
	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}
	public String getResolved() {
		if(resolved == null)
			return "Unresolved";
		else
			return resolved.toString();
	}
	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}
	public int getAuthor() {
		return author_id;
	}
	public String getAuthorString() {
		UsersDAOInterface users = new UsersDAO();
		return users.selectUsernameById(author_id);
	}
	public void setAuthor(int author_id) {
		this.author_id = author_id;
	}
	public int getResolver() {
		return resolver_id;
	}
	public String getResolverString() {
		UsersDAOInterface users = new UsersDAO();
		if(resolver_id == 0) return "Unresolved";
		else return users.selectUsernameById(resolver_id);
	}
	public void setResolver(int resolver_id) {
		this.resolver_id = resolver_id;
	}
	public int getType() {
		return type_id;
	}
	public String getTypeString() {
		ReimbursementsDAOInterface reimbursements = new ReimbursementsDAO();
		return reimbursements.selectTypeFromTypeId(type_id);
	}
	public void setType(int type_id) {
		this.type_id = type_id;
	}
	public int getStatus() {
		return status_id;
	}
	public String getStatusString() {
		ReimbursementsDAOInterface reimbursements = new ReimbursementsDAO();
		return reimbursements.selectStatusFromStatusId(status_id);
	}
	public void setStatus(int status_id) {
		this.status_id = status_id;
	}
	
	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", description=" + description + ", receipt="
				+ receipt + ", submitted=" + submitted + ", resolved=" + resolved + ", author=" + author_id + ", resolver="
				+ resolver_id + ", type=" + type_id + ", status=" + status_id + "]";
	}
}
