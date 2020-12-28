package com.spring.cg.util;

import java.util.ArrayList;

import java.util.List;
import com.spring.cg.entity.CandidateEntity;
import com.spring.cg.entity.EmployeeEntity;
import com.spring.cg.entity.HRInterviewSchedulerEntity;
import com.spring.cg.entity.InterviewSchedulerEntity;
import com.spring.cg.entity.PanelMemberEntity;
import com.spring.cg.json.Candidate;
import com.spring.cg.json.Employee;
import com.spring.cg.json.HRInterviewScheduler;
import com.spring.cg.json.InterviewScheduler;
import com.spring.cg.json.PanelMember;

public class InterviewSchedulerUtil {

	
	
	
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
	
	public static InterviewScheduler convertInterviewSchedulerEntityIntoInterviewScheduler(
			InterviewSchedulerEntity interviewschedulerEntity) {
		// TODO Auto-generated method stub
		return null;
	}


	public static InterviewScheduler convertTechInterviewSchedulerEntityIntoTechInterviewSchedulerForScheduleInterview(
			InterviewSchedulerEntity interviewschedulerEntity) {

		CandidateEntity candidateEntity = interviewschedulerEntity.getCandidate();
		Candidate candidate = new Candidate(candidateEntity.getCandidateid(), candidateEntity.getCandidatename(),
				candidateEntity.getLocation(), candidateEntity.getQualification(), candidateEntity.getDesignation(),
				candidateEntity.getExperience(), candidateEntity.getPrimaryskills(),
				candidateEntity.getSecondaryskills(), candidateEntity.getNoticeperiod());

		PanelMemberEntity panelMemberEntity = interviewschedulerEntity.getPanel();

		EmployeeEntity employeeEntity = panelMemberEntity.getEmployeeEntity();
		Employee employee = new Employee(employeeEntity.getEmployeeid(), employeeEntity.getName());

		PanelMember panelMember = new PanelMember(panelMemberEntity.getPanelid(), panelMemberEntity.getLocation(),
				panelMemberEntity.getType(), employee);

		return new InterviewScheduler(interviewschedulerEntity.getInterviewid(), candidate, panelMember,
				interviewschedulerEntity.getLocation(), interviewschedulerEntity.getDate(),
				interviewschedulerEntity.getStart_time(), interviewschedulerEntity.getEnd_time(),
			interviewschedulerEntity.getTechrating(),
				interviewschedulerEntity.getFinalstatus());
	}
	//FOR SHARE AND SCHEDULING INTERVIEW
	public static InterviewSchedulerEntity convertTechInterviewSchedulerIntoTechInterviewSchedulerEntityForScheduleInterview(
			InterviewScheduler interviewscheduler, CandidateEntity candidateid, PanelMemberEntity panelid) {
		return new InterviewSchedulerEntity(interviewscheduler.getInterviewid(), candidateid, panelid,
			interviewscheduler.getLocation(), interviewscheduler.getDate(), interviewscheduler.getStart_time(),
				interviewscheduler.getEnd_time(), interviewscheduler.getTechrating(),
			interviewscheduler.getFinalstatus());
	}
}
	
