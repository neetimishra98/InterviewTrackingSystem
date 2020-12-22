package com.spring.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.cg.entity.CandidateEntity;

public interface CandidateRepo extends JpaRepository<CandidateEntity, Integer>  {

}
