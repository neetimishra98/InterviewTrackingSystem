package com.spring.cg.entity;

import java.time.LocalDate;
import java.util.Date;

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
@Table(name = "hr")
public class HRInterviewSchedulerEntity {

	@Id
	@GeneratedValue
	@Column(name = "interviewid")
	private int interviewid;

	@OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "candidateid")
	private CandidateEntity candidateid;

	@OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "panelid")
	private PanelMemberEntity panelid;

	@Column(name = "location")
	private String location;

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "start_time")
	private String start_time;

	@Column(name = "end_time")
	private String end_time;

	@Column(name = "hrrating")
	private int hrrating;

	@Column(name = "finalstatus")
	private String finalstatus;

	public HRInterviewSchedulerEntity() {
		super();
	}

	public HRInterviewSchedulerEntity(int interviewid,int hrrating) {
		super();
		this.interviewid = interviewid;
		
		this.hrrating = hrrating;
	}

	public HRInterviewSchedulerEntity(int interviewid) {
		super();
		this.interviewid = interviewid;
	}

	public HRInterviewSchedulerEntity( int hrrating, String location, String finalstatus) {
		super();
		
		this.hrrating = hrrating;
		this.location = location;
		this.finalstatus = finalstatus;
	}

	public HRInterviewSchedulerEntity(int interviewid, int hrrating, String location,
			String finalstatus) {
		super();
		this.interviewid = interviewid;
		
		this.hrrating = hrrating;
		this.location = location;
		this.finalstatus = finalstatus;
	}

	public HRInterviewSchedulerEntity(int interviewid, int hrrating, String location, String finalstatus,
			CandidateEntity candidateid, PanelMemberEntity panelid) {
		super();
		this.interviewid = interviewid;
		
		this.hrrating = hrrating;
		this.location = location;
		this.finalstatus = finalstatus;
		this.candidateid = candidateid;
		this.panelid = panelid;
	}

	public CandidateEntity getCandidateid() {
		return candidateid;
	}

	public void setCandidateid(CandidateEntity candidateid) {
		this.candidateid = candidateid;
	}

	public PanelMemberEntity getPanelid() {
		return panelid;
	}

	public void setPanelid(PanelMemberEntity panelid) {
		this.panelid = panelid;
	}

	public HRInterviewSchedulerEntity( int hrrating, String location, String finalstatus,
			CandidateEntity candidateid) {
		super();
	
		this.hrrating = hrrating;
		this.location = location;
		this.finalstatus = finalstatus;
		this.candidateid = candidateid;
	}

	public HRInterviewSchedulerEntity(int interviewid, int hrrating, String location, String finalstatus,
			LocalDate date, String start_time, String end_time, CandidateEntity candidateid, PanelMemberEntity panelid) {
		super();
		this.interviewid = interviewid;
		
		this.hrrating = hrrating;
		this.location = location;
		this.finalstatus = finalstatus;
		this.date = date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.candidateid = candidateid;
		this.panelid = panelid;
	}

	public HRInterviewSchedulerEntity(int hrrating, String location, String finalstatus, LocalDate date,
			String start_time, String end_time, CandidateEntity candidateid) {
		super();
		
		this.hrrating = hrrating;
		this.location = location;
		this.finalstatus = finalstatus;
		this.date = date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.candidateid = candidateid;
	}

	public HRInterviewSchedulerEntity(int interviewid, CandidateEntity candidateid, PanelMemberEntity panelid,
			String location, LocalDate date, String start_time, String end_time, int techrating, int hrrating,
			String finalstatus) {
		super();
		this.interviewid = interviewid;
		this.candidateid = candidateid;
		this.panelid = panelid;
		this.location = location;
		this.date = date;
		this.start_time = start_time;
		this.end_time = end_time;
		
		this.hrrating = hrrating;
		this.finalstatus = finalstatus;
	}

	public HRInterviewSchedulerEntity(int interviewid, int hrrating, String location, String finalstatus,
			LocalDate date, String start_time, String end_time, CandidateEntity candidateid) {
		super();
		this.interviewid = interviewid;
		
		this.hrrating = hrrating;
		this.location = location;
		this.finalstatus = finalstatus;
		this.date = date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.candidateid = candidateid;
	}

	public HRInterviewSchedulerEntity(int interviewid, CandidateEntity candidateid, PanelMemberEntity panelid,
			String location, LocalDate date, String start_time, String end_time, int hrrating, String finalstatus) {
		super();
		this.interviewid = interviewid;
		this.candidateid = candidateid;
		this.panelid = panelid;
		this.location = location;
		this.date = date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.hrrating = hrrating;
		this.finalstatus = finalstatus;
	}

	public HRInterviewSchedulerEntity(CandidateEntity candidateid) {
		this.candidateid = candidateid;
	}

	
	public int getInterviewid() {
		return interviewid;
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

	public PanelMemberEntity getPanel() {
		return panelid;
	}

	public void setPanel(PanelMemberEntity panelid) {
		this.panelid = panelid;
	}

	public CandidateEntity getCandidate() {
		return candidateid;
	}

	public void setCandidate(CandidateEntity candidate) {
		this.candidateid = candidate;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate localDate) {
		this.date = localDate;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public void setInterviewid(int interviewid) {
		this.interviewid = interviewid;
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
		return "InterviewSchedulerEntity [interviewid=" + interviewid + ", hrrating="
				+ hrrating + ", location=" + location + ", finalstatus=" + finalstatus + ", date=" + date
				+ ", start_time=" + start_time + ", end_time=" + end_time + ", candidate=" + candidateid + ", panel="
				+ panelid + "]";
	}
}