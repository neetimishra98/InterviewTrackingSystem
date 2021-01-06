package com.spring.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.cg.entity.CandidateEntity;
import com.spring.cg.entity.HRInterviewSchedulerEntity;
import com.spring.cg.exception.InterviewSchedulerNotFoundException;


public interface HRInterviewSchedulerRepo extends JpaRepository<HRInterviewSchedulerEntity, Integer>{

	
	public HRInterviewSchedulerEntity findByInterviewid(int interviewid) throws InterviewSchedulerNotFoundException;

	public HRInterviewSchedulerEntity findByCandidate(CandidateEntity candidateEntity);

}
