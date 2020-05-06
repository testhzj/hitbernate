package com.gee.entity;

public class RolePriInfo {
	private String roleName;
	private String priName;
	private String roleId;
	private String priId;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getPriName() {
		return priName;
	}
	public void setPriName(String priName) {
		this.priName = priName;
	}
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
		return "RolePriInfo [roleName=" + roleName + ", priName=" + priName + ", roleId=" + roleId + ", priId=" + priId
				+ "]";
	}
	
}
