package com.spring.cg.service;

import java.util.List;
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
	private InterviewSchedulerRepo interviewschedulerRepo;
	
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
	
		Optional<InterviewSchedulerEntity> interviewschedulerEntityOp = interviewschedulerRepo.findById(interviewid);
		
		if(interviewschedulerEntityOp.isPresent())
		{
			InterviewSchedulerEntity interviewschedulerEntity = interviewschedulerEntityOp.get();
			interviewschedulerEntity.setTechrating(interviewscheduler.getTechrating());
			interviewschedulerEntity.setHrrating(interviewscheduler.getHrrating());
			interviewschedulerEntity.setFinalstatus(interviewscheduler.getFinalstatus());
			
			interviewschedulerEntity = interviewschedulerRepo.save(interviewschedulerEntity);
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
			InterviewSchedulerEntity interviewschedulerEntity =interviewschedulerRepo.save(ise);
		
			return InterviewSchedulerUtil.convertInterviewSchedulerEntityIntoInterviewSchedulerForScheduleInterview(interviewschedulerEntity);
		}
		else {
			throw new CandidateNotFoundException("No such candidate with candidateID "+candidateid);
		}
	}
	
		
	
	@Override
	public boolean deleteById(int interviewid)throws InterviewSchedulerNotFoundException {
		
		Optional<InterviewSchedulerEntity> opinterviewschedulerEntity = interviewschedulerRepo.findById(interviewid);
		InterviewScheduler interviewscheduler = null;
		if(opinterviewschedulerEntity.isPresent())
		{	
			interviewschedulerRepo.deleteById(interviewid);
			return true;
		}
		else
		{
			throw new InterviewSchedulerNotFoundException("No such candidate with InterviewID "+interviewid);
		}
	}

}
