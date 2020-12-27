package com.spring.cg.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import com.spring.cg.json.Candidate;

public class CandidateControllerTest {
	
	public Candidate candidateInvalid;
	
	@Test
	public void testFindCandidateById() {
		RestTemplate restTemplate = new RestTemplate();
		Candidate candidate=restTemplate.getForObject("http://localhost:9091/cgits/candidate/12345678", Candidate.class);
		assertNotNull(candidate);
	}
	
	//TEST CASE TO VIEW A CANDIDATE FOR HR USING CANDIDATE ID - PASS
	@Test
	public void testFindCandidateByIdHr() {
		RestTemplate restTemplate = new RestTemplate();
		Candidate candidate=restTemplate.getForObject("http://localhost:9091/cgits/candidate/hr/12345678", Candidate.class);
		assertEquals(candidate.getCandidateid(), 12345678);
	}

	//TEST CASE TO VIEW A CANDIDATE FOR HR USING <<BLANK>> PATH VARIABLE - FAIL
	@Test
	public void testFindCandidateByBlank() {
		RestTemplate restTemplate = new RestTemplate();
		try {
			candidateInvalid = restTemplate.getForObject("http://localhost:9091/cgits/candidate/hr/", Candidate.class);
		}
		catch(Exception e){
			candidateInvalid = null;
		}
		finally{
			assertNotNull(candidateInvalid, "<<BLANK>> Was Not Found");
		}
	}
}
