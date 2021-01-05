package com.spring.cg.entity;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

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
 
 @OneToOne(cascade={CascadeType.ALL},
   fetch=FetchType.EAGER, optional = false)
 @JoinColumn(name="candidateid")
 private CandidateEntity candidate;

 @OneToOne(cascade={CascadeType.ALL},
	fetch=FetchType.EAGER, optional = false)
@JoinColumn(name="panelid")
	private PanelMemberEntity panelid;

@Column(name="location")
 private String location;
 
 @Column(name="date")
 private LocalDate date;
 
 @Column(name="start_time")
 private String start_time;
 
 @Column(name="end_time")
 private String end_time;

 @Column(name="techrating")
 private int techrating;
 

@Column(name="finalstatus")
 private String finalstatus;
 
 
 public InterviewSchedulerEntity() {
  super();
 }
 
 public InterviewSchedulerEntity(int interviewid, int techrating) {
  super();
  this.interviewid= interviewid;
  this.techrating = techrating;

 }

    public InterviewSchedulerEntity(int interviewid) {
  super();
  this.interviewid= interviewid;
 }
    
    public InterviewSchedulerEntity(int techrating, String location, String finalstatus) {
  super();
  this.techrating = techrating;

  this.location = location;
  this.finalstatus = finalstatus;
 }

 public InterviewSchedulerEntity(int interviewid, int techrating, String location, String finalstatus) {
  super();
  this.interviewid = interviewid;
  this.techrating = techrating;
  this.location = location;
  this.finalstatus = finalstatus;
 }
 
 public InterviewSchedulerEntity(int interviewid, int techrating,String location, String finalstatus,
   CandidateEntity candidate,PanelMemberEntity panelid) {
  super();
  this.interviewid = interviewid;
  this.techrating = techrating;

  this.location = location;
  this.finalstatus = finalstatus;
  this.candidate = candidate;
  this.panelid=panelid;
 }
 
 public InterviewSchedulerEntity(int techrating, String location, String finalstatus,
   CandidateEntity candidate) {
  super();
  this.techrating = techrating;
  this.location = location;
  this.finalstatus = finalstatus;
  this.candidate = candidate;
 }

 public InterviewSchedulerEntity(int interviewid, int techrating, String location, String finalstatus,
		LocalDate date, String start_time, String end_time, CandidateEntity candidate, PanelMemberEntity panelid) {
	super();
	this.interviewid = interviewid;
	this.techrating = techrating;

	this.location = location;
	this.finalstatus = finalstatus;
	this.date = date;
	this.start_time = start_time;
	this.end_time = end_time;
	this.candidate = candidate;
	this.panelid = panelid;
 }
public InterviewSchedulerEntity(int techrating,String location, String finalstatus, LocalDate date,
		String start_time, String end_time, CandidateEntity candidate) {
	super();
	this.techrating = techrating;
	
	this.location = location;
	this.finalstatus = finalstatus;
	this.date = date;
	this.start_time = start_time;
	this.end_time = end_time;
	this.candidate = candidate;
}
public InterviewSchedulerEntity(int interviewid, CandidateEntity candidate, PanelMemberEntity panelid,
		String location, LocalDate date, String start_time, String end_time, int techrating, String finalstatus) {
	super();
	this.interviewid = interviewid;
	this.candidate = candidate;
	this.panelid = panelid;
	this.location = location;
	this.date = date;
	this.start_time = start_time;
	this.end_time = end_time;
	this.techrating = techrating;

	this.finalstatus = finalstatus;
}

public InterviewSchedulerEntity(int interviewid, int techrating,String location, String finalstatus,
		LocalDate date, String start_time, String end_time, CandidateEntity candidate) {
	super();
	this.interviewid = interviewid;
	this.techrating = techrating;
	
	this.location = location;
	this.finalstatus = finalstatus;
	this.date = date;
	this.start_time = start_time;
	this.end_time = end_time;
	this.candidate = candidate;
}

public int getInterviewid() {
  return interviewid;
 }
 
 public int getTechrating() {
  return techrating;
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

public void setPanel(PanelMemberEntity panel) {
	this.panelid = panel;
}

 public CandidateEntity getCandidate() {
  return candidate;
 }

 public void setCandidate(CandidateEntity candidate) {
  this.candidate = candidate;
 }

public LocalDate getDate() {
	return date;
}

public void setDate(LocalDate date) {
	this.date = date;
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
 
 public void setTechrating(int techrating) {
  this.techrating = techrating;
 }
 
 
 public void setLocation(String location) {
  this.location = location;
 }
 
 public void setFinalstatus(String finalstatus) {
  this.finalstatus = finalstatus;
 }

 public PanelMemberEntity getPanelMemberEntity() {
	return panelid;
 }

public void setPanelMemberEntity(PanelMemberEntity panelid) {
	this.panelid = panelid;
 }

 @Override
public String toString() {
	return "InterviewSchedulerEntity [interviewid=" + interviewid + ", techrating=" + techrating + ", location=" + location + ", finalstatus=" + finalstatus + ", date=" + date + ", start_time="
			+ start_time + ", end_time=" + end_time + ", candidate=" + candidate + ", panel=" + panelid + "]";
}
}