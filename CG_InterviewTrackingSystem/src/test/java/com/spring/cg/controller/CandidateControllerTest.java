package com.spring.cg.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import com.spring.cg.json.Candidate;

public class CandidateControllerTest {
	
	@Test
	public void testFindCandidateById() {
		RestTemplate restTemplate = new RestTemplate();
		Candidate candidate=restTemplate.getForObject("http://localhost:8080/cgits/candidate/15", Candidate.class);
		assertNotNull(candidate);
	}
	
	//TEST CASE TO VIEW A CANDIDATE FOR HR USING CANDIDATE ID - PASS
	@Test
	public void testFindCandidateByIdHr() {
		RestTemplate restTemplate = new RestTemplate();
		Candidate candidate=restTemplate.getForObject("http://localhost:8080/cgits/candidate/hr/15", Candidate.class);
		assertNotNull(candidate);
	}

}
