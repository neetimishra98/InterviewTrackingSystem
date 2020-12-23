package com.spring.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cg.entity.InterviewSchedulerEntity;
import com.spring.cg.repo.InterviewSchedulerRepo;

@Service
public class InterviewSchedulerServiceImpl implements InterviewSchedulerService {
	
	@Autowired
	InterviewSchedulerRepo interviewSchedulerRepo;

	@Override
	public InterviewSchedulerEntity giveTechRating(int interviewid) {
		
		double techrating=0;
		int min=0;
		int max=10;
			 techrating=Math.random()*(max-min+1)+min;
		
		InterviewSchedulerEntity interviewSchedulerEntity = interviewSchedulerRepo.findByInterviewid(interviewid);
		if(interviewSchedulerEntity.getTechrating()==0) {
			interviewSchedulerEntity.setTechrating((int)techrating);
			interviewSchedulerEntity.setFinalstatus("Tech_complete");
		}
		return interviewSchedulerRepo.save(interviewSchedulerEntity);
    }	
	
	@Override
	public InterviewSchedulerEntity giveHrRating(int interviewid) {
		
		double Hrrating=0;
		int min=0;
		int max=10;
			 Hrrating=Math.random()*(max-min+1)+min;
		
		InterviewSchedulerEntity interviewSchedulerEntity = interviewSchedulerRepo.findByInterviewid(interviewid);
		if(interviewSchedulerEntity.getHrrating()==0) {
			interviewSchedulerEntity.setHrrating((int) Hrrating);
			interviewSchedulerEntity.setFinalstatus("Hr_complete");
		}
		return interviewSchedulerRepo.save(interviewSchedulerEntity);   
    }	

}
