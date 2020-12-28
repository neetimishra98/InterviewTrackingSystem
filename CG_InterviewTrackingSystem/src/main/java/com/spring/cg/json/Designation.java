package com.spring.cg.json;

import io.swagger.annotations.ApiModelProperty;

public class Designation {
	
	@ApiModelProperty(value="Designation")
	private String designation;

	public Designation() {
		super();
	}

	public Designation(String designation) {
		super();
		this.designation = designation;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Designation [designation=" + designation + "]";
	}
	
	
}
