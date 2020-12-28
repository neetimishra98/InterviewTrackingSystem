package com.spring.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.cg.entity.LocationEntity;

public interface LocationRepo extends JpaRepository<LocationEntity, String>{
	
}
