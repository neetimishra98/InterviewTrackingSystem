package com.spring.cg.service;

import com.spring.cg.exception.*;
import com.spring.cg.json.HRInterviewScheduler;

public interface HRInterviewSchedulerService {



	public HRInterviewScheduler createNewHRInterviewSchedule(int candidateid, int panelid,
			HRInterviewScheduler hrinterviewscheduler) throws PanelMemberNotFoundException;
	

	public HRInterviewScheduler updateInterviewSchedule(int interviewid, 
			HRInterviewScheduler hrinterviewscheduler) throws InterviewSchedulerNotFoundException;
	
	public HRInterviewScheduler deleteById(int interviewid)throws InterviewSchedulerNotFoundException;



}
