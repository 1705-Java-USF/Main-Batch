package Database;

public class ReimbursementPOJO {
	
	private int id;
	private String descr, dateCr, dateRe;
	private int empCr, empRe;
	private double amt;
	private int type, stat;
	private String rcpt;
	
	// No args constructor
	public ReimbursementPOJO() {
			
	}
	
	// Create the plain old java object that will input the data into the database
	public ReimbursementPOJO(int id,
							 String descr,
							 String dateCr,
							 String dateRe,
							 int empCr,
							 int empRe,
							 double amt,
							 int type,
							 int stat,
							 String rcpt) {
		super();
		this.id = id;
		this.descr = descr;
		this.dateCr = dateCr;
		this.dateRe = dateRe;
		this.empCr = empCr;
		this.empRe = empRe;
		this.amt = amt;
		this.type = type;
		this.stat = stat;
		this.rcpt = rcpt;
	}

	// GETTERS AND SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getDateCr() {
		return dateCr;
	}

	public void setDateCr(String dateCr) {
		this.dateCr = dateCr;
	}

	public String getDateRe() {
		return dateRe;
	}

	public void setDateRe(String dateRe) {
		this.dateRe = dateRe;
	}

	public int getEmpCr() {
		return empCr;
	}

	public void setEmpCr(int empCr) {
		this.empCr = empCr;
	}

	public int getEmpRe() {
		return empRe;
	}

	public void setEmpRe(int empRe) {
		this.empRe = empRe;
	}

	public double getAmt() {
		return amt;
	}

	public void setAmt(double amt) {
		this.amt = amt;
	}

	public String getRcpt() {
		return rcpt;
	}

	public void setRcpt(String rcpt) {
		this.rcpt = rcpt;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStat() {
		return stat;
	}

	public void setStat(int stat) {
		this.stat = stat;
	}

	@Override
	public String toString() {
		return "ReimbursementPOJO [id=" + id + ", descr=" + descr + ", dateCr=" + dateCr + ", dateRe=" + dateRe
				+ ", empCr=" + empCr + ", empRe=" + empRe + ", amt=" + amt + ", rcpt=" + rcpt + ", type=" + type
				+ ", stat=" + stat + "]";
	}
	
}
