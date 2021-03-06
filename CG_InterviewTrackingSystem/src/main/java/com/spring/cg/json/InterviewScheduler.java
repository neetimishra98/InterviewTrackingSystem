
package com.spring.cg.json;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

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
 

 @ApiModelProperty(value="Interview Candidate")
 private Candidate candidate;
 
 @ApiModelProperty(value="Interview Panel")
 private  PanelMember panelid;
 
 @NotNull
 @NotBlank
 @ApiModelProperty(value="Interview Location")
 private String location;

 @NotNull
 @NotBlank
 @ApiModelProperty(value="Interview date")
 private LocalDate date;

 @NotNull
 @NotBlank
 @ApiModelProperty(value="Interview Start time")
 private String start_time;

 @NotNull
 @NotBlank
 @ApiModelProperty(value="Interview End time")
 private String end_time;
 
 @Min(value=0)
 @Max(value=10)
 @ApiModelProperty(value="Technical Rating")
 private int techrating;

 @NotNull
 @NotBlank
 @ApiModelProperty(value="Interview FinalStatus")
 private String finalstatus;
 


public InterviewScheduler() {
  super();
 }
 
 public InterviewScheduler(int interviewid) {
  super();
  this.interviewid = interviewid;
 }

public InterviewScheduler(int techrating, String location,String finalstatus) {
  super();
  this.techrating = techrating;
 
  this.location = location;
  this.finalstatus = finalstatus;
 }

 public InterviewScheduler(int interviewid, int techrating) {
  super();
  this.interviewid = interviewid;
  this.techrating = techrating;
 
 }

 public InterviewScheduler(int interviewid, int techrating,String location, String finalstatus) {
  super();
  this.interviewid = interviewid;
  this.techrating = techrating;
  
  this.location = location;
  this.finalstatus = finalstatus;
 }
 
 public InterviewScheduler(int interviewid, int techrating, String location, String finalstatus,
   Candidate candidate) {
  super();
  this.interviewid = interviewid;
  this.techrating = techrating;
 
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
 
 
 
 public String  getLocation() {
  return location;
 }
 
 public String  getFinalstatus() {
  return finalstatus;
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

public PanelMember getPanelMember() {
	return panelid;
}

public void setPanelMember(PanelMember panel) {
	this.panelid = panel;
}

public void setEnd_time(String end_time) {
	this.end_time = end_time;
}

public Candidate getCandidate() {
  return candidate;
 }

 public void setCandidate(Candidate candidate) {
  this.candidate = candidate;
 }

 public void setInterviewid(int interviewid) {
  this.interviewid = interviewid;
 }
 
 public void setTechrating(int techrating) {
  this.techrating = techrating;
 }

 
 public void setLocation(String  location) {
  this.location = location;
 }
 
 public void setFinalstatus(String  finalstatus) {
  this.finalstatus = finalstatus;
 }

 @Override
public String toString() {
	return "InterviewScheduler [interviewid=" + interviewid + ", candidate=" + candidate + ", panelMember="
			+ panelid + ", location=" + location + ", date=" + date + ", start_time=" + start_time + ", end_time="
			+ end_time + ", techrating=" + techrating + ", finalstatus=" + finalstatus + "]";
}

public InterviewScheduler(int interviewid, Candidate candidate, PanelMember panelid,
		String location,LocalDate date,String start_time,
		 String end_time, int techrating,String finalstatus) {
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

public InterviewScheduler(Candidate candidate, PanelMember panelid,
		LocalDate date, String location,String start_time,
		 String end_time, int techrating,String finalstatus) {
	super();
	this.candidate = candidate;
	this.panelid = panelid;
	this.location = location;
	this.date = date;
	this.start_time = start_time;
	this.end_time = end_time;
	this.techrating = techrating;
	this.finalstatus = finalstatus;
}

public InterviewScheduler(Candidate candidate, PanelMember panelid,
		String location,String start_time,
		 String end_time, int techrating,String finalstatus) {
	super();
	this.candidate = candidate;
	this.panelid = panelid;
	this.location = location;
	this.start_time = start_time;
	this.end_time = end_time;
	this.techrating = techrating;
	this.finalstatus = finalstatus;
}


public InterviewScheduler(int interviewid, int techrating,String location, String finalstatus,
		LocalDate date, String start_time, String end_time) {
	super();
	this.interviewid = interviewid;
	this.techrating = techrating;
	
	this.location = location;
	this.finalstatus = finalstatus;
	this.date = date;
	this.start_time = start_time;
	this.end_time = end_time;
	
}















}