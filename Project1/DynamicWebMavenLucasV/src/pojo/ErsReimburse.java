package pojo;

import java.sql.Timestamp;

public class ErsReimburse {
	private int R_ID;
	private int R_AMOUNT;
	private String R_DESCRIPTION;
	private String R_RECEIPT;
	private Timestamp R_SUBMITTED;
	private Timestamp R_RESOLVED;
	private int U_ID_AUTHOR;
	private int U_ID_RESOLVER;
	private int RT_TYPE;
	private int RS_STATUS;
	
	public ErsReimburse(){
		
	}
	
	public ErsReimburse(int r_ID, int u_ID_AUTHOR, int rT_TYPE) {
		super();
		R_ID = r_ID;
		U_ID_AUTHOR = u_ID_AUTHOR;
		RT_TYPE = rT_TYPE;
	}

	public ErsReimburse(int r_ID, int r_AMOUNT, String r_DESCRIPTION, String r_RECEIPT, Timestamp r_SUBMITTED,
			Timestamp r_RESOLVED, int u_ID_AUTHOR, int u_ID_RESOLVER, int rT_TYPE, int rS_STATUS) {
		super();
		R_ID = r_ID;
		R_AMOUNT = r_AMOUNT;
		R_DESCRIPTION = r_DESCRIPTION;
		R_RECEIPT = r_RECEIPT;
		R_SUBMITTED = r_SUBMITTED;
		R_RESOLVED = r_RESOLVED;
		U_ID_AUTHOR = u_ID_AUTHOR;
		U_ID_RESOLVER = u_ID_RESOLVER;
		RT_TYPE = rT_TYPE;
		RS_STATUS = rS_STATUS;
	}

	public int getR_ID() {
		return R_ID;
	}
	
	public void setR_ID(int r_ID) {
		R_ID = r_ID;
	}
	
	public int getR_AMOUNT() {
		return R_AMOUNT;
	}
	
	public void setR_AMOUNT(int r_AMOUNT) {
		R_AMOUNT = r_AMOUNT;
	}
	
	public String getR_DESCRIPTION() {
		return R_DESCRIPTION;
	}
	
	public void setR_DESCRIPTION(String r_DESCRIPTION) {
		R_DESCRIPTION = r_DESCRIPTION;
	}
	
	public String getR_RECEIPT() {
		return R_RECEIPT;
	}
	
	public void setR_RECEIPT(String r_RECEIPT) {
		R_RECEIPT = r_RECEIPT;
	}
	
	public Timestamp getR_SUBMITTED() {
		return R_SUBMITTED;
	}

	public void setR_SUBMITTED(Timestamp r_SUBMITTED) {
		R_SUBMITTED = r_SUBMITTED;
	}

	public Timestamp getR_RESOLVED() {
		return R_RESOLVED;
	}

	public void setR_RESOLVED(Timestamp r_RESOLVED) {
		R_RESOLVED = r_RESOLVED;
	}

	public int getU_ID_AUTHOR() {
		return U_ID_AUTHOR;
	}
	
	public void setU_ID_AUTHOR(int u_ID_AUTHOR) {
		U_ID_AUTHOR = u_ID_AUTHOR;
	}
	
	public int getU_ID_RESOLVER() {
		return U_ID_RESOLVER;
	}
	
	public void setU_ID_RESOLVER(int u_ID_RESOLVER) {
		U_ID_RESOLVER = u_ID_RESOLVER;
	}
	
	public int getRT_TYPE() {
		return RT_TYPE;
	}
	
	public void setRT_TYPE(int rT_TYPE) {
		RT_TYPE = rT_TYPE;
	}
	
	public int getRS_STATUS() {
		return RS_STATUS;
	}
	
	public void setRS_STATUS(int rS_STATUS) {
		RS_STATUS = rS_STATUS;
	}

	@Override
	public String toString() {
		return "Reimbursement ID: " + R_ID + " | Reimbursement Amount: " + R_AMOUNT + " | Quest Description: " + R_DESCRIPTION
				+ " | Proof Of Completion: " + R_RECEIPT + " | Quest Time Submitted: " + R_SUBMITTED 
				+ " | Hunter ID: " + U_ID_AUTHOR + " | Quest Type ID:" + RT_TYPE + " | ";
	}

	public String toString2() {
		return "Reimbursement ID: " + R_ID + " | Reimbursement Amount: " + R_AMOUNT + " | Quest Description: " + R_DESCRIPTION
				+ " | Proof Of Completion: " + R_RECEIPT + " | Quest Time Submitted: " + R_SUBMITTED + " | Quest Time Resolved: " + R_RESOLVED
				+ " | Hunter ID: " + U_ID_AUTHOR + " | Resolver ID: " + U_ID_RESOLVER + " | Quest Type ID:" + RT_TYPE
				+ " | Quest Status: " + RS_STATUS + " | ";
	}
	
}
