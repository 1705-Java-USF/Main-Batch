package com.revature.pojo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import com.revature.util.BlobImgConv;
import static com.revature.util.CloseStreams.close;

public class Reimbursement {
	
	private int id;
	private double amount;
	private String description;
	private Blob receipt;
	private Timestamp submitted;
	private Timestamp resolved;
	private int id_author;
	private int id_resolver;
	private int rt_id;
	private int rs_id;
	
	public Reimbursement(int id, double amount, String description, Blob receipt, Timestamp submitted,
			Timestamp resolved, int id_author, int id_resolver, int rt_id, int rs_id) {
		super();
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.receipt = receipt;
		this.submitted = submitted;
		this.resolved = resolved;
		this.id_author = id_author;
		this.id_resolver = id_resolver;
		this.rt_id = rt_id;
		this.rs_id = rs_id;
	}
	
	public Reimbursement(double amount, String description, Blob receipt, int rt_id) {
		super();
		this.amount = amount;
		this.description = description;
		this.receipt = receipt;
		this.rt_id = rt_id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
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
	public Timestamp getResolved() {
		return resolved;
	}
	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}
	public int getId_author() {
		return id_author;
	}
	public void setId_author(int id_author) {
		this.id_author = id_author;
	}
	public int getId_resolver() {
		return id_resolver;
	}
	public void setId_resolver(int id_resolver) {
		this.id_resolver = id_resolver;
	}
	public int getRt_id() {
		return rt_id;
	}
	public void setRt_id(int rt_id) {
		this.rt_id = rt_id;
	}
	public int getRs_id() {
		return rs_id;
	}
	public void setRs_id(int rs_id) {
		this.rs_id = rs_id;
	}
	
	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", description=" + description + ", receipt="
				+ receipt + ", submitted=" + submitted + ", resolved=" + resolved + ", id_author=" + id_author
				+ ", id_resolver=" + id_resolver + ", rt_id=" + rt_id + ", rs_id=" + rs_id + "]";
	}
	
	public String getReceiptUrl(HttpServletRequest req) {
		
		if(receipt == null) {
			return "";
		}
		
		BlobImgConv conv = new BlobImgConv();
		Blob blob = conv.getBlob(conv.getBuffImg(receipt));
		FileOutputStream out = null;
		
		try {
			InputStream is = blob.getBinaryStream();
			String filepath = "resources/images/" + "receipt" + id + ".png";
			File file = new File(req.getServletContext().getRealPath("/" + filepath));
			System.out.println(file.getAbsolutePath());
			out = new FileOutputStream(file);
			byte[] buff = blob.getBytes(1,  (int)blob.length());
			out.write(buff);
			return filepath;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			close(out);
		}
		return null;
	}
}