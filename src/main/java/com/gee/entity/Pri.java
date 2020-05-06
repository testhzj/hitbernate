package com.gee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "pris")
public class Pri {
	//主键
	@Id
	//指定主键生成策略
	@GenericGenerator(name = "generator", strategy = "uuid")
    @GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false, length = 32)
    private String id;
	
	@Column(name = "pri_name", nullable = false, length = 32)
    private String PriName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPriName() {
		return PriName;
	}

	public void setPriName(String priName) {
		PriName = priName;
	}

	@Override
	public String toString() {
		return "Pri [id=" + id + ", PriName=" + PriName + "]";
	}
	
	
}
