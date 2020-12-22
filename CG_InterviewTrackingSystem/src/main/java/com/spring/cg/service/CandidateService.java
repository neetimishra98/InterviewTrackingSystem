package com.spring.cg.service;

import java.util.List;

import com.spring.cg.exception.CandidateNotFoundException;
import com.spring.cg.json.Candidate;


public interface CandidateService {
	public Candidate createCandidate(Candidate candidate);
	public List<Candidate> getAllCandidates();
	public Candidate getCandidateById(int candidateid) throws CandidateNotFoundException;

}
