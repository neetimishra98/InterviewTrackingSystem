package com.spring.cg.service;

import java.util.List;

import com.spring.cg.entity.CandidateEntity;
import com.spring.cg.entity.HRInterviewSchedulerEntity;
import com.spring.cg.exception.InterviewNotFoundException;
import com.spring.cg.exception.InterviewSchedulerNotFoundException;
import com.spring.cg.exception.PanelMemberNotFoundException;
import com.spring.cg.json.HRInterviewScheduler;

public interface HRInterviewSchedulerService {

	public HRInterviewScheduler updateInterviewSchedule(int interviewid, 
			HRInterviewScheduler hrinterviewscheduler) throws InterviewSchedulerNotFoundException;
	
	
	public List<HRInterviewScheduler> getAllInterviewMembershr();
	public HRInterviewSchedulerEntity giveHrRating(int interviewid)  throws InterviewSchedulerNotFoundException;
	public CandidateEntity viewInterviewMembersbyHr(int interviewid)   throws InterviewSchedulerNotFoundException;


	public HRInterviewScheduler deleteById(int interviewid) throws InterviewSchedulerNotFoundException;


	public HRInterviewScheduler createNewHRInterviewSchedule(int candidateid, int panelid,
		      HRInterviewScheduler hrinterviewscheduler) throws PanelMemberNotFoundException;

}
