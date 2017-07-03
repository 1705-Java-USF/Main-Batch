package com.revature.pojo;

import java.sql.Blob;
import java.sql.Timestamp;

public class RebsObj {
	
	private int rebsId;
	private int userId;
	private int managerId;
	private int rebsType;
	private int rebsStatus;
	private double rebsAmount;
	private String rebsDescription;
	private Blob rebsAttachments;
	private Timestamp timeSubmitted;
	private Timestamp timeResolved;
	
	public RebsObj() {
		
	}

	public RebsObj(int userId, int rebsType, int rebsStatus, double rebsAmount, String rebsDescription) {
		super();
		this.userId = userId;
		this.rebsType = rebsType;
		this.rebsStatus = rebsStatus;
		this.rebsAmount = rebsAmount;
		this.rebsDescription = rebsDescription;
	}

	public RebsObj(int rebsId, int userId, int managerId, int rebsType, int rebsStatus, double rebsAmount,
			String rebsDescription, Blob rebsAttachments, Timestamp timeSubmitted, Timestamp timeResolved) {
		super();
		this.rebsId = rebsId;
		this.userId = userId;
		this.managerId = managerId;
		this.rebsType = rebsType;
		this.rebsStatus = rebsStatus;
		this.rebsAmount = rebsAmount;
		this.rebsDescription = rebsDescription;
		this.rebsAttachments = rebsAttachments;
		this.timeSubmitted = timeSubmitted;
		this.timeResolved = timeResolved;
	}

	public int getRebsId() {
		return rebsId;
	}

	public void setRebsId(int rebsId) {
		this.rebsId = rebsId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getRebsType() {
		return rebsType;
	}

	public void setRebsType(int rebsType) {
		this.rebsType = rebsType;
	}

	public int getRebsStatus() {
		return rebsStatus;
	}

	public void setRebsStatus(int rebsStatus) {
		this.rebsStatus = rebsStatus;
	}

	public double getRebsAmount() {
		return rebsAmount;
	}

	public void setRebsAmount(double rebsAmount) {
		this.rebsAmount = rebsAmount;
	}

	public String getRebsDescription() {
		return rebsDescription;
	}

	public void setRebsDescription(String rebsDescription) {
		this.rebsDescription = rebsDescription;
	}

	public Blob getRebsAttachments() {
		return rebsAttachments;
	}

	public void setRebsAttachments(Blob rebsAttachments) {
		this.rebsAttachments = rebsAttachments;
	}

	public Timestamp getTimeSubmitted() {
		return timeSubmitted;
	}

	public void setTimeSubmitted(Timestamp timeSubmitted) {
		this.timeSubmitted = timeSubmitted;
	}

	public Timestamp getTimeResolved() {
		return timeResolved;
	}

	public void setTimeResolved(Timestamp timeResolved) {
		this.timeResolved = timeResolved;
	}
	
	
}
