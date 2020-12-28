package com.spring.cg.service;


import java.util.List;

import com.spring.cg.entity.CandidateEntity;
import com.spring.cg.entity.InterviewSchedulerEntity;
import com.spring.cg.exception.CandidateNotFoundException;
import com.spring.cg.exception.InterviewSchedulerNotFoundException;
import com.spring.cg.json.Candidate;
import com.spring.cg.json.InterviewScheduler;

public interface InterviewSchedulerService {
	
	//public List<InterviewScheduler> getAllInterviewSchedule();
	
	public List<InterviewScheduler> viewAllInterviewMembersForTech() throws InterviewSchedulerNotFoundException;
	
	public InterviewSchedulerEntity giveTechRating(int interviewid);
	
	public InterviewScheduler updateInterviewSchedule(int interviewid, InterviewScheduler interviewscheduler)throws InterviewSchedulerNotFoundException;
	
	public InterviewScheduler deleteById(int interviewid)throws InterviewSchedulerNotFoundException;
	
	//public InterviewScheduler createNewInterviewSchedule(int candidateid, InterviewScheduler interviewscheduler)throws CandidateNotFoundException;
	
	

	//schedule by rutuja
	public InterviewScheduler createNewInterviewSchedule(int candidateid, int panelid, InterviewScheduler interviewscheduler)
			throws CandidateNotFoundException;
	

	public CandidateEntity viewInterviewMembersForTech(int interviewid) throws InterviewSchedulerNotFoundException;
}