package com.gee.dao.imp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gee.BaseTest;
import com.gee.dao.PrisDAO;
import com.gee.dao.RolesDAO;
import com.gee.entity.Pri;
import com.gee.entity.Role;

public class PrisDAOImpTest extends BaseTest{
	
	@Autowired
	private PrisDAO prisDAO;
	
	@Test
	public void save() {
		Pri pri = new Pri();
		pri.setPriName("权限3");
		prisDAO.save(pri);
	}
	
	@Test
	public void list()	{
		List<Integer> lists = new ArrayList();
	}
}
