package com.spring.cg.service;


import com.spring.cg.entity.InterviewSchedulerEntity;
import com.spring.cg.exception.CandidateNotFoundException;
import com.spring.cg.exception.InterviewSchedulerNotFoundException;
import com.spring.cg.json.InterviewScheduler;

public interface InterviewSchedulerService {
	
	//public List<InterviewScheduler> getAllInterviewSchedule();
	
	public InterviewSchedulerEntity giveTechRating(int interviewid);

	public InterviewScheduler updateInterviewSchedule(int interviewid, InterviewScheduler interviewscheduler)throws InterviewSchedulerNotFoundException;
	
	public boolean deleteById(int interviewid)throws InterviewSchedulerNotFoundException;
	
	//public List<Candidate> viewInterviewMembers();
	
	public InterviewScheduler createNewTechInterviewSchedule(int candidateid, int panelid, InterviewScheduler interviewscheduler)
			throws CandidateNotFoundException;

}