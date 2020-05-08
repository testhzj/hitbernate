package com.gee.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "roles")
public class Role {
	
	//主键
	@Id
	//指定主键生成策略
	@GenericGenerator(name = "generator", strategy = "uuid")
    @GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false, length = 32)
    private String id;
	
	@Column(name = "role_name", nullable = false, length = 32)
    private String roleName;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + "]";
	}

	public Role() {
		
	}
	
	
	
}
