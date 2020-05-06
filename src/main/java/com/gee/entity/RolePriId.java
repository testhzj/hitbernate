package com.gee.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RolePriId implements Serializable{

	@Column(name = "role_id", nullable = false, length = 32)
	private String roleId;
	
	@Column(name = "pri_id", nullable = false, length = 32)
	private String priId;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getPriId() {
		return priId;
	}

	public void setPriId(String priId) {
		this.priId = priId;
	}

	@Override
	public String toString() {
		return "RolePriId [roleId=" + roleId + ", priId=" + priId + "]";
	};
	
	
	
}
