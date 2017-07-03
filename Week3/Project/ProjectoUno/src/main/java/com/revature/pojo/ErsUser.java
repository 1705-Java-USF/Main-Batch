package com.revature.pojo;

public class ErsUser 
{
	private Integer uId;
	private String userName;
	private String passWord;
	private String firstName;
	private String lastName;
	private String email;
	private Integer urId;
	
	public ErsUser()
	{}

	public ErsUser(String userName, String passWord) 
	{
		this.userName = userName;
		this.passWord = passWord;
	}
	
	public ErsUser(Integer id, String userName, String passWord, String firstName, String lastName, String email, Integer urId) 
	{
		this.uId = id;
		this.userName = userName;
		this.passWord = passWord;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.urId = urId;
	}
	
	public ErsUser(String userName, String passWord, String firstName, String lastName, String email) 
	{
		this.userName = userName;
		this.passWord = passWord;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getUrId() {
		return urId;
	}

	public void setUrId(Integer urId) {
		this.urId = urId;
	}

	@Override
	public String toString() {
		return "ErsUser [uId=" + uId + ", userName=" + userName + ", passWord=" + passWord + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", urId=" + urId + "]";
	}
	
	
}
