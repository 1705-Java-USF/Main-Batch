package com.revature.pojo;

public class Users {

	
private int U_ID;
private String U_USERNAME;
private String U_PASSWORD;
private String U_FIRSTNAME;
private String U_LASTNAME;
private String U_EMAIL;
private int UR_ID;

public Users(){
	
}
public Users(int u_ID, String u_USERNAME, String u_PASSWORD, String u_FIRSTNAME, String u_LASTNAME, String u_EMAIL,
		int uR_ID) {
	super();
	U_ID = u_ID;
	U_USERNAME = u_USERNAME;
	U_PASSWORD = u_PASSWORD;
	U_FIRSTNAME = u_FIRSTNAME;
	U_LASTNAME = u_LASTNAME;
	U_EMAIL = u_EMAIL;
	UR_ID = uR_ID;
}

public Users(String u_USERNAME, String u_PASSWORD,String u_EMAIL) {
	super();
	U_EMAIL = u_EMAIL;
	U_USERNAME = u_USERNAME;
	U_PASSWORD = u_PASSWORD;
}

public Users(String u_USERNAME, String u_PASSWORD, String u_FIRSTNAME, String u_LASTNAME, String u_EMAIL) {
	super();
	U_USERNAME = u_USERNAME;
	U_PASSWORD = u_PASSWORD;
	U_FIRSTNAME = u_FIRSTNAME;
	U_LASTNAME = u_LASTNAME;
	U_EMAIL = u_EMAIL;
}

public int getU_ID() {
	return U_ID;
}
public void setU_ID(int u_ID) {
	U_ID = u_ID;
}
public String getU_USERNAME() {
	return U_USERNAME;
}
public void setU_USERNAME(String u_USERNAME) {
	U_USERNAME = u_USERNAME;
}
public String getU_PASSWORD() {
	return U_PASSWORD;
}
public void setU_PASSWORD(String u_PASSWORD) {
	U_PASSWORD = u_PASSWORD;
}
public String getU_FIRSTNAME() {
	return U_FIRSTNAME;
}
public void setU_FIRSTNAME(String u_FIRSTNAME) {
	U_FIRSTNAME = u_FIRSTNAME;
}
public String getU_LASTNAME() {
	return U_LASTNAME;
}
public void setU_LASTNAME(String u_LASTNAME) {
	U_LASTNAME = u_LASTNAME;
}
public String getU_EMAIL() {
	return U_EMAIL;
}
public void setU_EMAIL(String u_EMAIL) {
	U_EMAIL = u_EMAIL;
}
public int getUR_ID() {
	return UR_ID;
}
public void setUR_ID(int uR_ID) {
	UR_ID = uR_ID;
}

@Override
public String toString() {
	return "Users [U_ID=" + U_ID + ", U_USERNAME=" + U_USERNAME + ", U_PASSWORD=" + U_PASSWORD + ", U_FIRSTNAME="
			+ U_FIRSTNAME + ", U_LASTNAME=" + U_LASTNAME + ", U_EMAIL=" + U_EMAIL + ", UR_ID=" + UR_ID + "]";
}
	
}
