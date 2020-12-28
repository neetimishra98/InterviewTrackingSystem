package com.spring.cg.service;


import java.util.List;

import com.spring.cg.entity.CandidateEntity;
import com.spring.cg.entity.InterviewSchedulerEntity;
import com.spring.cg.exception.CandidateNotFoundException;
import com.spring.cg.exception.InterviewSchedulerNotFoundException;
import com.spring.cg.json.InterviewScheduler;

public interface InterviewSchedulerService {
	
	//public List<InterviewScheduler> getAllInterviewSchedule();
	

	public InterviewScheduler updateInterviewSchedule(int interviewid, InterviewScheduler interviewscheduler)throws InterviewSchedulerNotFoundException;
	
	public InterviewScheduler deleteById(int interviewid)throws InterviewSchedulerNotFoundException;
	

	

	//schedule by rutuja
	//public InterviewScheduler createNewInterviewSchedule(int candidateid, int panelid, InterviewScheduler interviewscheduler)
		//	throws CandidateNotFoundException;
	
	
	public InterviewScheduler createNewTechInterviewSchedule(int candidateid, int panelid, InterviewScheduler interviewscheduler)
			throws CandidateNotFoundException;

<<<<<<< HEAD
	//to view all interview members for tech
	public List<InterviewScheduler> viewAllInterviewMembersForTech() throws InterviewSchedulerNotFoundException;
	
	//to view candidate information using interview id for tech
	public CandidateEntity viewInterviewMembersForTech(int interviewid) throws InterviewSchedulerNotFoundException;
	
	//to give tech rating to a candidate
	public InterviewSchedulerEntity giveTechRating(int interviewid);

	
=======
>>>>>>> d5d7b1de1205ae1691090d85b24f43195edd280e
}