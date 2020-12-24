package com.spring.cg.json;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
	private Candidate candidate;
	
	@ApiModelProperty(value="Interview Employee")
	private Employee employee;
	
	public InterviewScheduler() {
		super();
	}
	
	public InterviewScheduler(int interviewid) {
		super();
		this.interviewid = interviewid;
	}

	public InterviewScheduler(int techrating, int hrrating, String location,String finalstatus) {
		super();
		this.techrating = techrating;
		this.hrrating = hrrating;
		this.location = location;
		this.finalstatus = finalstatus;
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
			Candidate candidate) {
		super();
		this.interviewid = interviewid;
		this.techrating = techrating;
		this.hrrating = hrrating;
		this.location = location;
		this.finalstatus = finalstatus;
		this.candidate = candidate;
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
	
	
	

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
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

	@Override
	public String toString() {
		return "InterviewScheduler [interviewid=" + interviewid + ", techrating=" + techrating + ", hrrating="
				+ hrrating + ", location=" + location + ", finalstatus=" + finalstatus + ", candidate=" + candidate
				+ "]";
	}
	
	
}
