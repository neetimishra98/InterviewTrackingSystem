package com.spring.cg.json;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class Candidate {
	          
	@Min(value=10000000)
	@Max(value=99999999)
	@ApiModelProperty(value="Candidate ID")
	private int candidateid;
	
	@NotNull
	@NotBlank
	@ApiModelProperty(value="Candidate Name")
	private String candidatename;
	
	@NotNull
	@NotBlank
	@ApiModelProperty(value="Candidate Location")
	private String location;
	
	@NotNull
	@NotBlank
	@ApiModelProperty(value="Candidate Designation")
	private String designation;
	
	@NotNull
	@NotBlank
	@ApiModelProperty(value="Candidate Qualification")
	private String qualification;
	
	@Min(value=0)
	@Max(value=10)
	@ApiModelProperty(value="Candidate Experience")
	private int experience;

	@Min(value=0)
	@Max(value=10)
	@ApiModelProperty(value="Candidate NoticePeriod")
	private int noticeperiod;
	
	@NotNull
	@NotBlank
	@ApiModelProperty(value="Candidate PrimarySkills")
	private String primaryskills;
	
	@NotNull
	@NotBlank
	@ApiModelProperty(value="Candidate SecondarySkills")
	private String secondaryskills;
	
	public Candidate() {
		super();
	}
	
	public Candidate(int candidateid, String candidatename, String location, String qualification, String designation,
			 int experience, String primaryskills, String secondaryskills, int noticeperiod) {
		super();
		this.candidateid = candidateid;
		this.candidatename = candidatename;
		this.location = location;
		this.qualification = qualification;
		this.designation = designation;
		this.experience = experience;
		this.primaryskills = primaryskills;
		this.secondaryskills = secondaryskills;
		this.noticeperiod = noticeperiod;
	}
	
	public Candidate( String candidatename, String location, 
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
	
	
	@Override
	public String toString() {
		return "Candidate [candidateid=" + candidateid + ", candidatename=" + candidatename + ", location=" + location
				+ ", qualification=" + qualification + ", designation=" + designation + ", experience=" + experience
				+ ", primaryskills=" + primaryskills + ", secondaryskills=" + secondaryskills + ", noticeperiod="
				+ noticeperiod + "]";
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
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
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
	


}
