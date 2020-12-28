package com.spring.cg.json;

import io.swagger.annotations.ApiModelProperty;

public class Location {
	
	@ApiModelProperty(value="Loction")
	private String location;

	public Location() {
		super();
	}

	public Location(String location) {
		super();
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Location [location=" + location + "]";
	}

}
