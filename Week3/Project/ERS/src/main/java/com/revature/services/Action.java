package com.revature.services;

public class Action {
	public String getAction(String url){
		
		String[] tokens = url.split("/");
		
		String action = tokens[tokens.length-1];
		
		action = action.substring(0, action.length()-3).toLowerCase();
		
		return action;
	}
}
