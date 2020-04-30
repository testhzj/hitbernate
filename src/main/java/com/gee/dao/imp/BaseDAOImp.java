package com.gee.dao.imp;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gee.dao.BaseDAO;


public class BaseDAOImp<T> implements BaseDAO<T>{
	
	@Autowired
	protected SessionFactory sessionFactory;

	public T get(Class entityClazz, Serializable id) {
		return (T) sessionFactory.getCurrentSession().get(entityClazz, id);
	}
	
	public Serializable save(T entity) {
		return sessionFactory.getCurrentSession().save(entity);
	}
	
	public void update(T entity) {
		sessionFactory.getCurrentSession().update(entity);
	}
	
	public void delete(Object entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}
	
	public boolean delete(Class entityClazz, Serializable id) {
		String hql = "delete " + entityClazz.getSimpleName() + " en where en.id = ?0";
        Query query = sessionFactory.getCurrentSession()
                                 .createQuery(hql)
                                 .setParameter("0", id);
        return (query.executeUpdate() > 0);
	}
	
	public List findAll(Class entityClazz) {
		String hql = "select en from " + entityClazz.getSimpleName() + " en";
        return find(hql);
	}
	
	public long findCount(Class entityClazz) {
		//String  hql  = "select count(*) from " + entityClazz.getSimpleName();
		String  hql  = "select count(*) from " + entityClazz.getSimpleName();
        List<T> list = find(hql);
        if (list != null && list.size() == 1) {
            return (Long) list.get(0);
        }
        return 0;
	}
	
	 /**
     * 根据HQL语句查询实体
     * @param hql           待查询的HQL语句
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<T> find(String hql) {
        return sessionFactory.getCurrentSession()
                             .createQuery(hql)
                             .list();
    }
    
    
    /**
     * 使用hql 语句进行分页查询操作
     * @param hql       需要查询的hql语句
     * @param pageNo    查询第pageNo页的记录
     * @param pageSize  每页需要显示的记录数
     * @return          当前页的所有记录
     */
    @SuppressWarnings("unchecked")
    public List<T> findByPage(String hql, int pageNo, int pageSize) {
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.setFirstResult((pageNo-1) * pageSize)
                    .setMaxResults(pageSize)
                    .list();
    }
    
    
    /**
     * 使用hql 语句进行分页查询操作
     * @param hql       需要查询的hql语句
     * @param pageNo    查询第pageNo页的记录
     * @param pageSize  每页需要显示的记录数
     * @param params    如果hql带占位符参数，params用于传入占位符参数
     * @return          当前页的所有记录
     */
    @SuppressWarnings("unchecked")
    public List<T> findByPage(String hql , int pageNo, int pageSize, Object... params) {
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        for (int i=0, len=params.length; i<len; i++) {
            query.setParameter(i + "", params[i]);
        }
        return query.setFirstResult((pageNo - 1) + pageSize)
                    .setMaxResults(pageSize)
                    .list();
    }
    
}	
