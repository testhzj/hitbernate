package com.gee.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;

import com.gee.entity.Role;

public interface RolesDAO extends BaseDAO<Role>{
	 Role getRolesById(String id);
	 List<Role> getRolesByIds(List<String> ids);
	 int update(Map<String, Object> paramsMap);
}
