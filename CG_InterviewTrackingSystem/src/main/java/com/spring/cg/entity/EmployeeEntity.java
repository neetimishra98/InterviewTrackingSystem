package com.spring.cg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="employee")
public class EmployeeEntity {
	
	@Id
	@Column(name="employeeid")
	private int employeeid;
	@Column(name="name")
	private String name;
	
	public EmployeeEntity() {
		super();
	}

	public EmployeeEntity(int employeeid, String name) {
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
