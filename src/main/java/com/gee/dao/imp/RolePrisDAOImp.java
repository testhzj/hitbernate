package com.gee.dao.imp;


import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gee.dao.RolePrisDAO;
import com.gee.dao.RolesDAO;
import com.gee.entity.Role;
import com.gee.entity.RolePri;
import com.gee.entity.RolePriInfo;

@Service
public class RolePrisDAOImp extends BaseDAOImp<RolePri> implements RolePrisDAO{
	
	@Autowired
	protected SessionFactory sessionFactory;
	
	public List<RolePriInfo> getListByRoleId(String roleId) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT r.id AS roleId, r.`role_name` AS roleName, p.`id` AS priId, p.`pri_name` AS priName ");
		sb.append("FROM roles AS r, pris AS p, role_pri AS rp ");
		sb.append("WHERE r.`id` = rp.role_id ");
		sb.append("AND p.`id`= rp.pri_id ");
		sb.append("AND r.id = :roleId");
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sb.toString());
        query.setResultTransformer(Transformers.aliasToBean(RolePriInfo.class));
		query.setParameter("roleId", roleId);
		return query.list();
	}
	
	public List<Map<String, Object>> getListMapByRoleId(String roleId) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT r.id AS roleId, r.`role_name` AS roleName, p.`id` AS priId, p.`pri_name` AS priName ");
		sb.append("FROM roles AS r, pris AS p, role_pri AS rp ");
		sb.append("WHERE r.`id` = rp.role_id ");
		sb.append("AND p.`id`= rp.pri_id ");
		sb.append("AND r.id = :roleId");
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sb.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		query.setParameter("roleId", roleId);
		return query.list();
	}
}
