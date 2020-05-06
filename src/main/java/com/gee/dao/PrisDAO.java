package com.gee.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;

import com.gee.entity.Pri;
import com.gee.entity.Role;

public interface PrisDAO extends BaseDAO<Pri>{
	 Pri getPrisById(String id);
	 List<Pri> getPrisByIds(List<String> ids);
	 int update(Map<String, Object> paramsMap);
}
