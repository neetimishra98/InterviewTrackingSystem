package com.spring.cg.json;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.spring.cg.entity.CandidateEntity;
import com.spring.cg.entity.EmployeeEntity;

import io.swagger.annotations.ApiModelProperty;

public class InterviewScheduler {
	@Min(value=10000000)
	@Max(value=99999999)
	@ApiModelProperty(value="Interview ID")
	private int interviewid;
	
	@Min(value=0)
	@Max(value=10)
	@ApiModelProperty(value="Technical Rating")
	private int techrating;
	
	@Min(value=0)
	@Max(value=10)
	@ApiModelProperty(value="HR Rating")
	private int hrrating;
	
	@NotNull
	@NotBlank
	@ApiModelProperty(value="Interview Location")
	private String location;
	
	@NotNull
	@NotBlank
	@ApiModelProperty(value="Interview FinalStatus")
	private String finalstatus;
	
	@ApiModelProperty(value="Interview Candidate")
	private CandidateEntity candidateid;
	
	@ApiModelProperty(value="Interview Employee")
	private EmployeeEntity employeeid;
	
	public InterviewScheduler() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public InterviewScheduler(int interviewid) {
		super();
		this.interviewid = interviewid;
	}
	
	public InterviewScheduler(int interviewid, CandidateEntity candidateid, EmployeeEntity employeeid) {
    	super();
    	this.interviewid = interviewid;
    	this.candidateid = candidateid;
    	this.employeeid = employeeid;
    }

	public InterviewScheduler(int interviewid, int techrating, int hrrating) {
		super();
		this.interviewid = interviewid;
		this.techrating = techrating;
		this.hrrating = hrrating;
	}

	public InterviewScheduler(int interviewid, int techrating, int hrrating, String location, String finalstatus) {
		super();
		this.interviewid = interviewid;
		this.techrating = techrating;
		this.hrrating = hrrating;
		this.location = location;
		this.finalstatus = finalstatus;
	}
	
	public InterviewScheduler(int interviewid, int techrating, int hrrating, String location, String finalstatus,
			CandidateEntity candidateid, EmployeeEntity employeeid) {
		super();
		this.interviewid = interviewid;
		this.techrating = techrating;
		this.hrrating = hrrating;
		this.location = location;
		this.finalstatus = finalstatus;
		this.candidateid = candidateid;
		this.employeeid = employeeid;
	}

	@Override
	public String toString() {
		return "InterviewSchedulerEntity [interviewid=" + interviewid + ", techrating=" + techrating + ", hrrating="
				+ hrrating + ", location=" + location + ", finalstatus=" + finalstatus + "]";
	}
	public int getInterviewid() {
		return interviewid;
	}
	public int getTechrating() {
		return techrating;
	}
	public int getHrrating() {
		return hrrating;
	}
	public String  getLocation() {
		return location;
	}
	public String  getFinalstatus() {
		return finalstatus;
	}	
	public CandidateEntity getCandidateid() {
		return candidateid;
	}
	public EmployeeEntity getEmployeeid() {
		return employeeid;
	}
	public void setInterviewid(int interviewid) {
		this.interviewid = interviewid;
	}
	public void setTechrating(int techrating) {
		this.techrating = techrating;
	}
	public void setHrrating(int hrrating) {
		this.hrrating = hrrating;
	}
	public void setLocation(String  location) {
		this.location = location;
	}
	public void setFinalstatus(String  finalstatus) {
		this.finalstatus = finalstatus;
	}
	public void setCandidateid(CandidateEntity candidateid) {
		this.candidateid = candidateid;
	}
	public void setEmployeeid(EmployeeEntity employeeid) {
		this.employeeid = employeeid;
	}
}
