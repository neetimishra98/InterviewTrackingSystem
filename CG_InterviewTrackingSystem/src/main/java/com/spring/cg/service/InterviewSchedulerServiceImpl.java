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
	public InterviewSchedulerEntity giveTechRating(int id) {
		
		double techrating=0;
		int min=0;
		int max=10;
			 techrating=Math.random()*(max-min+1)+min;
		
		InterviewSchedulerEntity ise = interviewSchedulerRepo.findByInterviewid(id);
		if(ise.getTechrating()==0) {
		ise.setTechrating((int)techrating);
		ise.setFinalstatus("Tech_complete");
		}
		return interviewSchedulerRepo.save(ise);
    }	
	
	@Override
	public InterviewSchedulerEntity giveHrRating(int id) {
		
		double Hrrating=0;
		int min=0;
		int max=10;
			 Hrrating=Math.random()*(max-min+1)+min;
		
		InterviewSchedulerEntity ise = interviewSchedulerRepo.findByInterviewid(id);
		if(ise.getHrrating()==0) {
		ise.setHrrating((int) Hrrating);
		ise.setFinalstatus("Hr_complete");
		}
		return interviewSchedulerRepo.save(ise);   
    }	

}
