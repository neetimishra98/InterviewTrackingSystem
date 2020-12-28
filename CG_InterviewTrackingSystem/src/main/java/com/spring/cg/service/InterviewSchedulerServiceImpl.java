package com.spring.cg.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.cg.entity.CandidateEntity;
import com.spring.cg.entity.InterviewSchedulerEntity;
import com.spring.cg.entity.PanelMemberEntity;
import com.spring.cg.exception.CandidateNotFoundException;
import com.spring.cg.exception.InterviewSchedulerNotFoundException;
import com.spring.cg.json.Candidate;
import com.spring.cg.json.InterviewScheduler;
import com.spring.cg.repo.CandidateRepo;
import com.spring.cg.repo.InterviewSchedulerRepo;
import com.spring.cg.repo.PanelMemberRepo;
import com.spring.cg.util.InterviewSchedulerUtil;


@Service
public class InterviewSchedulerServiceImpl implements InterviewSchedulerService {
	
	@Autowired
	InterviewSchedulerRepo interviewSchedulerRepo;
	
	@Autowired
	private CandidateRepo candidateRepo;
	

	@Autowired
	private PanelMemberRepo panelMemberRepo;
	
	//for creating interviewscheduler
	
	@Override
	public InterviewScheduler createNewInterviewSchedule(int candidateid, int panelid,
			InterviewScheduler interviewscheduler) throws CandidateNotFoundException {

		Optional<PanelMemberEntity> panelMemberEntityOp = Optional.ofNullable(panelMemberRepo.findById(panelid));
		Optional<CandidateEntity> candidateEntityOp = candidateRepo.findById(candidateid);
		
		if(candidateEntityOp.isPresent())
		{
			CandidateEntity candidateEntity = candidateEntityOp.get();
			PanelMemberEntity panelMemberEntity=panelMemberEntityOp.get();
			InterviewSchedulerEntity ise = 
					InterviewSchedulerUtil.convertInterviewSchedulerIntoInterviewSchedulerEntityForScheduleInterview(interviewscheduler, candidateEntity, panelMemberEntity);
			InterviewSchedulerEntity interviewschedulerEntity =interviewSchedulerRepo.save(ise);
		
			return InterviewSchedulerUtil.convertInterviewSchedulerEntityIntoInterviewSchedulerForScheduleInterview(interviewschedulerEntity);
		}
		else {
			throw new CandidateNotFoundException("No such candidate with candidateID "+candidateid);
		}
	}
	
 /*	444
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
	
	
	//for giving hrrating
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
	
	
	//to view interview members
	@Override
	public List<Candidate> viewInterviewMembers() {
		List<CandidateEntity> candidateEntityList = candidateRepo.findAll();
		List<Candidate> candidates = new ArrayList<Candidate>();
		for(CandidateEntity candidateEntity: candidateEntityList) {
			candidates.add(new Candidate(candidateEntity.getCandidateid(), candidateEntity.getCandidatename(), candidateEntity.getLocation(),candidateEntity.getDesignation(),candidateEntity.getQualification(),
					candidateEntity.getExperience(),candidateEntity.getPrimaryskills(),candidateEntity.getSecondaryskills(),candidateEntity.getNoticeperiod()));
		}
		return candidates;
	}
	
	@Override
	public List<Candidate> viewInterviewMembersbyHr() {
		List<CandidateEntity> candidateEntityList = candidateRepo.findAll();
		List<Candidate> candidates = new ArrayList<Candidate>();
		for(CandidateEntity candidateEntity: candidateEntityList) {
			candidates.add(new Candidate(candidateEntity.getCandidateid(), candidateEntity.getCandidatename(), candidateEntity.getLocation(),candidateEntity.getDesignation(),candidateEntity.getQualification(),
					candidateEntity.getExperience(),candidateEntity.getPrimaryskills(),candidateEntity.getSecondaryskills(),candidateEntity.getNoticeperiod()));
		}
		return candidates;
	}

	@Override
	public InterviewScheduler createNewInterviewSchedule(int candidateid, InterviewScheduler interviewscheduler)
			throws CandidateNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


	
}
