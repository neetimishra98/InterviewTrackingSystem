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
	@GeneratedValue
	@Column(name="employeeid")
	private int employeeid;
	@Column(name="name")
	private String name;
	

	@OneToOne(cascade={CascadeType.ALL},
			fetch=FetchType.EAGER, optional = false)
	@JoinColumn(name="panelid")
	private PanelMemberEntity panelMemberEntity;
	
	public EmployeeEntity() {
		super();
	}

	public EmployeeEntity(int employeeid, String name, PanelMemberEntity panelMemberEntity) {
		super();
		this.employeeid = employeeid;
		this.name = name;
		this.panelMemberEntity = panelMemberEntity;
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
		return "EmployeeEntity [employeeid=" + employeeid + ", name=" + name + "panelMemberEntity ="+ panelMemberEntity+"]";
	}


}
