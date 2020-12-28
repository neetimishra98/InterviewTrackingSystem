package com.spring.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="primaryskills")
public class PrimarySkillsEntity {

	@Id
	@Column(name="primaryskill")
	private String primaryskill;

	public PrimarySkillsEntity() {
		super();
	}

	public PrimarySkillsEntity(String primaryskill) {
		super();
		this.primaryskill = primaryskill;
	}

	public String getPrimaryskill() {
		return primaryskill;
	}

	public void setPrimaryskill(String primaryskill) {
		this.primaryskill = primaryskill;
	}

	@Override
	public String toString() {
		return "PrimarySkillsEntity [primaryskill=" + primaryskill + "]";
	}
	
	
}
