package pojo;

public class ErsUser {
	public int U_ID;
	public String U_USERNAME;
	private String U_PASSWORD;
	private String U_FIRSTNAME;
	private String U_LASTNAME;
	private String U_EMAIL;
	private int UR_ID;
	
	public ErsUser(){
		
	}
	
	public ErsUser(int u_ID, String u_USERNAME, String u_PASSWORD, int uR_ID) {
		super();
		this.U_ID = u_ID;
		this.U_USERNAME = u_USERNAME;
		this.U_PASSWORD = u_PASSWORD;
		this.UR_ID = uR_ID;
	}

	public ErsUser(int u_ID, String u_USERNAME, String u_PASSWORD, 
			String u_FIRSTNAME, String u_LASTNAME, String u_EMAIL, int uR_ID) {
		super();
		this.U_ID = u_ID;
		this.U_USERNAME = u_USERNAME;
		this.U_PASSWORD = u_PASSWORD;
		this.U_FIRSTNAME = u_FIRSTNAME;
		this.U_LASTNAME = u_LASTNAME;
		this.U_EMAIL = u_EMAIL;
		this.UR_ID = uR_ID;
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
		String s = "User ID: " + U_ID + " | Username: " + U_USERNAME + " | First Name: "
				+ U_FIRSTNAME + " | Last Name: " + U_LASTNAME + " | Email: " + U_EMAIL + " | Role ID: " + UR_ID + " | ";
		return s;
	}
	
	
	
}
