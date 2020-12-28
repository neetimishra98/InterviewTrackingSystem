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

import com.spring.cg.entity.InterviewSchedulerEntity;
import com.spring.cg.exception.CandidateNotFoundException;
import com.spring.cg.exception.InterviewNotFoundException;
import com.spring.cg.exception.InterviewSchedulerNotFoundException;
import com.spring.cg.json.Candidate;
import com.spring.cg.json.InterviewScheduler;
import com.spring.cg.service.CandidateService;
import com.spring.cg.service.InterviewSchedulerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@CrossOrigin("*")
@RequestMapping("/cgits")

@Api(value="InterviewScheduler related REST APIs")
public class InterviewSchedulerController {
	
	private static Logger logger = LoggerFactory.getLogger(InterviewSchedulerController.class);
	
	@Autowired
	private InterviewSchedulerService interviewSchedulerService;
	
	@Autowired
	private CandidateService candidateService;
	
	
		@ApiOperation(value="Schedules new Interview")
		@ApiResponses(value= {
				@ApiResponse(code=201, message="New Interview is Scheduled"),
				@ApiResponse(code=404, message="No such Interview is Schedule")
		})
		@PostMapping(value="/interviewscheduler/{candidateid}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
		public InterviewScheduler createNewInterviewSchedule(@PathVariable int candidateid, @RequestBody InterviewScheduler interviewscheduler)throws CandidateNotFoundException {
			return interviewSchedulerService.createNewInterviewSchedule(candidateid, interviewscheduler);
		}
	
		
		
		//Update Interview Schedule
				@ApiOperation(value="Updates Interview Schedule details")
				@ApiResponses(value= {
						@ApiResponse(code=201, message="Interview Schedule is Updated"),
						@ApiResponse(code=404, message="No such Interview is Schedule")
				})
				@PutMapping(value="/interviewscheduler/{interviewid}", produces=MediaType.APPLICATION_JSON_VALUE)
				public InterviewScheduler updateInterviewSchedule(@Valid @PathVariable int interviewid, @RequestBody InterviewScheduler interviewscheduler)throws InterviewSchedulerNotFoundException
				{
					try {
						logger.info("Enter InterviewSchedulerController:: method=updateScheduleInterview");
						return interviewSchedulerService. updateInterviewSchedule(interviewid, interviewscheduler);
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
		   
			@DeleteMapping(value="//interviewschedulerdel/{interviewid}", produces=MediaType.APPLICATION_JSON_VALUE)
			public InterviewScheduler cancelInterviewScheduleById(@PathVariable int interviewid)throws InterviewSchedulerNotFoundException
			{
				try {
					logger.info("Enter InterviewSchedulerController:: method=cancelScheduleInterview");
					return interviewSchedulerService.deleteById(interviewid);
				}catch(InterviewSchedulerNotFoundException interviewSchedulerNotFoundException) {
					logger.error(interviewSchedulerNotFoundException.getLocalizedMessage());
					return null;
					}
				}
	
	
	//Gives TechRating to the candidate if TechRating is null
	@ApiOperation(value="Returns InterviewSchedulerEntity after giving TechRating")
	@ApiResponses(value= {
			@ApiResponse(code=200, message="TechRating given successfully"),
			@ApiResponse(code=404, message = "No such candidate found with given interviewid")
	})
	@GetMapping(value="/interviewscheduler/tech/{interviewid}", produces=MediaType.APPLICATION_JSON_VALUE)
	public InterviewSchedulerEntity giveTechRating(@PathVariable("interviewid")int interviewid) throws InterviewNotFoundException{
		return interviewSchedulerService.giveTechRating(interviewid);
	}
	
	//Gives hrRating to the candidate if hrRating is null
	@ApiOperation(value="Returns InterviewSchedulerEntity after giving HrRating")
	@ApiResponses(value= {
			@ApiResponse(code=200, message="HrRating given successfully"),
			@ApiResponse(code=404, message = "No such candidate found with given interviewid")
	})
	@GetMapping(value="/interviewscheduler/hr/{interviewid}", produces=MediaType.APPLICATION_JSON_VALUE)
	public InterviewSchedulerEntity giveHrRating(@PathVariable("interviewid")int interviewid) throws InterviewNotFoundException{
		return interviewSchedulerService.giveHrRating(interviewid);
	}
	/*@Autowired
	private InterviewSchedulerService interviewschedulerService;
	
	
	/*
	@ApiOperation(value="Returns all interviewschedule details")
	@ApiResponses(value= {
			@ApiResponse(code=404, message="No such Interview is Schedule")
	})
	@GetMapping(value="/interviewscheduler", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<InterviewScheduler> getAllInterviewSchedule() {
		return interviewschedulerService.getAllInterviewSchedule();
	}
	*/
	
	
	//to view interview members
	@ApiOperation(value="Returns all InterviewMembers")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="New candidate created"),
			@ApiResponse(code=404, message = "No such candidate found")
	})
	@GetMapping(value = "/interviewscheduler/viewallmembers",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Candidate> viewInterviewMembers() {
		return candidateService.viewAllCandidates();
	}
	
	//to view interview members
	@ApiOperation(value="Returns all InterviewMembers")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="New candidate created"),
			@ApiResponse(code=404, message = "No such candidate found")
	})
	@GetMapping(value = "/interviewscheduler/Hr/viewallmembers",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Candidate> viewInterviewMembersbyHr() {
		return candidateService.viewAllCandidates();
	}

	
}