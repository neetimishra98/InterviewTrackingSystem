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
	
	public Employee() {
		super();
	}

	public Employee(int employeeid, String name)
	{
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

	@Override
	public String toString() {
		return "EmployeeEntity [employeeid=" + employeeid + ", name=" + name +"]";
	}

}
