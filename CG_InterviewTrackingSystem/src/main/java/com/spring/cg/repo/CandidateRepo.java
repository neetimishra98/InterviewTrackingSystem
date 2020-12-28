package com.spring.cg.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.cg.entity.CandidateEntity;
import com.spring.cg.exception.CandidateNotFoundException;

public interface CandidateRepo extends JpaRepository<CandidateEntity, Integer>  {

	
	

}

