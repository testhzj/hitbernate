package com.gee.dao.imp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gee.BaseTest;
import com.gee.dao.RolesDAO;
import com.gee.entity.Role;

public class RolesDAOImpTest extends BaseTest{
	
	@Autowired
	private RolesDAO rolesDAO;
	
	@Test
	public void save() {
		Role role = new Role();
		role.setRoleName("管理員");
		rolesDAO.save(role);
	}
	
	@Test
	public void findCount() {
		System.out.println(rolesDAO.findCount(Role.class));
	}
	
	
	@Test
	public void findById() {
		System.out.println(rolesDAO.getRolesById("4028d80171c9b7af0171c9b7b2730000"));
	}
	
	@Test
	public void findByIds() {
		System.out.println(rolesDAO.getRolesByIds(Arrays.asList("4028d80171c9b7af0171c9b7b2730000")));
	}
	
	@Test
	public void update() {
		Map params = new HashMap();
		params.put("role_name", "admin");
		params.put("id", "4028d80171c9b7af0171c9b7b2730000");
		rolesDAO.update(params);
	}
	
	@Test
	public void delete() {
		rolesDAO.delete(Role.class, "4028d80171c9b7af0171c9b7b2730000");
	}
}
