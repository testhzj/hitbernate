package com.gee.entity;

import java.util.List;

public class RolePris {
	private Role role;
	private List<Pri> pris;
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public List<Pri> getPris() {
		return pris;
	}
	public void setPris(List<Pri> pris) {
		this.pris = pris;
	}
	@Override
	public String toString() {
		return "RolePris [role=" + role + ", pris=" + pris + "]";
	}
	
	
}
