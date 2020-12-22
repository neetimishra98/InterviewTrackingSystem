package com.spring.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cg.json.Candidate;
import com.spring.cg.repo.CandidateRepo;
import com.spring.cg.entity.CandidateEntity;
import com.spring.cg.exception.CandidateNotFoundException;


@Service
public class CandidateServiceImpl implements CandidateService{
	
	@Autowired
	private CandidateRepo candidateRepo;
	
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

}
