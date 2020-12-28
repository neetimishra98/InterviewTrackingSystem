package com.spring.cg.service;

import java.util.List;
import java.util.Map;

import com.spring.cg.exception.CandidateNotFoundException;
import com.spring.cg.exception.EmployeeNotFoundException;
import com.spring.cg.json.Candidate;


public interface CandidateService {

	public Candidate addCandidate(Candidate candidate);
	public List<Candidate> viewAllCandidates();
	public Candidate viewCandidateById(int candidateid) throws CandidateNotFoundException;
	public List<Candidate> viewCandidateByName(String candidatename) throws CandidateNotFoundException;
	public List<Candidate> viewCandidateByLocation(String location) throws CandidateNotFoundException;
	public List<Candidate> viewCandidateByQualification(String qualification) throws CandidateNotFoundException;
	public List<Candidate> viewCandidateByDesignation(String designation) throws CandidateNotFoundException;
	public List<Candidate> viewCandidateByPrimarySkills(String primaryskills) throws CandidateNotFoundException;
	
	
	
	
	
	public List<Location> getAllLocations();
	public List<Qualification> getAllQualifications();
	public List<Designation> getAllDesignations();
	public List<PrimarySkills> getAllPrimarySkills();
	public List<SecondarySkills> getAllSecondarySkills();



	
	//INTERFACE FOR VIEWING CANDIDATE DETAILS BY HR
	public Map<Candidate, String> viewCandidateForHR(String candidateId) throws CandidateNotFoundException;
	
	//To view Candidate For Tech
	public Map<Candidate, String> listTechInterviewCandidates(int candidateid) throws CandidateNotFoundException;
	


}
