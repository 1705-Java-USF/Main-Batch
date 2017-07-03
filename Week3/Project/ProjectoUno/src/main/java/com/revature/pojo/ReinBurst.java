package com.revature.pojo;

import java.sql.Blob;

public class ReinBurst 
{
	private Integer rId;
	private Integer ammount;
	private String description;
	private String receipt;
	private String submitted;
	private String resolved;
	private Integer uIdAuthor;
	private Integer uIdResolver;
	private Integer type;
	private Integer status;
	
	public ReinBurst(Integer rId, Integer ammount, String submitted, Integer uIdAuthor, Integer type,
			Integer status) 
	{
		this.rId = rId;
		this.ammount = ammount;
		this.submitted = submitted;
		this.uIdAuthor = uIdAuthor;
		this.type = type;
		this.status = status;
	}
	public ReinBurst(Integer rId, Integer ammount, String description, String receipt, String submitted,
			String resolved, Integer uIdAuthor, Integer uIdResolver, Integer type, Integer status) 
	{
		this.rId = rId;
		this.ammount = ammount;
		this.description = description;
		this.receipt = receipt;
		this.submitted = submitted;
		this.resolved = resolved;
		this.uIdAuthor = uIdAuthor;
		this.uIdResolver = uIdResolver;
		this.type = type;
		this.status = status;
	}
	public Integer getrId() {
		return rId;
	}
	public void setrId(Integer rId) {
		this.rId = rId;
	}
	public Integer getAmmount() {
		return ammount;
	}
	public void setAmmount(Integer ammount) {
		this.ammount = ammount;
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
	public Integer getuIdAuthor() {
		return uIdAuthor;
	}
	public void setuIdAuthor(Integer uIdAuthor) {
		this.uIdAuthor = uIdAuthor;
	}
	public Integer getuIdResolver() {
		return uIdResolver;
	}
	public void setuIdResolver(Integer uIdResolver) {
		this.uIdResolver = uIdResolver;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ReinBurst [rId=" + rId + ", ammount=" + ammount + ", description=" + description + ", receipt="
				+ receipt + ", submitted=" + submitted + ", resolved=" + resolved + ", uIdAuthor=" + uIdAuthor
				+ ", uIdResolver=" + uIdResolver + ", type=" + type + ", status=" + status + "]";
	}
	
	
}
