package com.revature.ers.services;

import static com.revature.util.StreamCloser.closeStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.revature.ers.DataObjects.Reimbursement;
import com.revature.util.BlobBufferedImageConverter;

public class GetReceiptService {
	private static final String DIR = "resources/images/";
	//private static final String DIR2 = "src/main/webapp/";
	private static Logger logger = Logger.getLogger(GetReceiptService.class);

	public static String getReceiptUrl(HttpServletRequest req, Reimbursement rem)
	{
		InputStream in = null;
		FileOutputStream out = null;
		String filename = DIR + "receipt" + rem.getId() + ".png";
		try {
			//look for receipt in file system.
			File file = new File(req.getServletContext().getRealPath("/" + filename));
			if(file.exists())
			{
				return filename;
			}
			Blob b = rem.getReceipt();
			if(b == null)
			{
				return null;
			}
			//convert blob to Buffered Image and back to enforce it as a png
			BlobBufferedImageConverter converter = new BlobBufferedImageConverter();
			
			b = converter.getBlob(converter.getBufferedImage(b));
			in = b.getBinaryStream();
			filename = DIR + "receipt" + rem.getId() + ".png";
			out = new FileOutputStream(file);
			byte[] buff = b.getBytes(1, (int)b.length());
			out.write(buff);
			
			
			
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage(), e);
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}finally
		{
			if(in != null)
			{
				closeStream(in);
			}
			if(out != null)
			{
				closeStream(out);
			}
		}
		return filename;
	}
	public static void clearImages()
	{
		//TODO
	}
}
