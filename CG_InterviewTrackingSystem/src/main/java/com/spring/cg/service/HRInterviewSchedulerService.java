package com.spring.cg.service;

import java.util.List;

import com.spring.cg.entity.HRInterviewSchedulerEntity;
import com.spring.cg.exception.InterviewSchedulerNotFoundException;
import com.spring.cg.exception.PanelMemberNotFoundException;
import com.spring.cg.json.Candidate;
import com.spring.cg.json.HRInterviewScheduler;

public interface HRInterviewSchedulerService {



	public HRInterviewScheduler createNewHRInterviewSchedule(int candidateid, int panelid,
			HRInterviewScheduler hrinterviewscheduler) throws PanelMemberNotFoundException;

	public HRInterviewScheduler updateInterviewSchedule(int interviewid, HRInterviewScheduler hrinterviewscheduler) throws InterviewSchedulerNotFoundException;

	public HRInterviewScheduler deleteById(int interviewid) throws InterviewSchedulerNotFoundException;

	public HRInterviewSchedulerEntity giveHRRating(int interviewid);

	//public List<HRInterviewScheduler> getAllHRInterviewSchedule();

	//public List<Candidate> viewHrInterviewMembers();

}
