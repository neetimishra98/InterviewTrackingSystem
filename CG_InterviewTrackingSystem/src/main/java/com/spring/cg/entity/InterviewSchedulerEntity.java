package com.spring.cg.entity;
import java.sql.Date;
import java.sql.Time;
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
	private PanelMemberEntity panelMemberEntity;

@Column(name="location")
 private String location;
 
 @Column(name="date")
 private Date date;
 
 @Column(name="start_time")
 private Time start_time;
 
 @Column(name="end_time")
 private Time end_time;

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
   CandidateEntity candidate,PanelMemberEntity PanelMemberEntity) {
  super();
  this.interviewid = interviewid;
  this.techrating = techrating;

  this.location = location;
  this.finalstatus = finalstatus;
  this.candidate = candidate;
  this.panelMemberEntity=PanelMemberEntity;
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
		Date date, Time start_time, Time end_time, CandidateEntity candidate, PanelMemberEntity panel) {
	super();
	this.interviewid = interviewid;
	this.techrating = techrating;

	this.location = location;
	this.finalstatus = finalstatus;
	this.date = date;
	this.start_time = start_time;
	this.end_time = end_time;
	this.candidate = candidate;
	this.panelMemberEntity = panel;
 }
public InterviewSchedulerEntity(int techrating,String location, String finalstatus, Date date,
		Time start_time, Time end_time, CandidateEntity candidate) {
	super();
	this.techrating = techrating;
	
	this.location = location;
	this.finalstatus = finalstatus;
	this.date = date;
	this.start_time = start_time;
	this.end_time = end_time;
	this.candidate = candidate;
}
public InterviewSchedulerEntity(int interviewid, CandidateEntity candidate, PanelMemberEntity panelMemberEntity,
		String location, Date date, Time start_time, Time end_time, int techrating, String finalstatus) {
	super();
	this.interviewid = interviewid;
	this.candidate = candidate;
	this.panelMemberEntity = panelMemberEntity;
	this.location = location;
	this.date = date;
	this.start_time = start_time;
	this.end_time = end_time;
	this.techrating = techrating;

	this.finalstatus = finalstatus;
}

public InterviewSchedulerEntity(int interviewid, int techrating,String location, String finalstatus,
		Date date, Time start_time, Time end_time, CandidateEntity candidate) {
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
	return panelMemberEntity;
}

public void setPanel(PanelMemberEntity panel) {
	this.panelMemberEntity = panel;
}

 public CandidateEntity getCandidate() {
  return candidate;
 }

 public void setCandidate(CandidateEntity candidate) {
  this.candidate = candidate;
 }

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public Time getStart_time() {
	return start_time;
}

public void setStart_time(Time start_time) {
	this.start_time = start_time;
}

public Time getEnd_time() {
	return end_time;
}

public void setEnd_time(Time end_time) {
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
	return panelMemberEntity;
 }

public void setPanelMemberEntity(PanelMemberEntity panelMemberEntity) {
	this.panelMemberEntity = panelMemberEntity;
 }

 @Override
public String toString() {
	return "InterviewSchedulerEntity [interviewid=" + interviewid + ", techrating=" + techrating + ", location=" + location + ", finalstatus=" + finalstatus + ", date=" + date + ", start_time="
			+ start_time + ", end_time=" + end_time + ", candidate=" + candidate + ", panel=" + panelMemberEntity + "]";
}
}