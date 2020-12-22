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
	private int location;
	
	@Column(name="finalstatus")
	private String finalstatus;
	
	@OneToOne(cascade={CascadeType.ALL},
			fetch=FetchType.EAGER, optional = false)
	@JoinColumn(name="candidateid")
	private CandidateEntity candidateid;
	
	@OneToOne(cascade={CascadeType.ALL},
			fetch=FetchType.EAGER, optional = false)
	@JoinColumn(name="employeeid")
	private EmployeeEntity employeeid;
	
	public InterviewSchedulerEntity() {
		super();
		// TODO Auto-generated constructor stub
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
    
    public InterviewSchedulerEntity(int interviewid, CandidateEntity candidateid, EmployeeEntity employeeid) {
    	super();
    	this.interviewid = interviewid;
    	this.candidateid = candidateid;
    	this.employeeid = employeeid;
    }

	public InterviewSchedulerEntity(int interviewid, int techrating, int hrrating, int location, String finalstatus) {
		super();
		this.interviewid = interviewid;
		this.techrating = techrating;
		this.hrrating = hrrating;
		this.location = location;
		this.finalstatus = finalstatus;
	}
	
	public InterviewSchedulerEntity(int interviewid, int techrating, int hrrating, int location, String finalstatus,
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
	public int getInterviewid() {
		return interviewid;
	}
	public int getTechrating() {
		return techrating;
	}
	public int getHrrating() {
		return hrrating;
	}
	public int getLocation() {
		return location;
	}
	public String getFinalstatus() {
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
	public void setLocation(int location) {
		this.location = location;
	}
	public void setFinalstatus(String finalstatus) {
		this.finalstatus = finalstatus;
	}
	public void setCandidateid(CandidateEntity candidateid) {
		this.candidateid = candidateid;
	}
	
	public void setEmployeeid(EmployeeEntity employeeid) {
		this.employeeid = employeeid;
	}

	
	
	
	@Override
	public String toString() {
		return "InterviewSchedulerEntity [interviewid=" + interviewid + ", techrating=" + techrating + ", hrrating="
				+ hrrating + ", location=" + location + ", finalstatus=" + finalstatus + "]";
	}

}
