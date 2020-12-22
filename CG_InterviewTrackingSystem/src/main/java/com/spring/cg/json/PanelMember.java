package com.spring.cg.json;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	
	@NotNull
	@NotBlank
	@ApiModelProperty(value="Panel Type")
	private String type;
	
	
	public PanelMember() {
		super();
	}
	
	public PanelMember(int panelid, String location, String type) {
		super();
		this.panelid = panelid;
		this.location = location;
		this.type = type;
		
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


	@Override
	public String toString() {
		return "PanelMemberEntity [panelID=" + panelid + ", location=" + location + ", type=" + type
				+  "]";
	}

}
