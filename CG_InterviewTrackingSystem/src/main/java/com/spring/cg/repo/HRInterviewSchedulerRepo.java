package com.spring.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.cg.entity.CandidateEntity;
import com.spring.cg.entity.HRInterviewSchedulerEntity;


public interface HRInterviewSchedulerRepo extends JpaRepository<HRInterviewSchedulerEntity, Integer>{

	
	public HRInterviewSchedulerEntity findByInterviewid(int interviewid);

	public HRInterviewSchedulerEntity findByCandidate(CandidateEntity candidateEntity);
}
