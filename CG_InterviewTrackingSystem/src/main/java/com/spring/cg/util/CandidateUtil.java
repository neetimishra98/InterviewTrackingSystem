package com.spring.cg.util;

import java.util.ArrayList;
import java.util.List;

import com.spring.cg.entity.CandidateEntity;
import com.spring.cg.entity.DesignationEntity;
import com.spring.cg.entity.LocationEntity;
import com.spring.cg.entity.PrimarySkillsEntity;
import com.spring.cg.entity.QualificationEntity;
import com.spring.cg.entity.SecondarySkillsEntity;
import com.spring.cg.json.Candidate;
import com.spring.cg.json.Designation;
import com.spring.cg.json.Location;
import com.spring.cg.json.PrimarySkills;
import com.spring.cg.json.Qualification;
import com.spring.cg.json.SecondarySkills;

public class CandidateUtil {
	
	public static CandidateEntity convertCandidateIntoCandidateEntity(Candidate candidate) {
		
		return new CandidateEntity(candidate.getCandidatename(), candidate.getLocation(),
				candidate.getQualification(), candidate.getDesignation(),
				candidate.getExperience(), candidate.getPrimaryskills(),
				candidate.getSecondaryskills(), candidate.getNoticeperiod());
	}
	
	public static Candidate convertCandidateEntityIntoCandidate(CandidateEntity candidateEntity) {
		
		return new Candidate(candidateEntity.getCandidateid(),
				candidateEntity.getCandidatename(), candidateEntity.getLocation(),
				candidateEntity.getQualification(), candidateEntity.getDesignation(),
				candidateEntity.getExperience(), candidateEntity.getPrimaryskills(),
				candidateEntity.getSecondaryskills(), candidateEntity.getNoticeperiod());
	}
	
	
	public static List<Candidate> convertCandidateEntityListIntoCandidateList(List<CandidateEntity> candidateEntityList) {
		
		List<Candidate> candidates = new ArrayList<Candidate>();
		for(CandidateEntity candidateEntity: candidateEntityList) {
			candidates.add(convertCandidateEntityIntoCandidate(candidateEntity));
		}
		return candidates;
	}

	
	
	
	//For Dropdown Part Functionality
	
	//For Location
	public static List<Location> convertLocationEntityListIntoLocationList(List<LocationEntity> locationEntityList) {
		
		List<Location> locations = new ArrayList<Location>();
		for(LocationEntity locationEntity: locationEntityList) {
			locations.add(convertLocationEntityIntoLocation(locationEntity));
		}
		return locations;
	}
	
	public static Location convertLocationEntityIntoLocation(LocationEntity locationEntity) {
		
		return new Location(locationEntity.getLocation());
	}
	
	
	
	
	//For Qualification
	public static List<Qualification> convertQualificationEntityListIntoQualificationList(List<QualificationEntity> qualificationEntityList) {
		
		List<Qualification> qualifications = new ArrayList<Qualification>();
		for(QualificationEntity qualificationEntity: qualificationEntityList) {
			qualifications.add(convertQualificationEntityIntoQualification(qualificationEntity));
		}
		return qualifications;
	}
	
	public static Qualification convertQualificationEntityIntoQualification(QualificationEntity qualificationEntity) {
		
		return new Qualification(qualificationEntity.getQualification());
	}
	
	
	
	//For Designation
	public static List<Designation> convertDesignationEntityListIntoDesignationList(List<DesignationEntity> designationEntityList) {
		
		List<Designation> designations = new ArrayList<Designation>();
		for(DesignationEntity designationEntity: designationEntityList) {
			designations.add(convertDesignationEntityIntoDesignation(designationEntity));
		}
		return designations;
	}
	
	public static Designation convertDesignationEntityIntoDesignation(DesignationEntity designationEntity) {
		
		return new Designation(designationEntity.getDesigntion());
	}
	
	
	
	//For Primary Skills
	public static List<PrimarySkills> convertPrimarySkillsEntityListIntoPrimarySkillsList(List<PrimarySkillsEntity> primarySkillsEntityList) {
		
		List<PrimarySkills> primarySkills = new ArrayList<PrimarySkills>();
		for(PrimarySkillsEntity primarySkillsEntity: primarySkillsEntityList) {
			primarySkills.add(convertPrimarySkillsEntityIntoPrimarySkills(primarySkillsEntity));
		}
		return primarySkills;
	}
	
	public static PrimarySkills convertPrimarySkillsEntityIntoPrimarySkills(PrimarySkillsEntity primarySkillsEntity) {
		
		return new PrimarySkills(primarySkillsEntity.getPrimaryskill());
	}
	
	
	
	
	//For Secondary Skills
	public static List<SecondarySkills> convertSecondarySkillsEntityListIntoSecondarySkillsList(List<SecondarySkillsEntity> secondarySkillsEntityList) {
		
		List<SecondarySkills> secondarySkills = new ArrayList<SecondarySkills>();
		for(SecondarySkillsEntity secondarySkillsEntity: secondarySkillsEntityList) {
			secondarySkills.add(convertSecondarySkillsEntityIntoSecondarySkills(secondarySkillsEntity));
		}
		return secondarySkills;
	}
	
	public static SecondarySkills convertSecondarySkillsEntityIntoSecondarySkills(SecondarySkillsEntity secondarySkillsEntity) {
		
		return new SecondarySkills(secondarySkillsEntity.getSecondaryskill());
	}
}
