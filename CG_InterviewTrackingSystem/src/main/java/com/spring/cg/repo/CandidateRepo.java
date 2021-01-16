package com.spring.cg.repo;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.cg.entity.CandidateEntity;
import com.spring.cg.exception.CandidateNotFoundException;

public interface CandidateRepo extends JpaRepository<CandidateEntity, Integer>  {

	public CandidateEntity findByCandidateid(int candidateid) throws CandidateNotFoundException;

	public CandidateEntity findByCandidatename(String candidateId) throws CandidateNotFoundException;

	
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
	
	
	
	@Query("SELECT DISTINCT ce.candidatename FROM CandidateEntity ce")
	public List<String> findDistinctName();
	
	@Query("SELECT DISTINCT ce.location FROM CandidateEntity ce")
	public List<String> findDistinctLocation();
	
	@Query("SELECT DISTINCT ce.qualification FROM CandidateEntity ce")
	public List<String> findDistinctQualification();
	
	@Query("SELECT DISTINCT ce.designation FROM CandidateEntity ce")
	public List<String> findDistinctDesignation();
	
	@Query("SELECT DISTINCT ce.primaryskills FROM CandidateEntity ce")
	public List<String> findDistinctPrimarySkill();
	
}

