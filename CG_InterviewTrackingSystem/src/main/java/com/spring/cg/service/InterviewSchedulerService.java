package com.spring.cg.service;


<<<<<<< HEAD
import java.util.List;

import com.spring.cg.entity.CandidateEntity;
=======
>>>>>>> c0f0827a37492d906b365b70fd314f54de2e93a1
import com.spring.cg.entity.InterviewSchedulerEntity;
import com.spring.cg.exception.CandidateNotFoundException;
import com.spring.cg.exception.InterviewSchedulerNotFoundException;
import com.spring.cg.json.InterviewScheduler;

public interface InterviewSchedulerService {
	
	//public List<InterviewScheduler> getAllInterviewSchedule();
	
	public InterviewSchedulerEntity giveTechRating(int interviewid);

	public InterviewScheduler updateInterviewSchedule(int interviewid, InterviewScheduler interviewscheduler)throws InterviewSchedulerNotFoundException;
	
	public boolean deleteById(int interviewid)throws InterviewSchedulerNotFoundException;
	
<<<<<<< HEAD
	

	//schedule by rutuja
	public InterviewScheduler createNewInterviewSchedule(int candidateid, int panelid, InterviewScheduler interviewscheduler)
			throws CandidateNotFoundException;
	

	public CandidateEntity viewInterviewMembersForTech(int interviewid) throws InterviewSchedulerNotFoundException;
=======
	//public List<Candidate> viewInterviewMembers();
	
	public InterviewScheduler createNewTechInterviewSchedule(int candidateid, int panelid, InterviewScheduler interviewscheduler)
			throws CandidateNotFoundException;


>>>>>>> c0f0827a37492d906b365b70fd314f54de2e93a1
}