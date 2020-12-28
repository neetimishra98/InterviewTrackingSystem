
package com.spring.cg.json;

import java.sql.Date;
import java.sql.Time;
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
 private  PanelMember panelMember;
 
 @NotNull
 @NotBlank
 @ApiModelProperty(value="Interview Location")
 private String location;

 @NotNull
 @NotBlank
 @ApiModelProperty(value="Interview date")
 private Date date;

 @NotNull
 @NotBlank
 @ApiModelProperty(value="Interview Start time")
 private Time start_time;

 @NotNull
 @NotBlank
 @ApiModelProperty(value="Interview End time")
 private Time end_time;
 
 @Min(value=0)
 @Max(value=10)
 @ApiModelProperty(value="Technical Rating")
 private int techrating;

 @NotNull
 @NotBlank
 @ApiModelProperty(value="Interview FinalStatus")
 private String finalstatus;
 
 
 
 public InterviewScheduler(int interviewid, Candidate candidate, PanelMember panelMember,
		 String location, Date date,Time start_time,
		 Time end_time,int hrrating,
		 String finalstatus, @Min(0) @Max(10) int techrating) {
	super();
	this.interviewid = interviewid;
	this.candidate = candidate;
	this.panelMember = panelMember;
	this.location = location;
	this.date = date;
	this.start_time = start_time;
	this.end_time = end_time;
	this.techrating = techrating;
	
	this.finalstatus = finalstatus;
}

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

public PanelMember getPanelMember() {
	return panelMember;
}

public void setPanelMember(PanelMember panel) {
	this.panelMember = panel;
}

public void setEnd_time(Time end_time) {
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
			+ panelMember + ", location=" + location + ", date=" + date + ", start_time=" + start_time + ", end_time="
			+ end_time + ", techrating=" + techrating + ", finalstatus=" + finalstatus + "]";
}

public InterviewScheduler(@Min(10000000) @Max(99999999) int interviewid, Candidate candidate, PanelMember panelMember,
		@NotNull @NotBlank String location, @NotNull @NotBlank Date date, @NotNull @NotBlank Time start_time,
		@NotNull @NotBlank Time end_time, @Min(0) @Max(10) int techrating, @NotNull @NotBlank String finalstatus) {
	super();
	this.interviewid = interviewid;
	this.candidate = candidate;
	this.panelMember = panelMember;
	this.location = location;
	this.date = date;
	this.start_time = start_time;
	this.end_time = end_time;
	this.techrating = techrating;
	this.finalstatus = finalstatus;
}
}