package com.spring.cg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="interviewscheduler")
public class InterviewSchedulerEntity {
	
	@Id
	@GeneratedValue
	@Column(name="interviewid")
	private int interviewid;
	
	@Column(name="techrating")
	private int techrating;
	
	@Column(name="hrrating")
	private int hrrating;
	
	@Column(name="location")
	private String location;
	
	@Column(name="finalstatus")
	private String finalstatus;
	
	@OneToOne(cascade={CascadeType.ALL},
			fetch=FetchType.EAGER, optional = false)
	@JoinColumn(name="candidateid")
	private CandidateEntity candidate;
	public InterviewSchedulerEntity() {
		super();
	}
	
	public InterviewSchedulerEntity(int interviewid, int techrating, int hrrating) {
		super();
		this.interviewid= interviewid;
		this.techrating = techrating;
		this.hrrating = hrrating;
	}

    public InterviewSchedulerEntity(int interviewid) {
		super();
		this.interviewid= interviewid;
	}
    
  
	public InterviewSchedulerEntity(int techrating, int hrrating, String location, String finalstatus) {
		super();
		this.techrating = techrating;
		this.hrrating = hrrating;
		this.location = location;
		this.finalstatus = finalstatus;
	}

	public InterviewSchedulerEntity(int interviewid, int techrating, int hrrating, String location, String finalstatus) {
		super();
		this.interviewid = interviewid;
		this.techrating = techrating;
		this.hrrating = hrrating;
		this.location = location;
		this.finalstatus = finalstatus;
	}
	
	public InterviewSchedulerEntity(int interviewid, int techrating, int hrrating, String location, String finalstatus,
			CandidateEntity candidate) {
		super();
		this.interviewid = interviewid;
		this.techrating = techrating;
		this.hrrating = hrrating;
		this.location = location;
		this.finalstatus = finalstatus;
		this.candidate = candidate;
	}
	
	public InterviewSchedulerEntity(int techrating, int hrrating, String location, String finalstatus,
			CandidateEntity candidate) {
		super();
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
	
	public String getLocation() {
		return location;
	}
	
	public String getFinalstatus() {
		return finalstatus;
	}
	
	
	
	public CandidateEntity getCandidate() {
		return candidate;
	}

	public void setCandidate(CandidateEntity candidate) {
		this.candidate = candidate;
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
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	public void setFinalstatus(String finalstatus) {
		this.finalstatus = finalstatus;
	}	
	@Override
	public String toString() {
		return "InterviewSchedulerEntity [interviewid=" + interviewid + ", techrating=" + techrating + ", hrrating="
				+ hrrating + ", location=" + location + ", finalstatus=" + finalstatus + ", candidate=" + candidate
				+ "]";
	}
	
}
