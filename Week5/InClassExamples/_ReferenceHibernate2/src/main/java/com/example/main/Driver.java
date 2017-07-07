package com.example.main;

import com.example.dao.BearDao;
import com.example.dao.BearDaoImpl;

public class Driver {
	
	public static void main(String[] args) {
		BearDaoImpl bd = new BearDaoImpl();
//		bd.createBear();
//		
//		bd.getOrLoad(50);
		
		//bd.mergeAndUpdate();
		
		bd.hqlAndCriteria();
	}

}
