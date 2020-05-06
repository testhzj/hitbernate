package com.gee.dao;


import java.util.List;
import java.util.Map;

import com.gee.entity.RolePri;
import com.gee.entity.RolePriInfo;

public interface RolePrisDAO extends BaseDAO<RolePri>{
	public List<RolePriInfo> getListByRoleId(String roleId);
	public List<Map<String, Object>> getListMapByRoleId(String roleId);
}
