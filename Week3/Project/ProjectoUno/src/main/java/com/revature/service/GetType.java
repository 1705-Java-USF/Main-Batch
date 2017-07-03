package com.revature.service;

import java.util.LinkedList;

import com.revature.dao.TypeDaoImp;
import com.revature.pojo.RtType;

//ABSTRACT ALL INTERACTIONS WID TYPE DAO
public class GetType 
{
	public LinkedList<RtType> getTypes()
	{
		TypeDaoImp dao = new TypeDaoImp();
		LinkedList<RtType> list = (LinkedList<RtType>) dao.selectAllType();
		return list;
	}

}
