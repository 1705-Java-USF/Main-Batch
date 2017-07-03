package com.revature.ers.dao;

import java.util.List;
import java.util.Map;

public interface Dao<T> {
	
	public int create(T t);
	public T selectById(int id);
	public List<T> selectAll();
	public int deleteById(int id);
	public List<T> selectBy(Map<String,String> columnValueMap);
	public int updateBy(Map<String,String> columnValueMap, Map<String,String> conditions);
}
