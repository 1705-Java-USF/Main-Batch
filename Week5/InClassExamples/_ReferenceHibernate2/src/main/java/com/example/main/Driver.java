package com.example.main;

import com.example.dao.BearDao;
import com.example.dao.BearDaoImpl;

public class Driver {
	
	public static void main(String[] args) {
		BearDao bd = new BearDaoImpl();
		bd.createBear();
		

	}

}
