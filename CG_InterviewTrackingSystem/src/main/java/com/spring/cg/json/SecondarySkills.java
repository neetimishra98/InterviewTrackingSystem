package com.spring.cg.json;

import io.swagger.annotations.ApiModelProperty;

public class SecondarySkills {
	
	@ApiModelProperty(value="SecondarySkill")
	private String secondaryskill;

	public SecondarySkills() {
		super();
	}

	public SecondarySkills(String secondaryskill) {
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
		return "SecondarySkills [secondaryskill=" + secondaryskill + "]";
	}
	
}
