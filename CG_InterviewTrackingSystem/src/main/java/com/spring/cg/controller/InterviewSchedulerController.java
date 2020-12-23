package com.spring.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cg.entity.InterviewSchedulerEntity;
import com.spring.cg.exception.InterviewNotFoundException;
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
	@Autowired
	private InterviewSchedulerService interviewSchedulerService;
	
	
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
<<<<<<< HEAD
	@GetMapping(value="/interviewscheduler/hr/{interviewid}", produces=MediaType.APPLICATION_JSON_VALUE)
	public InterviewSchedulerEntity giveHrRating(@PathVariable("interviewid")int interviewid) throws InterviewNotFoundException{
		return interviewSchedulerService.giveHrRating(interviewid);
=======
	@GetMapping(value="/interviewscheduler/hr/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public InterviewSchedulerEntity giveHrRating(@PathVariable("id")int id) throws InterviewNotFoundException{
		return interviewSchedulerService.giveHrRating(id);
>>>>>>> ffc2e5a1982e98e233dd82055d3683a7bf3ad8e5
	}
}
