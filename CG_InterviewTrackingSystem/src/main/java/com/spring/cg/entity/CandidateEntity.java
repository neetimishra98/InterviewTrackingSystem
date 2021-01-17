package com.spring.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="candidate")
public class CandidateEntity {
	
	@Id
	@GeneratedValue
	@Column(name="candidateid")
	private int candidateid;
	
	@Column(name="candidatename")
	private String candidatename;
	
	@Column(name="location")
	private String location;
	
	@Column(name="qualification")
	private String qualification; 
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="experience")
	private int experience;
	
	@Column(name="primaryskills")
	private String primaryskills;
	
	@Column(name="secondaryskills")
	private String secondaryskills;
	
	@Column(name="noticeperiod")
	private int noticeperiod;
	
	public CandidateEntity() {
		super();
	}
	
	public CandidateEntity(String candidatename) {
		this.candidatename = candidatename;
	}

	public CandidateEntity(int candidateid, String candidatename, String location, 
			String qualification, String designation, int experience,  String primaryskills, String secondaryskills, int noticeperiod) {
		super();
		this.candidateid = candidateid;
		this.candidatename = candidatename;
		this.location = location;
		this.designation = designation;
		this.qualification = qualification;
		this.experience = experience;
		this.primaryskills = primaryskills;
		this.secondaryskills = secondaryskills;
		this.noticeperiod = noticeperiod;
	}
	
	public CandidateEntity( String candidatename, String location, 
			String qualification, String designation, int experience,  String primaryskills, String secondaryskills, int noticeperiod) {
		super();
		this.candidatename = candidatename;
		this.location = location;
		this.designation = designation;
		this.qualification = qualification;
		this.experience = experience;
		this.primaryskills = primaryskills;
		this.secondaryskills = secondaryskills;
		this.noticeperiod = noticeperiod;
	}


	public int getCandidateid() {
		return candidateid;
	}

	public void setCandidateid(int candidateid) {
		this.candidateid = candidateid;
	}

	public String getCandidatename() {
		return candidatename;
	}

	public void setCandidatename(String candidatename) {
		this.candidatename = candidatename;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getPrimaryskills() {
		return primaryskills;
	}

	public void setPrimaryskills(String primaryskills) {
		this.primaryskills = primaryskills;
	}

	public String getSecondaryskills() {
		return secondaryskills;
	}

	public void setSecondaryskills(String secondaryskills) {
		this.secondaryskills = secondaryskills;
	}

	public int getNoticeperiod() {
		return noticeperiod;
	}

	public void setNoticeperiod(int noticeperiod) {
		this.noticeperiod = noticeperiod;
	}

	@Override
	public String toString() {
		return "AddCandidate [candidateid=" + candidateid + ", candidatename=" + candidatename + ", location="
				+ location + ", qualification=" + qualification + ", designation=" + designation + ", experience="
				+ experience + ", primaryskills=" + primaryskills + ", secondaryskills=" + secondaryskills
				+ ", noticeperiod=" + noticeperiod + "]";
	}
}
