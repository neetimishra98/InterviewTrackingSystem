package com.spring.cg.json;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.spring.cg.entity.EmployeeEntity;
import io.swagger.annotations.ApiModelProperty;

public class PanelMember {
	@Min(value=10000000)
	@Max(value=99999999)
	@ApiModelProperty(value="Panel ID")
	private int panelid;
	
	@NotNull
	@NotBlank
	@ApiModelProperty(value="Panel Location")
	private String location;
	
	
	@NotBlank
	@ApiModelProperty(value="Panel Type")
	private String type;

	@ApiModelProperty(value="Employee ID")
	private EmployeeEntity employeeEntity;


	public PanelMember() {
		super();
	}

	public PanelMember(int panelid, String location, String type, EmployeeEntity employeeEntity) {
		super();
		this.panelid = panelid;
		this.location = location;
		this.type = type;
		this.employeeEntity = employeeEntity;
	}


	@Override
	public String toString() {
		return "PanelMemberEntity [panelid=" + panelid + ", location=" + location + ", type=" + type + ", employeeEntity="
				+ employeeEntity+"]";
	}

	public int getPanelid() {
		return panelid;
	}

	public void setPanelid(int panelid) {
		this.panelid = panelid;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public EmployeeEntity getEmployeeEntity() {
		return employeeEntity;
	}

	public void setEmployeeEntity(EmployeeEntity employeeEntity) {
		this.employeeEntity = employeeEntity;
	}

}
