package com.spring.cg.json;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.spring.cg.entity.PanelMemberEntity;

import io.swagger.annotations.ApiModelProperty;

public class Employee {
	@Min(value=10000000)
	@Max(value=99999999)
	@ApiModelProperty(value="Employee ID")
	private int employeeid;
	
	@NotNull
	@NotBlank
	@ApiModelProperty(value="Employee Name")
	private String name;
	@ApiModelProperty(value="Employee PanelMember")
	private PanelMemberEntity panelMemberEntity;
	
	public Employee() {
		super();
	}

	public Employee(int employeeid, String name, PanelMemberEntity panelMemberEntity)
	{
		super();
		this.employeeid = employeeid;
		this.name = name;
		this.panelMemberEntity = panelMemberEntity;
	}
	

	public Employee(int employeeid, String name) {
		super();
		this.employeeid = employeeid;
		this.name = name;
	}

	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PanelMemberEntity getPanelMemberEntity() {
		return panelMemberEntity;
	}

	public void setPanelMemberEntity(PanelMemberEntity panelMemberEntity) {
		this.panelMemberEntity = panelMemberEntity;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [employeeid=" + employeeid + ", name=" + name + ", panelMemberEntity="
				+ panelMemberEntity + "]";
	}

}
