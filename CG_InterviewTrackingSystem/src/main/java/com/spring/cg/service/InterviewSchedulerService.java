package com.spring.cg.service;


import java.util.List;

import com.spring.cg.entity.CandidateEntity;
import com.spring.cg.entity.InterviewSchedulerEntity;
import com.spring.cg.exception.CandidateNotFoundException;
import com.spring.cg.exception.InterviewSchedulerNotFoundException;
import com.spring.cg.exception.PanelMemberNotFoundException;
import com.spring.cg.json.InterviewScheduler;

public interface InterviewSchedulerService {
	
	//public List<InterviewScheduler> getAllInterviewSchedule();
	

	public InterviewScheduler updateInterviewSchedule(int interviewid, InterviewScheduler interviewscheduler)throws InterviewSchedulerNotFoundException;
	
	public InterviewScheduler deleteById(int interviewid)throws InterviewSchedulerNotFoundException;
	
	//schedule by rutuja
	//public InterviewScheduler createNewInterviewSchedule(int candidateid, int panelid, InterviewScheduler interviewscheduler)
		//	throws CandidateNotFoundException;
	
	//public InterviewScheduler createNewTechInterviewSchedule(int candidateid, int panelid, InterviewScheduler interviewscheduler)
			//throws CandidateNotFoundException;

	
	
		//to view candidate information using interview id for hr
	//public CandidateEntity viewInterviewMembersForHr(int interviewid) throws InterviewSchedulerNotFoundException;

	
	public InterviewScheduler createNewTechInterviewSchedule(int candidateid, int panelid,
		      InterviewScheduler interviewscheduler)throws PanelMemberNotFoundException, CandidateNotFoundException;
	
	//to view all interview members for tech
		public List<InterviewScheduler> viewAllInterviewMembersForTech() throws InterviewSchedulerNotFoundException;
		
		//to view candidate information using interview id for tech
		public CandidateEntity viewInterviewMembersForTech(int interviewid) throws InterviewSchedulerNotFoundException;
		
		//to give tech rating to a candidate
		public InterviewSchedulerEntity giveTechRating(int interviewid) throws InterviewSchedulerNotFoundException;

}