package com.spring.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="designations")
public class DesignationEntity {
	
	@Id
	@Column(name="designation")
	private String designtion;

	public DesignationEntity() {
		super();
	}

	public DesignationEntity(String designtion) {
		super();
		this.designtion = designtion;
	}
	
	public String getDesigntion() {
		return designtion;
	}

	public void setDesigntion(String designtion) {
		this.designtion = designtion;
	}

	@Override
	public String toString() {
		return "DesignationEntity [designtion=" + designtion + "]";
	}
	
	
}
