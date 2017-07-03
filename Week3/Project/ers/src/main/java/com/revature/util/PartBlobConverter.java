package com.revature.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialException;

import org.apache.log4j.Logger;

public class PartBlobConverter {
	private static Logger logger = Logger.getLogger(PartBlobConverter.class);

	public static Blob getBlob(Part p)
	{
		
		try {
			InputStream pin = p.getInputStream();
			ByteArrayOutputStream pout = new ByteArrayOutputStream();
			byte[] bArr = new byte[10240];
			for (int i = 0; (i = pin.read(bArr)) > 0;) 
			{
				pout.write(bArr, 0, i);
			}
			Blob b = ConnectionUtil.getConnectionUtil().getConnection().createBlob();
			
			b.setBytes(1, pout.toByteArray());
			return b;
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} catch (SerialException e) {
			logger.error(e.getMessage(), e);
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
}
