package com.corvusanalyzes.services;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class Action {
	final static Logger logger = Logger.getRootLogger();
	
	public String getAction(HttpServletRequest request) {
		String url = request.getRequestURI();
		String[] tokens = url.split("/");
		String token = tokens[tokens.length-1];
		String[] actions = token.split(Pattern.quote("."));
		logger.debug("Front Controller action: " + actions[0].toLowerCase());
		return actions[0].toLowerCase();
	}
}
