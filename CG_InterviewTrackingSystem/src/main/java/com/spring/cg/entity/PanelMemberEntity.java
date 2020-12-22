package com.spring.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="panelmember")
public class PanelMemberEntity {
	
	@Id
	@GeneratedValue
	@Column(name="panelid")
	private int panelid;
	
	@Column(name="location")
	private String location;
	
	@Column(name="type")
	private String type;
		
	public PanelMemberEntity() {
		super();
	}
	
	public PanelMemberEntity(int panelid, String location, String type) {
		super();
		this.panelid = panelid;
		this.location = location;
		this.type = type;
	}


	@Override
	public String toString() {
		return "PanelMemberEntity [panelid=" + panelid + ", location=" + location + ", type=" + type + ", employeeID="
				 + "]";
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

}
