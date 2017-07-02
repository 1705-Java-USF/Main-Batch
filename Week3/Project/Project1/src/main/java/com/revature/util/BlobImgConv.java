package com.revature.util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

public class BlobImgConv {
	public BufferedImage getBuffImg(Blob b) {
		
		try {
			return ImageIO.read(b.getBinaryStream());
		}
		catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Blob getBlob(BufferedImage img) {
		
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ImageIO.write(img, "png", bos);
			Blob b;
			b = new SerialBlob(bos.toByteArray());
			return b;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
