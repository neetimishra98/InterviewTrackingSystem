package com.spring.cg.json;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.spring.cg.entity.CandidateEntity;
import com.spring.cg.entity.PanelMemberEntity;

import io.swagger.annotations.ApiModelProperty;

public class HRInterviewScheduler {

	@Min(value = 10000000)
	@Max(value = 99999999)
	@ApiModelProperty(value = "Interview ID")
	private int interviewid;

	@ApiModelProperty(value = "Interview Candidate")
	private CandidateEntity candidateid;

	@ApiModelProperty(value = "Interview Panel")
	private PanelMemberEntity panelid;

	@NotNull
	@NotBlank
	@ApiModelProperty(value = "Interview Location")
	private String location;

	@NotNull
	@NotBlank
	@ApiModelProperty(value = "Interview date", required = true, dataType = "org.joda.time.LocalDate")

	private Date date;

	@NotNull
	@NotBlank
	@ApiModelProperty(value = "Interview Start time", required = true, dataType = "org.joda.time.LocalDateTime")
	private String start_time;

	@NotNull
	@NotBlank
	@ApiModelProperty(value = "Interview End time", required = true, dataType = "org.joda.time.LocalDateTime")
	private String end_time;

	@Min(value = 0)
	@Max(value = 10)
	@ApiModelProperty(value = "HR Rating")
	private int hrrating;

	@NotNull
	@NotBlank
	@ApiModelProperty(value = "Interview FinalStatus")
	private String finalstatus;


	public HRInterviewScheduler(int interviewid) {
		super();
		this.interviewid = interviewid;
	}

	public HRInterviewScheduler(int interviewid, CandidateEntity candidate, PanelMemberEntity panelMember, String location, Date date,
			String start_time, String end_time, int hrrating, String finalstatus) {
		super();
		this.interviewid = interviewid;
		this.candidateid = candidate;
		this.panelid = panelMember;
		this.location = location;
		this.date = date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.hrrating = hrrating;
		this.finalstatus = finalstatus;
	}
	
	public HRInterviewScheduler(int interviewid, int hrrating,String location, String finalstatus,
			Date date, String start_time, String end_time) {
		super();
		this.interviewid = interviewid;
		this.hrrating = hrrating;
		
		this.location = location;
		this.finalstatus = finalstatus;
		this.date = date;
		this.start_time = start_time;
		this.end_time = end_time;
		
	}
	
	public HRInterviewScheduler(int interviewid, int hrrating,String location, String finalstatus,
			Date date, String start_time, String end_time,CandidateEntity candidateid, PanelMemberEntity panelid) {
		super();
		this.interviewid = interviewid;
		this.hrrating = hrrating;
		
		this.location = location;
		this.finalstatus = finalstatus;
		this.date = date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.candidateid=candidateid;
		this.panelid = panelid;
		
		
	}
	 public HRInterviewScheduler( int hrrating, String location, String finalstatus) {
		super();
		
		this.hrrating = hrrating;
		this.location = location;
		this.finalstatus = finalstatus;
	}

	public HRInterviewScheduler(int interviewid, int hrrating) {
		super();
		this.interviewid = interviewid;
	
		this.hrrating = hrrating;
	}
	public HRInterviewScheduler(int interviewid, int hrrating, String location, String finalstatus
			) {
		super();
		this.interviewid = interviewid;
		this.hrrating = hrrating;
		this.location = location;
		this.finalstatus = finalstatus;
	
	}

	public HRInterviewScheduler(int interviewid, int hrrating, String location, String finalstatus,
			CandidateEntity candidateid) {
		super();
		this.interviewid = interviewid;
		this.hrrating = hrrating;
		this.location = location;
		this.finalstatus = finalstatus;
		this.candidateid = candidateid;
	}

	public HRInterviewScheduler(CandidateEntity candidateid) {
		this.candidateid = candidateid;
	}


	public HRInterviewScheduler(int interviewid2, Candidate candidate, PanelMember panelMember, String location2,
			Date date2, String start_time2, String end_time2, int hrrating2, String finalstatus2) {
		// TODO Auto-generated constructor stub
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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

	public void setHrrating(int hrrating) {
		this.hrrating = hrrating;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setFinalstatus(String finalstatus) {
		this.finalstatus = finalstatus;
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

	@Override
	public String toString() {
		return "InterviewScheduler [interviewid=" + interviewid + ", candidateid=" + candidateid + ", panelid="
				+ panelid + ", location=" + location + ", date=" + date + ", start_time=" + start_time + ", end_time="
				+ end_time + ", hrrating=" + hrrating + ", finalstatus=" + finalstatus
				+ "]";
	}

}