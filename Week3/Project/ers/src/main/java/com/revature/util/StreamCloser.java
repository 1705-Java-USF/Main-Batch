package com.revature.util;

import org.apache.log4j.Logger;

public class StreamCloser {
	private static Logger logger = Logger.getLogger(StreamCloser.class);
	public static void closeStream(AutoCloseable stream)
	{
		try {
			if(stream != null)
			{
				stream.close();
				logger.debug("Stream Closed: " + stream.getClass());
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage(), e);
			
		}
	}
}
