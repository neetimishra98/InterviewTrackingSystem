package com.spring.cg.json;

import io.swagger.annotations.ApiModelProperty;

public class PrimarySkills {
	
	@ApiModelProperty(value="PrimarySkill")
	private String primaryskill;

	public PrimarySkills() {
		super();
	}

	public PrimarySkills(String primaryskill) {
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
		return "PrimarySkills [primaryskill=" + primaryskill + "]";
	}
	
}
