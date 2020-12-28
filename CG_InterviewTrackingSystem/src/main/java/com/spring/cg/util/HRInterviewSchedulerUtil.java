package com.spring.cg.util;

import com.spring.cg.entity.CandidateEntity;
import com.spring.cg.entity.EmployeeEntity;
import com.spring.cg.entity.HRInterviewSchedulerEntity;
import com.spring.cg.entity.PanelMemberEntity;
import com.spring.cg.json.Candidate;
import com.spring.cg.json.Employee;
import com.spring.cg.json.HRInterviewScheduler;
import com.spring.cg.json.PanelMember;

public class HRInterviewSchedulerUtil {
	//FOR SHARE AND SCHEDULING INTERVIEW
		public static HRInterviewScheduler convertHRInterviewSchedulerEntityIntoHRInterviewSchedulerForScheduleInterview(
				HRInterviewSchedulerEntity hrinterviewschedulerEntity) {

			CandidateEntity candidateEntity = hrinterviewschedulerEntity.getCandidate();
			Candidate candidate = new Candidate(candidateEntity.getCandidateid(), candidateEntity.getCandidatename(),
					candidateEntity.getLocation(), candidateEntity.getQualification(), candidateEntity.getDesignation(),
					candidateEntity.getExperience(), candidateEntity.getPrimaryskills(),
					candidateEntity.getSecondaryskills(), candidateEntity.getNoticeperiod());

			PanelMemberEntity panelMemberEntity = hrinterviewschedulerEntity.getPanel();

			EmployeeEntity employeeEntity = panelMemberEntity.getEmployeeEntity();
			Employee employee = new Employee(employeeEntity.getEmployeeid(), employeeEntity.getName());

			PanelMember panelMember = new PanelMember(panelMemberEntity.getPanelid(), panelMemberEntity.getLocation(),
					panelMemberEntity.getType(), employee);

			return new HRInterviewScheduler(hrinterviewschedulerEntity.getInterviewid(), candidate, panelMember,
					hrinterviewschedulerEntity.getLocation(), hrinterviewschedulerEntity.getDate(),
					hrinterviewschedulerEntity.getStart_time(), hrinterviewschedulerEntity.getEnd_time(),
				hrinterviewschedulerEntity.getHrrating(),
					hrinterviewschedulerEntity.getFinalstatus());
		}
		//FOR SHARE AND SCHEDULING INTERVIEW
		public static HRInterviewSchedulerEntity convertHRInterviewSchedulerIntoHRInterviewSchedulerEntityForScheduleInterview(
				HRInterviewScheduler hrinterviewscheduler, CandidateEntity candidateid, PanelMemberEntity panelid) {
			return new HRInterviewSchedulerEntity(hrinterviewscheduler.getInterviewid(), candidateid, panelid,
					hrinterviewscheduler.getLocation(), hrinterviewscheduler.getDate(), hrinterviewscheduler.getStart_time(),
					hrinterviewscheduler.getEnd_time(), hrinterviewscheduler.getHrrating(),
					hrinterviewscheduler.getFinalstatus());
		}
		
	}

