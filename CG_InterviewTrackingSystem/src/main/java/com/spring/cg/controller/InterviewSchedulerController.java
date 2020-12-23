package com.spring.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.spring.cg.exception.CandidateNotFoundException;
import com.spring.cg.exception.InterviewSchedulerNotFoundException;
import com.spring.cg.json.InterviewScheduler;
import com.spring.cg.service.InterviewSchedulerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin("*")
@RequestMapping("/cgits")
@Api(value="Interview Schedule related APIs")
public class InterviewSchedulerController {

	@Autowired
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
	
	
	//for creating interview
	
	@ApiOperation(value="Schedules new Interview")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="New Interview is Scheduled"),
			@ApiResponse(code=404, message="No such Interview is Schedule")
	})
	@PostMapping(value="/interviewscheduler/{candidateid}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public InterviewScheduler createNewInterviewSchedule(@PathVariable int candidateid, @RequestBody InterviewScheduler interviewscheduler)throws CandidateNotFoundException {
		return interviewschedulerService.createNewInterviewSchedule(candidateid, interviewscheduler);
	}
	
	
	
	
	
	@ApiOperation(value="Updates Interview Schedule details")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Interview Schedule is Updated"),
			@ApiResponse(code=404, message="No such Interview is Schedule")
	})
	@PutMapping(value="/interviewscheduler/{interviewid}", produces=MediaType.APPLICATION_JSON_VALUE)
	public InterviewScheduler updateInterviewSchedule(@PathVariable int interviewid, @RequestBody InterviewScheduler interviewscheduler)throws InterviewSchedulerNotFoundException
	{
		
		return interviewschedulerService. updateInterviewSchedule(interviewid, interviewscheduler);
	}
	
	
	
	
	
	@ApiOperation(value="Cancels Interview Schedule")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Scheduled Interview Canceled"),
			@ApiResponse(code=404, message="No such Interview is Schedule")
	})
	@DeleteMapping(value="//interviewschedulerdel/{interviewid}", produces=MediaType.APPLICATION_JSON_VALUE)
	public boolean cancelInterviewScheduleById(@PathVariable int interviewid)throws InterviewSchedulerNotFoundException
	{
		return interviewschedulerService.deleteById(interviewid);
	}
	
	
}