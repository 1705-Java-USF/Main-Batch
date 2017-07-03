package com.revature.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.log4j.Logger;

public class BlobBufferedImageConverter {
	private Logger logger = Logger.getLogger(BlobBufferedImageConverter.class);
	public BlobBufferedImageConverter()
	{
		
	}
	public Blob getBlob(BufferedImage bi)
	{
		
		try {
			logger.debug("Convert Buffered Image");
			ByteArrayOutputStream b = new ByteArrayOutputStream();
			ImageIO.write(bi, "png", b);
			Blob blob = new SerialBlob(b.toByteArray());
			logger.debug("Buffered Image converted to blob");
			return blob;
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} catch (SerialException e) {
			logger.error(e.getMessage(), e);
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		}
		/*
		 * ByteArrayOutputStream baos = new ByteArrayOutputStream();
ImageIO.write(bufferedImage, "png", baos);
InputStream is = new ByteArrayInputStream(baos.toByteArray());
		 */
		//Blob b = new SerialBlob();
		logger.warn("BlobBufferedImageConverter.getBlob() is returning null");
		return null;
	}
	public BufferedImage getBufferedImage(Blob b)
	{
		try {
			return ImageIO.read(b.getBinaryStream());
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		}
		logger.warn("BlobBufferedImageConverter.getBufferedIMage() is returning null");
		return null;
		
	}
}
