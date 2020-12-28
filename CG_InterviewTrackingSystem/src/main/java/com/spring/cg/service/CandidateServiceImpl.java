package com.spring.cg.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cg.json.Candidate;
import com.spring.cg.json.Employee;
import com.spring.cg.repo.CandidateRepo;
import com.spring.cg.repo.InterviewSchedulerRepo;
import com.spring.cg.entity.CandidateEntity;
import com.spring.cg.entity.EmployeeEntity;
import com.spring.cg.exception.CandidateNotFoundException;
import com.spring.cg.exception.EmployeeNotFoundException;


@Service
public class CandidateServiceImpl implements CandidateService{
	
	@Autowired
	private CandidateRepo candidateRepo;
	
	@Autowired
	InterviewSchedulerRepo interviewSchedulerRepo;
	
	@Autowired
	private LocationRepo locationRepo;
	
	@Autowired
	private QualificationRepo qualificationRepo;
	
	@Autowired
	private DesignationRepo designationRepo;
	
	@Autowired
	private PrimarySkillsRepo primaryskillsRepo;
	
	@Autowired
	private SecondarySkillsRepo secondaryskillsRepo;
	
	
	
	//Function for adding candidate details
	@Override
	public Candidate addCandidate(Candidate candidate) {
		CandidateEntity candidateEntity = 
				candidateRepo.save(CandidateUtil.convertCandidateIntoCandidateEntity(candidate));
		return CandidateUtil.convertCandidateEntityIntoCandidate(candidateEntity);
	}
	
	
	//Function for viewing all details 
	@Override
	public List<Candidate> viewAllCandidates(){
		return CandidateUtil.convertCandidateEntityListIntoCandidateList(candidateRepo.findAll());
	}
	
	
	//Function for viewing details by specific Id
	@Override
	public Candidate viewCandidateById(int candidateid) throws CandidateNotFoundException{
		Optional<CandidateEntity> opCandidateEntity = candidateRepo.findById(candidateid);
		if(opCandidateEntity.isPresent()) {
			CandidateEntity candidateEntity = opCandidateEntity.get();
			return CandidateUtil.convertCandidateEntityIntoCandidate(candidateEntity);
		}
		else {
			throw new CandidateNotFoundException("CandidateId : " + candidateid);
		}
	}


	//Function for viewing details by Name
	public List<Candidate> viewCandidateByName(String candidatename) throws CandidateNotFoundException{
		
		List<CandidateEntity> candidateEntity = candidateRepo.findByNameIgnoreCase(candidatename);
		
		for(CandidateEntity ce : candidateEntity)
		{	
			if(ce.getCandidatename().equals(candidatename))
			{
				return CandidateUtil.convertCandidateEntityListIntoCandidateList(candidateEntity);
			}
		}
		
		throw new CandidateNotFoundException("CandidateName : " + candidatename);
	}
	
	
	//Function for viewing details by Location
	@Override
	public List<Candidate> viewCandidateByLocation(String location) throws CandidateNotFoundException {
		
		List<CandidateEntity> candidateEntity = candidateRepo.findByLocationIgnoreCase(location);
		
		for(CandidateEntity ce : candidateEntity)
		{	
			if(ce.getLocation().equals(location))
			{
				return CandidateUtil.convertCandidateEntityListIntoCandidateList(candidateEntity);
			}
		}
		
		throw new CandidateNotFoundException("Location : " + location);
	}


	//Function for viewing details by Qualification
	@Override
	public List<Candidate> viewCandidateByQualification(String qualification) throws CandidateNotFoundException {
		
		List<CandidateEntity> candidateEntity = candidateRepo.findByQualificationIgnoreCase(qualification);
		
		for(CandidateEntity ce : candidateEntity)
		{	
			if(ce.getQualification().equals(qualification))
			{
				return CandidateUtil.convertCandidateEntityListIntoCandidateList(candidateEntity);
			}
		}
		
		throw new CandidateNotFoundException("Qualification : " + qualification);
	}


