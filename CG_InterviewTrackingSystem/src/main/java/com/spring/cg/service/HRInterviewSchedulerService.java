package com.spring.cg.service;

import com.spring.cg.exception.PanelMemberNotFoundException;
import com.spring.cg.json.HRInterviewScheduler;

public interface HRInterviewSchedulerService {



	public HRInterviewScheduler createNewHRInterviewSchedule(int candidateid, int panelid,
			HRInterviewScheduler hrinterviewscheduler) throws PanelMemberNotFoundException;



}
