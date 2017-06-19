package com.revature.day2;

public class AccessModifiers {
	//Only public, abstract, and final can be used for classes.
	//Access modifiers limit access to a resource
	/*
	 * Main modifiers:
	 * Private
	 * "Default" (No access modifier)
	 * Protected
	 * Public
	 */
	
	public String pub = "public";		//Public: accessible from anywhere, global
	protected String pro = "protected";	//Protected: Accessible from within the package, or through subclass
	String def = "default";				//Default: Only from within same package
	private String pri = "private";		//Private: Only accessible from within its own class
	
	public String getPub() {
		return pub;
	}
	protected String getPro() {
		return pro;
	}
	String getDef() {
		return def;
	}
	private String getPri() {
		return pri;
	}
	
	

}
