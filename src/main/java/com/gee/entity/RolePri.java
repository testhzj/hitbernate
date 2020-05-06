package com.gee.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role_pri")
public class RolePri {
	
	@Id
	private RolePriId rolePriId;

	public RolePriId getRolePriId() {
		return rolePriId;
	}

	public void setRolePriId(RolePriId rolePriId) {
		this.rolePriId = rolePriId;
	}

	@Override
	public String toString() {
		return "RolePri [rolePriId=" + rolePriId + "]";
	}
	
	
}
