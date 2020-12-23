package com.spring.cg.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import org.springframework.web.client.RestTemplate;

import com.spring.cg.json.Candidate;

class InterviewSchedulerControllerTest {

	@Test
	void viewInterviewMembers() {
		RestTemplate restTemplate = new RestTemplate();
		Candidate candidate = restTemplate.getForObject("http://localhost:8080/cgits/interviewscheduler/viewallmembers", Candidate.class);
		assertNotNull(candidate);
		
	}

}
