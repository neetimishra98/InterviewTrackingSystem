package com.spring.cg.service;

import java.util.List;
import java.util.Map;

import com.spring.cg.exception.CandidateNotFoundException;
import com.spring.cg.json.Candidate;


public interface CandidateService {
	public Candidate createCandidate(Candidate candidate);
	public List<Candidate> getAllCandidates();
	public Candidate getCandidateById(int candidateid) throws CandidateNotFoundException;
	
	//To view Candidate For HR USING CANDIDATE ID AND CANDIDATE NAME
	public Map<Candidate, String> viewCandidateById(int candidateid) throws CandidateNotFoundException;
		
	//To view Candidate For Tech
	public Map<Candidate, String> listTechInterviewCandidates(int candidateid) throws CandidateNotFoundException;


}
