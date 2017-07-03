package Database;

public class EmployeePOJO {

	private int id;
	private String fn, ln, addr, city, st, zip, phone, email;
	private int role;
	private String userid, pwd;
	
	// No args constructor
	public EmployeePOJO() {
		
	}
	
	// Create the plain old java object that will input the data into the database
	public EmployeePOJO(int id,
						String fn,
						String ln,
						String addr,
						String city,
						String st,
						String zip,
						String phone,
						String email,
						int role,
						String userid,
						String pwd) {
		super();
		this.id = id;
		this.fn = fn;
		this.ln = ln;
		this.addr = addr;
		this.city = city;
		this.st = st;
		this.zip = zip;
		this.phone = phone;
		this.email = email;
		this.role = role;
		this.userid = userid;
		this.pwd = pwd;
	}
	
	// GETTERS AND SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSt() {
		return st;
	}

	public void setSt(String st) {
		this.st = st;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "EmployeePOJO [id=" + id + ", fn=" + fn + ", ln=" + ln + ", addr=" + addr + ", city=" + city + ", st="
				+ st + ", zip=" + zip + ", phone=" + phone + ", email=" + email + ", role=" + role + ", userid="
				+ userid + ", pwd=" + pwd + "]";
	}
	
	
	
}
