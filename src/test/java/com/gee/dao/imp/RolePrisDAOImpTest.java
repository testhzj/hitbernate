package com.gee.dao.imp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gee.BaseTest;
import com.gee.dao.RolePrisDAO;
import com.gee.dao.RolesDAO;
import com.gee.entity.Role;
import com.gee.entity.RolePri;
import com.gee.entity.RolePriId;
import com.gee.entity.RolePriInfo;

public class RolePrisDAOImpTest extends BaseTest{
	
	@Autowired
	private RolePrisDAO rolePrisDAO;
	
	@Test
	public void save() {
		RolePriId rpId = new RolePriId();
		rpId.setRoleId("4028d80171c9b7af0171c9b7b2730000");
		rpId.setPriId("4028d80171e78c730171e78c76c90000");
		RolePri rolePri = new RolePri();
		rolePri.setRolePriId(rpId);
		
		rolePrisDAO.save(rolePri);
	}
	
	@Test
	public void list() {
		List<RolePriInfo> list = rolePrisDAO.getListByRoleId("4028d80171c9b7af0171c9b7b2730000"
				);
		System.out.println(list.get(1));
	}
	
	@Test
	public void listMap() {
		List<Map<String, Object>> list = rolePrisDAO.getListMapByRoleId("4028d80171c9b7af0171c9b7b2730000");
		System.out.println(list.get(0).get("roleId"));
		
	}
}
