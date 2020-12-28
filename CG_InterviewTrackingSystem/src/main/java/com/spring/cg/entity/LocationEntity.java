package com.spring.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="locations")
public class LocationEntity {
	
	@Id
	@Column(name="location")
	private String location;

	public LocationEntity() {
		super();
	}

	public LocationEntity(String location) {
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
		return "LocationEntity [location=" + location + "]";
	}
	
	
}
