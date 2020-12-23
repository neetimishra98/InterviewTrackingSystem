package com.spring.cg.util;

import java.util.ArrayList;
import java.util.List;
import com.spring.cg.entity.CandidateEntity;
import com.spring.cg.entity.InterviewSchedulerEntity;
import com.spring.cg.json.Candidate;
import com.spring.cg.json.InterviewScheduler;

public class InterviewSchedulerUtil {

	public static InterviewScheduler convertInterviewSchedulerEntityIntoInterviewScheduler(InterviewSchedulerEntity interviewschedulerEntity) {
		CandidateEntity candidateEntity = interviewschedulerEntity.getCandidate();
		Candidate candidate = new Candidate(candidateEntity.getCandidateid(),
		candidateEntity.getCandidatename(), candidateEntity.getLocation(),
		candidateEntity.getQualification(), candidateEntity.getDesignation(),
		candidateEntity.getExperience(), candidateEntity.getPrimaryskills(),
		candidateEntity.getSecondaryskills(), candidateEntity.getNoticeperiod());
		return new InterviewScheduler(interviewschedulerEntity.getInterviewid(),
		interviewschedulerEntity.getTechrating(), interviewschedulerEntity.getHrrating(), interviewschedulerEntity.getLocation(), 
		interviewschedulerEntity.getFinalstatus(), candidate);
	}

	public static InterviewSchedulerEntity convertInterviewSchedulerIntoInterviewSchedulerEntity(InterviewScheduler interviewscheduler) {
		Candidate candidate = interviewscheduler.getCandidate();
		CandidateEntity candidateEntity = new CandidateEntity(candidate.getCandidatename(), candidate.getLocation(),
				candidate.getQualification(), candidate.getDesignation(),
				candidate.getExperience(), candidate.getPrimaryskills(),
				candidate.getSecondaryskills(), candidate.getNoticeperiod());
		return new InterviewSchedulerEntity(interviewscheduler.getTechrating(), interviewscheduler.getHrrating(), interviewscheduler.getLocation(), 
				interviewscheduler.getFinalstatus(), candidateEntity);
	}

	public static List<InterviewScheduler> convertInterviewSchedulerEntityListIntoInterviewSchedulerList(List<InterviewSchedulerEntity> interviewschedulerEntityList) {
		List<InterviewScheduler> interviewschedulers = new ArrayList<InterviewScheduler>();
		for(InterviewSchedulerEntity interviewschedulerEntity: interviewschedulerEntityList) {
			interviewschedulers.add(convertInterviewSchedulerEntityIntoInterviewScheduler(interviewschedulerEntity));
		}
		return interviewschedulers;
	}
	
	
	public static InterviewScheduler convertInterviewSchedulerEntityIntoInterviewSchedulerForScheduleInterview(InterviewSchedulerEntity interviewschedulerEntity) {
	
		CandidateEntity candidateEntity = interviewschedulerEntity.getCandidate();
		Candidate candidate = new Candidate(candidateEntity.getCandidateid(),
		candidateEntity.getCandidatename(), candidateEntity.getLocation(),
		candidateEntity.getQualification(), candidateEntity.getDesignation(),
		candidateEntity.getExperience(), candidateEntity.getPrimaryskills(),
		candidateEntity.getSecondaryskills(), candidateEntity.getNoticeperiod());
		
		
		return new InterviewScheduler(interviewschedulerEntity.getInterviewid(),
		interviewschedulerEntity.getTechrating(), interviewschedulerEntity.getHrrating(), interviewschedulerEntity.getLocation(), 
		interviewschedulerEntity.getFinalstatus(), candidate);
	}
	
	
	public static InterviewSchedulerEntity convertInterviewSchedulerIntoInterviewSchedulerEntityForScheduleInterview(InterviewScheduler interviewscheduler, CandidateEntity candidateEntity) {
		
		return new InterviewSchedulerEntity(interviewscheduler.getTechrating(), interviewscheduler.getHrrating(), interviewscheduler.getLocation(), 
				interviewscheduler.getFinalstatus(), candidateEntity);
	}
}
