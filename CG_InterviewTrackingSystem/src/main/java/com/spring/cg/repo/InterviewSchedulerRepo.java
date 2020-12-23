package com.spring.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
=======

import com.spring.cg.entity.InterviewSchedulerEntity;

public interface InterviewSchedulerRepo extends JpaRepository<InterviewSchedulerEntity, Integer>{
	
	public InterviewSchedulerEntity findByInterviewid(int interviewid);

>>>>>>> b3564d1256413555ef8d266011090f392a013031

import com.spring.cg.entity.InterviewSchedulerEntity;

public interface InterviewSchedulerRepo extends JpaRepository<InterviewSchedulerEntity, Integer>{

	
}