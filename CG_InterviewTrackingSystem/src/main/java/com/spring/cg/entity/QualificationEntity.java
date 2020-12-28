package com.spring.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="qualifications")
public class QualificationEntity {
		
	@Id
	@Column(name="qualification")
	private String qualification;

	public QualificationEntity() {
		super();
	}

	public QualificationEntity(String qualification) {
		super();
		this.qualification = qualification;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	@Override
	public String toString() {
		return "QualificationEntity [qualification=" + qualification + "]";
	}
	
}
