package com.gee.dao.imp;


import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gee.dao.PrisDAO;
import com.gee.dao.RolesDAO;
import com.gee.entity.Pri;
import com.gee.entity.Role;

@Service
public class PrisDAOImp extends BaseDAOImp<Pri> implements PrisDAO{
	
	@Autowired
	private SessionFactory sfac;
	
	public Pri getPrisById(String id) {
		String sql = "select p.id as id, p.pri_name as priName from pris p where p.id=:id";
		Query query = sfac.getCurrentSession().createSQLQuery(sql);
		query.setString("id", id).setResultTransformer(Transformers.aliasToBean(Pri.class));
		return (Pri) query.uniqueResult();
	}
	
	public List<Pri> getPrisByIds(List<String> ids) {
		String sql = "select p.id as id, p.pri_name as priName from pris p where p.id in (:id)";
		Query query = sfac.getCurrentSession().createSQLQuery(sql);
		query.setParameterList("id", ids).setResultTransformer(Transformers.aliasToBean(Role.class));
		return query.list();
	}

	public int update(Map<String, Object> paramsMap) {
		String sql = "update pris set pri_name = :pri_name where id = :id";
		Query query = sfac.getCurrentSession().createSQLQuery(sql);
		query.setParameter("pri_name", paramsMap.get("pri_name"));
		query.setParameter("id", paramsMap.get("id"));
		return query.executeUpdate();
	}
	
}
