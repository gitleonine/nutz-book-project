package org.nutz.dao.mapper.impl;

import java.lang.reflect.Method;

import org.nutz.dao.Dao;
import org.nutz.dao.mapper.MethodMapper;

public class QueryMethodMapper extends MethodMapper {

	public QueryMethodMapper(Dao dao, Method method, String pName) {
		super(dao, method, pName);
	}

	public Object exec(Object[] args) {
		return dao.query(pojoType, makeCnd(args));
	}
	
	public String prefix() {
		return "query";
	}
}
