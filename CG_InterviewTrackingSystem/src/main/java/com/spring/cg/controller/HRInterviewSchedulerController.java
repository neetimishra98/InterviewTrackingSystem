package com.spring.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	
}
