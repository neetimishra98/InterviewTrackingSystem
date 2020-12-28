package com.spring.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="secondaryskills")
public class SecondarySkillsEntity {
	
	@Id
	@Column(name="secondaryskill")
	private String secondaryskill;

	public SecondarySkillsEntity() {
		super();
	}

	public SecondarySkillsEntity(String secondaryskill) {
		super();
		this.secondaryskill = secondaryskill;
	}

	public String getSecondaryskill() {
		return secondaryskill;
	}

	public void setSecondaryskill(String secondaryskill) {
		this.secondaryskill = secondaryskill;
	}

	@Override
	public String toString() {
		return "SecondarySkillsEntity [secondaryskill=" + secondaryskill + "]";
	}
}
