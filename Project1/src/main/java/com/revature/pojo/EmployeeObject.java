package com.revature.pojo;

public class EmployeeObject {    // EmployeeObject object 
	
	private int user_id;
	private int user_role_id;
	private String user_username;
	private String user_password;
	private String user_first_name;
	private String user_last_name;
	private String user_email;
	private int user_status;
	
	public EmployeeObject(){
		
	}
	
	public EmployeeObject(int user_id, int user_role_id, String user_username, String user_password,
			String user_first_name, String user_last_name, String user_email, int user_status) {
		super();
		this.user_id = user_id; 
		this.user_role_id = user_role_id;
		this.user_username = user_username;
		this.user_password = user_password;
		this.user_first_name = user_first_name;
		this.user_last_name = user_last_name;
		this.user_email = user_email;
		this.user_status = user_status;
	}
	public EmployeeObject(int user_role_id, String user_username, String user_password,
			String user_first_name, String user_last_name, String user_email, int user_status) {
		super();
		//this.user_id = user_id; // USER_ID IS AUTO INCREMENTING
		this.user_role_id = user_role_id;
		this.user_username = user_username;
		this.user_password = user_password;
		this.user_first_name = user_first_name;
		this.user_last_name = user_last_name;
		this.user_email = user_email;
		this.user_status = user_status;
	}
	
	public int getUser_role_id() {
		return user_role_id;
	}
	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}
	public String getUser_first_name() {
		return user_first_name;
	}
	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}
	public String getUser_last_name() {
		return user_last_name;
	}
	public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public int getUser_id() {       // getters and setters
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_username() {
		return user_username;
	}
	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public int getUser_status() {
		return user_status;
	}

	public void setUser_status(int user_status) {
		this.user_status = user_status;
	}

}
