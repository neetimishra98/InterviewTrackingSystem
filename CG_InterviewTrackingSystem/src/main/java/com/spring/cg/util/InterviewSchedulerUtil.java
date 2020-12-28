package com.spring.cg.util;

import java.util.ArrayList;

import java.util.List;
import com.spring.cg.entity.CandidateEntity;
import com.spring.cg.entity.InterviewSchedulerEntity;
import com.spring.cg.entity.PanelMemberEntity;
import com.spring.cg.json.Candidate;
import com.spring.cg.json.InterviewScheduler;
import com.spring.cg.json.PanelMember;

public class InterviewSchedulerUtil {

	public static InterviewScheduler convertInterviewSchedulerEntityIntoInterviewScheduler(InterviewSchedulerEntity interviewschedulerEntity) {
		CandidateEntity candidateEntity = interviewschedulerEntity.getCandidate();
		
		Candidate candidate = new Candidate(candidateEntity.getCandidateid(),
		candidateEntity.getCandidatename(), candidateEntity.getLocation(),
		candidateEntity.getQualification(), candidateEntity.getDesignation(),
		candidateEntity.getExperience(), candidateEntity.getPrimaryskills(),
		candidateEntity.getSecondaryskills(), candidateEntity.getNoticeperiod());
	    
		PanelMemberEntity panelMemberEntity=interviewschedulerEntity.getPanel();
		
		PanelMember panelMember=new PanelMember(panelMemberEntity.getPanelid(),
				panelMemberEntity.getLocation(),panelMemberEntity.getType(), null);
		
		return new InterviewScheduler(interviewschedulerEntity.getInterviewid(),candidate,panelMember,interviewschedulerEntity.getLocation(),
				interviewschedulerEntity.getDate(),interviewschedulerEntity.getStart_time(),interviewschedulerEntity.getEnd_time(),
		interviewschedulerEntity.getTechrating(),
		interviewschedulerEntity.getFinalstatus());
	}

	
	
	public static InterviewSchedulerEntity convertInterviewSchedulerIntoInterviewSchedulerEntity(InterviewScheduler interviewscheduler) {
		Candidate candidate = interviewscheduler.getCandidate();
		CandidateEntity candidateEntity = new CandidateEntity(candidate.getCandidatename(), candidate.getLocation(),
				candidate.getQualification(), candidate.getDesignation(),
				candidate.getExperience(), candidate.getPrimaryskills(),
				candidate.getSecondaryskills(), candidate.getNoticeperiod());
		
		return new InterviewSchedulerEntity(interviewscheduler.getTechrating(), interviewscheduler.getLocation(), 
				interviewscheduler.getFinalstatus(), candidateEntity);
	}


	public static List<InterviewScheduler> convertInterviewSchedulerEntityListIntoInterviewSchedulerList(List<InterviewSchedulerEntity> interviewschedulerEntityList) {
		List<InterviewScheduler> interviewschedulers = new ArrayList<InterviewScheduler>();
		for(InterviewSchedulerEntity interviewschedulerEntity: interviewschedulerEntityList) {
			interviewschedulers.add(convertInterviewSchedulerEntityIntoInterviewScheduler(interviewschedulerEntity));
		}
		return interviewschedulers;
	}
	
	//schedule interview
	public static InterviewScheduler convertInterviewSchedulerEntityIntoInterviewSchedulerForScheduleInterview(InterviewSchedulerEntity interviewschedulerEntity) {
	
		CandidateEntity candidateEntity = interviewschedulerEntity.getCandidate();
		Candidate candidate = new Candidate(candidateEntity.getCandidateid(),
		candidateEntity.getCandidatename(), candidateEntity.getLocation(),
		candidateEntity.getQualification(), candidateEntity.getDesignation(),
		candidateEntity.getExperience(), candidateEntity.getPrimaryskills(),
		candidateEntity.getSecondaryskills(), candidateEntity.getNoticeperiod());
		
        PanelMemberEntity panelMemberEntity=interviewschedulerEntity.getPanel();
		
		PanelMember panelMember=new PanelMember(panelMemberEntity.getPanelid(),
				panelMemberEntity.getLocation(),panelMemberEntity.getType(), null);
		
		
		return new InterviewScheduler(interviewschedulerEntity.getInterviewid(),candidate,panelMember,interviewschedulerEntity.getLocation(),
				interviewschedulerEntity.getDate(),interviewschedulerEntity.getStart_time(),interviewschedulerEntity.getEnd_time(),
		interviewschedulerEntity.getTechrating(), 
		interviewschedulerEntity.getFinalstatus());
	}
	
	//schedule interview
	public static InterviewSchedulerEntity convertInterviewSchedulerIntoInterviewSchedulerEntityForScheduleInterview(InterviewScheduler interviewscheduler, CandidateEntity candidateEntity ,PanelMemberEntity panelMemberEntity ) {
		/*
		return new InterviewSchedulerEntity(interviewscheduler.getTechrating(), interviewscheduler.getHrrating(), 0, interviewscheduler.getLocation(), 
				interviewscheduler.getFinalstatus(),interviewscheduler.getDate(),interviewscheduler.getStart_time(),interviewscheduler.getEnd_time(),candidateEntity,panelMemberEntity);
		*/
		
	 return new InterviewSchedulerEntity(interviewscheduler.getInterviewid(),candidateEntity,
				panelMemberEntity,interviewscheduler.getLocation(),interviewscheduler.getDate(),
				interviewscheduler.getStart_time(),interviewscheduler.getEnd_time(),interviewscheduler.getTechrating(),
				interviewscheduler.getFinalstatus());
	}
}
