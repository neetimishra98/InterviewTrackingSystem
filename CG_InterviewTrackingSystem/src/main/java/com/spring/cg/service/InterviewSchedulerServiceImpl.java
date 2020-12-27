package com.spring.cg.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cg.entity.CandidateEntity;
import com.spring.cg.entity.InterviewSchedulerEntity;
import com.spring.cg.exception.CandidateNotFoundException;
import com.spring.cg.exception.InterviewSchedulerNotFoundException;
import com.spring.cg.json.InterviewScheduler;
import com.spring.cg.repo.CandidateRepo;
import com.spring.cg.repo.InterviewSchedulerRepo;
import com.spring.cg.util.InterviewSchedulerUtil;

@Service
public class InterviewSchedulerServiceImpl implements InterviewSchedulerService {
	
	@Autowired
	InterviewSchedulerRepo interviewSchedulerRepo;
	
	@Autowired
	private CandidateRepo candidateRepo;

 /*	
	@Override
	public List<InterviewScheduler> getAllInterviewSchedule() {
		
		return InterviewSchedulerUtil.convertInterviewSchedulerEntityListIntoInterviewSchedulerList(interviewschedulerRepo.findAll());
	}
*/	
	@Override
	public InterviewScheduler updateInterviewSchedule(int interviewid, InterviewScheduler interviewscheduler)throws InterviewSchedulerNotFoundException {
	
		Optional<InterviewSchedulerEntity> interviewschedulerEntityOp = interviewSchedulerRepo.findById(interviewid);
		
		if(interviewschedulerEntityOp.isPresent())
		{
			InterviewSchedulerEntity interviewschedulerEntity = interviewschedulerEntityOp.get();
			interviewschedulerEntity.setTechrating(interviewscheduler.getTechrating());
			interviewschedulerEntity.setHrrating(interviewscheduler.getHrrating());
			interviewschedulerEntity.setFinalstatus(interviewscheduler.getFinalstatus());
			
			interviewschedulerEntity = interviewSchedulerRepo.save(interviewschedulerEntity);
			return InterviewSchedulerUtil.convertInterviewSchedulerEntityIntoInterviewScheduler(interviewschedulerEntity);
		}
		else
			throw new InterviewSchedulerNotFoundException("No such candidate with InterviewID "+interviewid);
	}
	//for creating interviewscheduler
	
	@Override
	public InterviewScheduler createNewInterviewSchedule(int candidateid, InterviewScheduler interviewscheduler)throws CandidateNotFoundException {
		
		Optional<CandidateEntity> candidateEntityOp = candidateRepo.findById(candidateid);
		
		if(candidateEntityOp.isPresent())
		{
			CandidateEntity candidateEntity = candidateEntityOp.get();
			InterviewSchedulerEntity ise = InterviewSchedulerUtil.convertInterviewSchedulerIntoInterviewSchedulerEntityForScheduleInterview(interviewscheduler, candidateEntity) ;
			InterviewSchedulerEntity interviewschedulerEntity =interviewSchedulerRepo.save(ise);
		
			return InterviewSchedulerUtil.convertInterviewSchedulerEntityIntoInterviewSchedulerForScheduleInterview(interviewschedulerEntity);
		}
		else {
			throw new CandidateNotFoundException("No such candidate with candidateID "+candidateid);
		}
	}	
	@Override
	public boolean deleteById(int interviewid)throws InterviewSchedulerNotFoundException {
		
		Optional<InterviewSchedulerEntity> opinterviewschedulerEntity = interviewSchedulerRepo.findById(interviewid);
		InterviewScheduler interviewscheduler = null;
		if(opinterviewschedulerEntity.isPresent())
		{	
			interviewSchedulerRepo.deleteById(interviewid);
			return true;
		}
		else
		{
			throw new InterviewSchedulerNotFoundException("No such candidate with InterviewID "+interviewid);
		}
	}
	//for giving techrating
	@Override
	public InterviewSchedulerEntity giveTechRating(String interviewid) {

		InterviewSchedulerEntity interviewSchedulerEntity = interviewSchedulerRepo.findByfinalstatus(interviewid);
		if(interviewSchedulerEntity != null) {
			return interviewSchedulerRepo.save(interviewSchedulerEntity); 
		}
		else{
			interviewSchedulerEntity = interviewSchedulerRepo.findByInterviewid(Integer.valueOf(interviewid));
			//System.out.println("Entered the else loop...");
			if(interviewSchedulerEntity.getTechrating()==0) {
				double Techrating=0;
				int min=0;
				int max=10;
					 Techrating=Math.random()*(max-min+1)+min;	
				interviewSchedulerEntity.setTechrating((int)Techrating);
				}
			return interviewSchedulerRepo.save(interviewSchedulerEntity);
		}	
	}
	//For giving Hrrating
	@Override
	public InterviewSchedulerEntity giveHrRating(String interviewid) {

		InterviewSchedulerEntity interviewSchedulerEntity = interviewSchedulerRepo.findByfinalstatus(interviewid);
		if(interviewSchedulerEntity != null) {
			return interviewSchedulerRepo.save(interviewSchedulerEntity); 
		}
		else{
			interviewSchedulerEntity = interviewSchedulerRepo.findByInterviewid(Integer.valueOf(interviewid));
			//System.out.println("Entered the else loop...");
			if(interviewSchedulerEntity.getHrrating()==0) {
				double Hrrating=0;
				int min=0;
				int max=10;
					 Hrrating=Math.random()*(max-min+1)+min;	
				interviewSchedulerEntity.setHrrating((int)Hrrating);
				}
			return interviewSchedulerRepo.save(interviewSchedulerEntity); 
		}
	}
	//To View Interview Members For Hr
		@Override
		public CandidateEntity viewInterviewMembersForHr(int interviewid) {
			InterviewSchedulerEntity interviewSchedulerEntity = interviewSchedulerRepo.findByInterviewid(interviewid);
			CandidateEntity candidateEntity=interviewSchedulerEntity.getCandidate();
			return candidateEntity;			
		}
	//to view Interview Members for tech
	@Override
	public CandidateEntity viewInterviewMembersForTech(int interviewid) {
		InterviewSchedulerEntity interviewSchedulerEntity = interviewSchedulerRepo.findByInterviewid(interviewid);
		CandidateEntity candidateEntity=interviewSchedulerEntity.getCandidate();
		return candidateEntity;		
	}
}