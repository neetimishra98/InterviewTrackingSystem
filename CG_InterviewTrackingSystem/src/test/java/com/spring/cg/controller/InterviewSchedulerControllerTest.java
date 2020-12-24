package com.spring.cg.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import org.springframework.web.client.RestTemplate;

import com.spring.cg.json.Candidate;
import com.spring.cg.json.InterviewScheduler;

class InterviewSchedulerControllerTest {

	@Test
	public void giveTechRating() {
		RestTemplate restTemplate = new RestTemplate();
		InterviewScheduler interviewScheduler=restTemplate.getForObject("http://localhost:8080/cgits/interviewscheduler/tech/30001002",InterviewScheduler.class);
		assertNotNull(interviewScheduler);

	}
	
	
	
	
	@Test
	void viewInterviewMembers() {
		RestTemplate restTemplate = new RestTemplate();
		List<Candidate> candidate = (List<Candidate>) restTemplate.getForObject("http://localhost:8080/cgits/interviewscheduler/viewallmembers", Candidate.class);
		assertNotNull(candidate);
		
	}
	

}
