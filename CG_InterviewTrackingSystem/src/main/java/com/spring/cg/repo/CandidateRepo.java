package com.spring.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.cg.entity.CandidateEntity;
import com.spring.cg.exception.CandidateNotFoundException;

public interface CandidateRepo extends JpaRepository<CandidateEntity, Integer>  {
	
    @Query("SELECT ce FROM CandidateEntity ce WHERE UPPER(ce.candidatename) = UPPER(?1)")
	 public List<CandidateEntity> findByNameIgnoreCase(String candidatename);
	
	@Query("SELECT ce FROM CandidateEntity ce WHERE UPPER(ce.location) = UPPER(?1)")
	 public List<CandidateEntity> findByLocationIgnoreCase(String location);
	
	@Query("SELECT ce FROM CandidateEntity ce WHERE UPPER(ce.qualification) = UPPER(?1)")
	 public List<CandidateEntity> findByQualificationIgnoreCase(String qualification);
	
	@Query("SELECT ce FROM CandidateEntity ce WHERE UPPER(ce.designation) = UPPER(?1)")
	 public List<CandidateEntity> findByDesignationIgnoreCase(String designation);
	
	@Query("SELECT ce FROM CandidateEntity ce WHERE UPPER(ce.primaryskills) = UPPER(?1)")
	 public List<CandidateEntity> findByPrimarySkillsIgnoreCase(String primaryskills);

}

