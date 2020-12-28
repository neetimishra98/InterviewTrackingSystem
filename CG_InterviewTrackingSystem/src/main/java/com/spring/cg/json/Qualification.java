package com.spring.cg.json;

import io.swagger.annotations.ApiModelProperty;

public class Qualification {
	
	@ApiModelProperty(value="Qualification")
	private String qualification;

	public Qualification() {
		super();
	}

	public Qualification(String qualification) {
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
		return "Qualification [qualification=" + qualification + "]";
	}

}
