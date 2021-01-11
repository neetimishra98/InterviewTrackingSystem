package com.spring.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cg.entity.CandidateEntity;
import com.spring.cg.entity.HRInterviewSchedulerEntity;
import com.spring.cg.entity.InterviewSchedulerEntity;
import com.spring.cg.entity.PanelMemberEntity;
import com.spring.cg.exception.InterviewSchedulerNotFoundException;
import com.spring.cg.exception.PanelMemberNotFoundException;
import com.spring.cg.json.HRInterviewScheduler;
import com.spring.cg.repo.CandidateRepo;
import com.spring.cg.repo.HRInterviewSchedulerRepo;
import com.spring.cg.repo.InterviewSchedulerRepo;
import com.spring.cg.repo.PanelMemberRepo;
import com.spring.cg.util.HRInterviewSchedulerUtil;

@Service
public class HRInterviewSchedulerServiceImpl implements HRInterviewSchedulerService {
	@Autowired
	InterviewSchedulerRepo interviewSchedulerRepo;

	@Autowired
	HRInterviewSchedulerRepo hrinterviewSchedulerRepo;

	@Autowired
	private CandidateRepo candidateRepo;

	@Autowired
	private PanelMemberRepo panelMemberRepo;

	@Override
	public HRInterviewScheduler createNewHRInterviewSchedule(int candidateid, int panelid,
			HRInterviewScheduler hrinterviewscheduler) throws PanelMemberNotFoundException {
		Optional<CandidateEntity> candidateEntityOp = candidateRepo.findById(candidateid);

		Optional<PanelMemberEntity> panelMemberEntityOp = Optional.of(panelMemberRepo.findById(panelid));
		List<InterviewSchedulerEntity> interviewschedulerOp = interviewSchedulerRepo.findAll();

		CandidateEntity candidateEntity = candidateEntityOp.get();

		PanelMemberEntity panelMemberEntity = panelMemberEntityOp.get();

		for (InterviewSchedulerEntity ise : interviewschedulerOp) {
			// CandidateEntity id = ise.getCandidateid();
		//1	System.out.println(candidateid ==ise.getCandidate().getCandidateid());
			
			if (candidateid ==ise.getCandidate().getCandidateid()) {
			
				InterviewSchedulerEntity ie = ise;
      //2          System.out.println(ie);
				if (panelMemberEntityOp.isPresent() && ie.getTechrating() > 0)
					{
						HRInterviewSchedulerEntity ise1 = HRInterviewSchedulerUtil
								.convertHRInterviewSchedulerIntoHRInterviewSchedulerEntityForScheduleInterview(
										hrinterviewscheduler, candidateEntity, panelMemberEntity);
						System.out.println(ise);
						HRInterviewSchedulerEntity hrinterviewschedulerEntity = hrinterviewSchedulerRepo.save(ise1);
						return HRInterviewSchedulerUtil
								.convertHRInterviewSchedulerEntityIntoHRInterviewSchedulerForScheduleInterview(
										hrinterviewschedulerEntity);
					}
				else {
					throw new PanelMemberNotFoundException("No such panel member with panelid " + panelid);
				}
		    } 
		}
		return null;
	}
	
	//to update the schedule hr interview
			@Override
			public HRInterviewScheduler updateInterviewSchedule(int interviewid, HRInterviewScheduler hrinterviewscheduler)throws InterviewSchedulerNotFoundException {
			
				Optional<HRInterviewSchedulerEntity> interviewschedulerEntityOp = hrinterviewSchedulerRepo.findById(interviewid);
				
				if(interviewschedulerEntityOp.isPresent())
				{
					HRInterviewSchedulerEntity hrinterviewschedulerEntity = interviewschedulerEntityOp.get();
					hrinterviewschedulerEntity.setDate(hrinterviewscheduler.getDate());
					hrinterviewschedulerEntity.setStart_time(hrinterviewscheduler.getStart_time());
					hrinterviewschedulerEntity.setEnd_time(hrinterviewscheduler.getEnd_time());
					hrinterviewschedulerEntity.setHrrating(hrinterviewscheduler.getHrrating());
					hrinterviewschedulerEntity.setFinalstatus(hrinterviewscheduler.getFinalstatus());
					
					hrinterviewschedulerEntity = hrinterviewSchedulerRepo.save(hrinterviewschedulerEntity);
					return HRInterviewSchedulerUtil.convertHRInterviewSchedulerEntityIntoHRInterviewSchedulerForScheduleInterview(hrinterviewschedulerEntity);
				}
				else
					throw new InterviewSchedulerNotFoundException("No such candidate with InterviewID "+interviewid);
			}
			
			// return the whole list of interviewMembers
			public List<HRInterviewScheduler> getAllInterviewMembershr(){
		        List<HRInterviewSchedulerEntity> hrinterviewSchedulerEntity =  hrinterviewSchedulerRepo.findAll();
		        List<HRInterviewScheduler> memberList = new ArrayList<HRInterviewScheduler>();
		        
		        for(HRInterviewSchedulerEntity memberEntit :hrinterviewSchedulerEntity) {
		memberList.add(new HRInterviewScheduler(memberEntit.getInterviewid(),
				memberEntit.getHrrating(),
				memberEntit.getLocation(),memberEntit.getFinalstatus()));
		       }
		    return memberList;
		    }
		
			//For giving Hrrating
				@Override
				public HRInterviewSchedulerEntity giveHrRating(int interviewid) {
					HRInterviewSchedulerEntity hrinterviewSchedulerEntity = hrinterviewSchedulerRepo.findByInterviewid(interviewid);
						if(hrinterviewSchedulerEntity.getHrrating()==0) {
							double Hrrating=0;
							int min=0;
							int max=10;
								 Hrrating=Math.random()*(max-min+1)+min;	
							hrinterviewSchedulerEntity.setHrrating((int)Hrrating);
							}
						return hrinterviewSchedulerRepo.save(hrinterviewSchedulerEntity); 
					}
				
//To View Interview Members For Hr
		@Override
		public CandidateEntity viewInterviewMembersbyHr(int interviewid) {
		HRInterviewSchedulerEntity hrinterviewSchedulerEntity = hrinterviewSchedulerRepo.findByInterviewid(interviewid);
		CandidateEntity candidateEntity = hrinterviewSchedulerEntity.getCandidate();
		return candidateEntity;			
	
}	
			
			//to cancel the schedule interview
				@Override
				public HRInterviewScheduler deleteById(int interviewid)throws InterviewSchedulerNotFoundException {
					
					Optional<InterviewSchedulerEntity> opinterviewschedulerEntity = interviewSchedulerRepo.findById(interviewid);
					HRInterviewScheduler interviewscheduler = null;
					if(opinterviewschedulerEntity.isPresent())
					{	
						interviewSchedulerRepo.deleteById(interviewid);
						return interviewscheduler;
					}
					else
					{
						throw new InterviewSchedulerNotFoundException("No such candidate with InterviewID "+interviewid);
					}
				}
				
				
}
	
