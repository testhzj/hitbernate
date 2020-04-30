package com.gee.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;

public interface BaseDAO<T> {
	/**
     * 根据ID加载实体
     * @param entityClazz
     * @param id
     * @return
     */
    T get(Class<T> entityClazz , Serializable id);
    
    /**
     * 保存实体
     * @param entity
     * @return
     */
    Serializable save(T entity);
    
    /**
     * 更新实体
     * @param entity
     */
    void update(T entity);
    
    /**
     * 删除实体
     * @param entity
     */
    void delete(T entity);
    
    /**
     * 根据ID删除实体
     * @param entityClazz
     * @param id
     */
    boolean delete(Class<T> entityClazz , Serializable id);
    
    /**
     * 获取所有实体
     * @param entityClazz
     * @return
     */
    List<T> findAll(Class<T> entityClazz);
    
    /**
     * 获取实体总数
     * @param entityClazz
     * @return
     */
    long findCount(Class<T> entityClazz);
    
    
	 /**
     * 根据HQL语句查询实体
     * @param hql           待查询的HQL语句
     * @return
     */
    List<T> find(String hql);
    
    /**
     * 使用hql 语句进行分页查询操作
     * @param hql       需要查询的hql语句
     * @param pageNo    查询第pageNo页的记录
     * @param pageSize  每页需要显示的记录数
     * @return          当前页的所有记录
     */
    List<T> findByPage(String hql, int pageNo, int pageSize);
    
    
    /**
     * 使用hql 语句进行分页查询操作
     * @param hql       需要查询的hql语句
     * @param pageNo    查询第pageNo页的记录
     * @param pageSize  每页需要显示的记录数
     * @param params    如果hql带占位符参数，params用于传入占位符参数
     * @return          当前页的所有记录
     */
    List<T> findByPage(String hql , int pageNo, int pageSize, Object... params);
    
}
