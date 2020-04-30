package com.gee.dao.imp;


import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gee.dao.RolesDAO;
import com.gee.entity.Role;

@Service
public class RolesDAOImp extends BaseDAOImp<Role> implements RolesDAO{
	
	@Autowired
	private SessionFactory sfac;
	
	public Role getRolesById(String id) {
		String sql = "select r.id as id, r.role_name as roleName from roles r where r.id=:id";
		Query query = sfac.getCurrentSession().createSQLQuery(sql);
		query.setString("id", id).setResultTransformer(Transformers.aliasToBean(Role.class));
		return (Role) query.uniqueResult();
	}
	
	public List<Role> getRolesByIds(List<String> ids) {
		String sql = "select r.id as id, r.role_name as roleName from roles r where r.id in (:id)";
		Query query = sfac.getCurrentSession().createSQLQuery(sql);
		query.setParameterList("id", ids).setResultTransformer(Transformers.aliasToBean(Role.class));
		return query.list();
	}

	public int update(Map<String, Object> paramsMap) {
		String sql = "update roles set role_name = :role_name where id = :id";
		Query query = sfac.getCurrentSession().createSQLQuery(sql);
		query.setParameter("role_name", paramsMap.get("role_name"));
		query.setParameter("id", paramsMap.get("id"));
		return query.executeUpdate();
	}
}
