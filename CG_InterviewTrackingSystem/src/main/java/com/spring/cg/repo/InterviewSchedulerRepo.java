package com.spring.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.cg.entity.InterviewSchedulerEntity;

public interface InterviewSchedulerRepo extends JpaRepository<InterviewSchedulerEntity, Integer>{
	
	public InterviewSchedulerEntity findByInterviewid(int interviewid);

}