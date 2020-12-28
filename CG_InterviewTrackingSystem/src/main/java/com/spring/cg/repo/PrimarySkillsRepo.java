package com.spring.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.cg.entity.PrimarySkillsEntity;

public interface PrimarySkillsRepo extends JpaRepository<PrimarySkillsEntity, String> {
	
}
