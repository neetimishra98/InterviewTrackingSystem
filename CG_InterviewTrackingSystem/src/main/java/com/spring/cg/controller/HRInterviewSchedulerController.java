package com.spring.cg.controller;

import java.util.List;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cg.entity.CandidateEntity;
import com.spring.cg.entity.HRInterviewSchedulerEntity;
import com.spring.cg.exception.InterviewNotFoundException;
import com.spring.cg.exception.InterviewSchedulerNotFoundException;
import com.spring.cg.exception.PanelMemberNotFoundException;
import com.spring.cg.json.HRInterviewScheduler;
import com.spring.cg.service.HRInterviewSchedulerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin("*")
@RequestMapping("/cgits")

@Api(value = "HRInterviewScheduler related REST APIs")
public class HRInterviewSchedulerController {
	
	private static Logger logger = LoggerFactory.getLogger(HRInterviewSchedulerController.class);

	@Autowired
	private HRInterviewSchedulerService hrinterviewSchedulerService;
	


	
	@ApiOperation(value = "Schedules new Interview for hr")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "New Interview is Scheduled"),
			@ApiResponse(code = 404, message = "No such Interview is Schedule") })
	@PostMapping(value = "/hrinterviewscheduler/{candidateid}/{panelid}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HRInterviewScheduler createNewHRInterviewSchedule(@PathVariable int candidateid, @PathVariable int panelid,
			@RequestBody HRInterviewScheduler hrinterviewscheduler)
			throws PanelMemberNotFoundException {
		return hrinterviewSchedulerService.createNewHRInterviewSchedule(candidateid, panelid, hrinterviewscheduler);
	}

	//Update Interview Schedule
		@ApiOperation(value="Updates Interview Schedule details")
		@ApiResponses(value= {
				@ApiResponse(code=201, message="Interview Schedule is Updated"),
				@ApiResponse(code=404, message="No such Interview is Schedule")
		})
		@PutMapping(value="/hrinterviewscheduler/{interviewid}", produces=MediaType.APPLICATION_JSON_VALUE)
		public HRInterviewScheduler updateInterviewSchedule(@Valid @PathVariable int interviewid, @RequestBody HRInterviewScheduler hrinterviewscheduler)throws InterviewSchedulerNotFoundException
		{
			try {
				logger.info("Enter HRInterviewSchedulerController:: method=updateScheduleInterview");
				return hrinterviewSchedulerService.updateInterviewSchedule(interviewid, hrinterviewscheduler);
			} catch(InterviewSchedulerNotFoundException interviewSchedulerNotFoundException) {
				logger.error(interviewSchedulerNotFoundException.getLocalizedMessage());
				return null;
			}
			
		}
		
		
		//Cancel Interview Schedule
		  @ApiOperation(value="Cancels Interview Schedule")
		  @ApiResponses(value= {
			  @ApiResponse(code=201, message="Scheduled Interview Canceled"),
			  @ApiResponse(code=404, message="No such Interview is Schedule")})
			   
				@DeleteMapping(value="//hrinterviewschedulerdel/{interviewid}", produces=MediaType.APPLICATION_JSON_VALUE)
				public HRInterviewScheduler cancelInterviewScheduleById(@PathVariable int interviewid)throws InterviewSchedulerNotFoundException
				{
			  try {
					logger.info("Enter HRInterviewSchedulerController:: method=cancelScheduleInterview");
					return hrinterviewSchedulerService.deleteById(interviewid);
				}catch(InterviewSchedulerNotFoundException interviewSchedulerNotFoundException) {
					logger.error(interviewSchedulerNotFoundException.getLocalizedMessage());
					return null;
					}
					}


		 //RETURNS ALL IntERVIEW MEMBERS FROM THE DATABASE
	    @ApiOperation(value="Returns all  interviewmembers")
	    @ApiResponses(value= {
	            @ApiResponse(code=201, message="Interview members have been found"),
	            @ApiResponse(code=404, message = "No interview members found")
	    })
	    @GetMapping(value="/interviewmembers", produces= MediaType.APPLICATION_JSON_VALUE)
	    public List<HRInterviewScheduler> getAllInterviewMembers() {
	        return hrinterviewSchedulerService.getAllInterviewMembershr();
	    }
	    

		//Gives hrRating to the candidate if hrRating is null
			@ApiOperation(value="Returns hrInterviewSchedulerEntity after giving HrRating")
			@ApiResponses(value= {
					@ApiResponse(code=200, message="HrRating given successfully"),
					@ApiResponse(code=404, message = "No such candidate found with given interviewid")
			})
			@GetMapping(value="/interviewscheduler/{interviewid}", produces=MediaType.APPLICATION_JSON_VALUE)
			public HRInterviewSchedulerEntity giveHrRating(@PathVariable("interviewid")int interviewid) throws InterviewSchedulerNotFoundException{
				return hrinterviewSchedulerService.giveHrRating(interviewid);
			}
			
			
			
			//view Interview members for hr using interview id
			@ApiOperation(value="Returns all InterviewMembers")
			@ApiResponses(value= {
					@ApiResponse(code=200, message="Candidate with given interviewid displayed successfully"),
					@ApiResponse(code=404, message = "No such candidate found")
			})
			@GetMapping(value = "/interviewscheduler/hr/{interviewid}",produces = MediaType.APPLICATION_JSON_VALUE)
			public CandidateEntity  viewInterviewMembersbyHr(@Valid @PathVariable("interviewid")int interviewid) throws InterviewSchedulerNotFoundException {
				return hrinterviewSchedulerService.viewInterviewMembersbyHr(interviewid);
			}
	  
			/*
			//SCHARE AND SCHEDULE FOR HR INTERVIEW 
			  @ApiOperation(value = "Schedules new Interview for hr")
			  @ApiResponses(value = { @ApiResponse(code = 201, message = "New Interview is Scheduled"),
			      @ApiResponse(code = 404, message = "No such Interview is Schedule") })
			  @PostMapping(value = "/hrinterviewscheduler/{candidateid}/{panelid}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
			  public HRInterviewScheduler createNewHRInterviewSchedule1(@PathVariable int candidateid, @PathVariable int panelid,
			      @RequestBody HRInterviewScheduler hrinterviewscheduler)
			      throws PanelMemberNotFoundException {
			    return hrinterviewSchedulerService.createNewHRInterviewSchedule(candidateid, panelid, hrinterviewscheduler);
			  }*/
	  }
	
