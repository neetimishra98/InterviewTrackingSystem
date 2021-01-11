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

	//SHARE CANDIDATE AND SCHEDULE INTERVIEW WITH HR
	  @Override
	  public HRInterviewScheduler createNewHRInterviewSchedule(int candidateid, int panelid,
	      HRInterviewScheduler hrinterviewscheduler) throws PanelMemberNotFoundException {
	    Optional<CandidateEntity> candidateEntityOp = candidateRepo.findById(candidateid);

	    Optional<PanelMemberEntity> panelMemberEntityOp = Optional.of(panelMemberRepo.findById(panelid));
	    List<InterviewSchedulerEntity> interviewschedulerOp = interviewSchedulerRepo.findAll();

	    CandidateEntity candidateEntity = candidateEntityOp.get();
		return hrinterviewscheduler;
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
				memberEntit.getLocation(),memberEntit.getFinalstatus(),memberEntit.getDate(),memberEntit.getStart_time(),memberEntit.getEnd_time(),memberEntit.getCandidateid(),memberEntit.getPanelid()));
		       }
		    return memberList;
		    }
	
			
			//For giving Hrrating
				@Override
				public HRInterviewSchedulerEntity giveHrRating(int interviewid) throws InterviewSchedulerNotFoundException {
	     Optional<HRInterviewSchedulerEntity> opinterviewEntity = hrinterviewSchedulerRepo.findById(interviewid);
	            if( opinterviewEntity.isPresent()) {
					double Hrrating=0;
							int min=0;
							int max=10;
								 Hrrating=Math.random()*(max-min+1)+min;	
			HRInterviewSchedulerEntity hrinterviewSchedulerEntity = hrinterviewSchedulerRepo.findByInterviewid(interviewid);
								 if(hrinterviewSchedulerEntity.getHrrating()==0) {
							hrinterviewSchedulerEntity.setHrrating((int)Hrrating);
							hrinterviewSchedulerEntity.setFinalstatus("hrcomplete");
							}
						return hrinterviewSchedulerRepo.save(hrinterviewSchedulerEntity); 
					}
	            else {
	            	throw new InterviewSchedulerNotFoundException("interviewid : " + interviewid);
	            }
				}
			
				
				//to view candidate information using INTERVIEW ID for HR
				@Override
		public CandidateEntity viewInterviewMembersbyHr(int interviewid) throws InterviewSchedulerNotFoundException {
		Optional<HRInterviewSchedulerEntity> oppInterviewEntity=hrinterviewSchedulerRepo.findById(interviewid);
			if(oppInterviewEntity.isPresent()) {
				HRInterviewSchedulerEntity hrinterviewSchedulerEntity = hrinterviewSchedulerRepo.findByInterviewid(interviewid);
					CandidateEntity candidateEntity=hrinterviewSchedulerEntity.getCandidate();
					return candidateEntity;
					
					}else {
						throw new InterviewSchedulerNotFoundException("interviewid :" +interviewid);
					}
					
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
	
