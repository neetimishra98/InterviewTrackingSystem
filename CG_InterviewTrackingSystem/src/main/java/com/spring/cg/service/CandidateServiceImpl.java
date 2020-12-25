package com.spring.cg.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cg.json.Candidate;
import com.spring.cg.repo.CandidateRepo;
import com.spring.cg.repo.InterviewSchedulerRepo;
import com.spring.cg.entity.CandidateEntity;
import com.spring.cg.exception.CandidateNotFoundException;


@Service
public class CandidateServiceImpl implements CandidateService{
	
	@Autowired
	private CandidateRepo candidateRepo;
	
	@Autowired
	InterviewSchedulerRepo interviewSchedulerRepo;
	
	@Override
	public Candidate createCandidate(Candidate candidate) {
		CandidateEntity candidateEntity = 
				candidateRepo.save(new CandidateEntity(candidate.getCandidatename(), candidate.getLocation(),candidate.getDesignation(),candidate.getQualification(),
						candidate.getExperience(),candidate.getPrimaryskills(),candidate.getSecondaryskills(),candidate.getNoticeperiod()));
		return new Candidate(candidateEntity.getCandidateid(), candidateEntity.getCandidatename(), candidateEntity.getLocation(),candidateEntity.getDesignation(),candidateEntity.getQualification(),
				candidateEntity.getExperience(),candidateEntity.getPrimaryskills(),candidateEntity.getSecondaryskills(),candidateEntity.getNoticeperiod());
	}

	@Override
	public List<Candidate> getAllCandidates(){
		List<CandidateEntity> candidateEntityList = candidateRepo.findAll();
		List<Candidate> candidates = new ArrayList<Candidate>();
		for(CandidateEntity candidateEntity: candidateEntityList) {
			candidates.add(new Candidate(candidateEntity.getCandidateid(), candidateEntity.getCandidatename(), candidateEntity.getLocation(),candidateEntity.getDesignation(),candidateEntity.getQualification(),
					candidateEntity.getExperience(),candidateEntity.getPrimaryskills(),candidateEntity.getSecondaryskills(),candidateEntity.getNoticeperiod()));
		}
		return candidates;
	}
	
	@Override
	public Candidate getCandidateById(int candidateid) throws CandidateNotFoundException{
		Optional<CandidateEntity> opCandidateEntity = candidateRepo.findById(candidateid);
		if(opCandidateEntity.isPresent()) {
			CandidateEntity candidateEntity = opCandidateEntity.get();
			return new Candidate(candidateEntity.getCandidateid(), candidateEntity.getCandidatename(), candidateEntity.getLocation(),candidateEntity.getDesignation(),candidateEntity.getQualification(),
					candidateEntity.getExperience(),candidateEntity.getPrimaryskills(),candidateEntity.getSecondaryskills(),candidateEntity.getNoticeperiod());
		}
		else {
			throw new CandidateNotFoundException("candidateid" + candidateid);
		}
		
	}
	
	//VIEW CANDIDATE FOR HR USING CANDIDATE ID
	@Override
	public Candidate getCandidateByIdForHR(int candidateid) throws CandidateNotFoundException{
		Optional<CandidateEntity> opCandidateEntity = candidateRepo.findById(candidateid);
		if(opCandidateEntity.isPresent()) {
			CandidateEntity candidateEntity = opCandidateEntity.get();
			return new Candidate(candidateEntity.getCandidateid(), candidateEntity.getCandidatename(), candidateEntity.getLocation(),candidateEntity.getDesignation(),candidateEntity.getQualification(),
					candidateEntity.getExperience(),candidateEntity.getPrimaryskills(),candidateEntity.getSecondaryskills(),candidateEntity.getNoticeperiod());
		}
		else {
			throw new CandidateNotFoundException("candidateid" + candidateid);
		}
		
	}
	
	//VIEW A CANDIDATE DETAILS FOR HR
	@Override
	public Map<Candidate, String> listInterviewCandidates(int candidateid) throws CandidateNotFoundException{
		Optional<CandidateEntity> opCandidateEntity = candidateRepo.findById(candidateid);
		Map<Candidate, String> candidates = new HashMap<Candidate, String>();
		if(opCandidateEntity.isPresent()) {
			CandidateEntity candidateEntity = opCandidateEntity.get();
			candidates.put(new Candidate(candidateEntity.getCandidateid(), candidateEntity.getCandidatename(), candidateEntity.getLocation(),candidateEntity.getDesignation(),candidateEntity.getQualification(),
					candidateEntity.getExperience(),candidateEntity.getPrimaryskills(),candidateEntity.getSecondaryskills(),candidateEntity.getNoticeperiod()), interviewSchedulerRepo.findByCandidate(candidateEntity).getFinalstatus());
		}
		return candidates;
	}
	
	//To view Candidate For Tech
		public Map<Candidate, String> listTechInterviewCandidates(int candidateid) throws CandidateNotFoundException{
			Optional<CandidateEntity> opCandidateEntity = candidateRepo.findById(candidateid);
			Map<Candidate, String> candidates = new HashMap<Candidate, String>();
			if(opCandidateEntity.isPresent()) {
				CandidateEntity candidateEntity = opCandidateEntity.get();
				candidates.put(new Candidate(candidateEntity.getCandidateid(), candidateEntity.getCandidatename(), candidateEntity.getLocation(),candidateEntity.getDesignation(),candidateEntity.getQualification(),
						candidateEntity.getExperience(),candidateEntity.getPrimaryskills(),candidateEntity.getSecondaryskills(),candidateEntity.getNoticeperiod()), interviewSchedulerRepo.findByCandidate(candidateEntity).getFinalstatus());
			}
			return candidates;
		}

	

}
