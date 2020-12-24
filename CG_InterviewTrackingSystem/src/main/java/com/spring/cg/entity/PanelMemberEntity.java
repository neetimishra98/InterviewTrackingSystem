package com.spring.cg.entity;

import javax.persistence.*;

@Entity
@Table(name="panelmember")
public class PanelMemberEntity {
	
	@Id
	@Column(name="panelid")
	private int panelid;
	
	@Column(name="location")
	private String location;
	
	@Column(name="type")
	private String type;

	@OneToOne(cascade={CascadeType.ALL},
			fetch=FetchType.EAGER, optional = false)
	@JoinColumn(name="employeeid")
	private EmployeeEntity employeeEntity;

	public PanelMemberEntity() {
		super();
	}
	
	public PanelMemberEntity(int panelid, String location, String type, EmployeeEntity employeeEntity) {
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
