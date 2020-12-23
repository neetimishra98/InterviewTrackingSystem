package com.spring.cg.service;

<<<<<<< HEAD
import java.util.List;
=======
import com.spring.cg.entity.InterviewSchedulerEntity;

public interface InterviewSchedulerService {
	
	public InterviewSchedulerEntity giveTechRating(int interviewid);
	public InterviewSchedulerEntity giveHrRating(int interviewid);

>>>>>>> b3564d1256413555ef8d266011090f392a013031

import com.spring.cg.exception.CandidateNotFoundException;
import com.spring.cg.exception.InterviewSchedulerNotFoundException;
import com.spring.cg.json.InterviewScheduler;

public interface InterviewSchedulerService {
	
	//public List<InterviewScheduler> getAllInterviewSchedule();
	
	public InterviewScheduler updateInterviewSchedule(int interviewid, InterviewScheduler interviewscheduler)throws InterviewSchedulerNotFoundException;
	
	public boolean deleteById(int interviewid)throws InterviewSchedulerNotFoundException;
	
	public InterviewScheduler createNewInterviewSchedule(int candidateid, InterviewScheduler interviewscheduler)throws CandidateNotFoundException;
}