	//Function for viewing details by Designation
	@Override
	public List<Candidate> viewCandidateByDesignation(String designation) throws CandidateNotFoundException {
		
		List<CandidateEntity> candidateEntity = candidateRepo.findByDesignationIgnoreCase(designation);
		
		for(CandidateEntity ce : candidateEntity)
		{	
			if(ce.getDesignation().equals(designation))
			{
				return CandidateUtil.convertCandidateEntityListIntoCandidateList(candidateEntity);
			}
		}
		
		throw new CandidateNotFoundException("Designation : " + designation);
	}


	//Function for viewing details by PrimarySkills
	@Override
	public List<Candidate> viewCandidateByPrimarySkills(String primaryskills) throws CandidateNotFoundException {
		
		List<CandidateEntity> candidateEntity = candidateRepo.findByPrimarySkillsIgnoreCase(primaryskills);
		
		for(CandidateEntity ce : candidateEntity)
		{	
			if(ce.getPrimaryskills().equals(primaryskills))
			{
				return CandidateUtil.convertCandidateEntityListIntoCandidateList(candidateEntity);
			}
		}
		
		throw new CandidateNotFoundException("PrimarySkill : " + primaryskills);
	}
	
	
	
	
	
	
	
	//---------For Dropdown Part Functionality-----------
	@Override
	public List<Location> getAllLocations() {
		
		return CandidateUtil.convertLocationEntityListIntoLocationList(locationRepo.findAll());
	}


	@Override
	public List<Qualification> getAllQualifications() {
		
		return CandidateUtil.convertQualificationEntityListIntoQualificationList(qualificationRepo.findAll());
	}


	@Override
	public List<Designation> getAllDesignations() {
		
		return CandidateUtil.convertDesignationEntityListIntoDesignationList(designationRepo.findAll());
	}


	@Override
	public List<PrimarySkills> getAllPrimarySkills() {
		
		return CandidateUtil.convertPrimarySkillsEntityListIntoPrimarySkillsList(primaryskillsRepo.findAll());
	}


	@Override
	public List<SecondarySkills> getAllSecondarySkills() {
		
		return CandidateUtil.convertSecondarySkillsEntityListIntoSecondarySkillsList(secondaryskillsRepo.findAll());
	}











	
	//VIEW CANDIDATE FOR HR USING CANDIDATE ID AND CANDIDATE NAME
		@Override
		public Map<Candidate, String> viewCandidateForHR(String candidateId) throws CandidateNotFoundException {

			CandidateEntity candidateEntity = candidateRepo.findByCandidatename(candidateId);
			Map<Candidate, String> candidates = new HashMap<Candidate, String>();
			if(candidateEntity!=null) {
				candidates.put(new Candidate(candidateEntity.getCandidateid(), candidateEntity.getCandidatename(), candidateEntity.getLocation(),candidateEntity.getDesignation(),candidateEntity.getQualification(),
						candidateEntity.getExperience(),candidateEntity.getPrimaryskills(),candidateEntity.getSecondaryskills(),candidateEntity.getNoticeperiod()), interviewSchedulerRepo.findByCandidate(candidateEntity).getFinalstatus());
				return candidates;
			}
			else{
				candidateEntity = candidateRepo.findByCandidateid(Integer.valueOf(candidateId));
				System.out.println("Entered the else loop...");
				if(candidateEntity==null) {
					throw new CandidateNotFoundException("Invalid Candidate Id");
				}
				candidates.put(new Candidate(candidateEntity.getCandidateid(), candidateEntity.getCandidatename(), candidateEntity.getLocation(),candidateEntity.getDesignation(),candidateEntity.getQualification(),
						candidateEntity.getExperience(),candidateEntity.getPrimaryskills(),candidateEntity.getSecondaryskills(),candidateEntity.getNoticeperiod()), interviewSchedulerRepo.findByCandidate(candidateEntity).getFinalstatus());
				return candidates;
			}
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
