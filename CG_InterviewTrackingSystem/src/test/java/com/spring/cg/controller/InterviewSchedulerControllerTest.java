package com.spring.cg.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.spring.cg.json.Candidate;
import com.spring.cg.json.InterviewScheduler;

class InterviewSchedulerControllerTest {
	
	
	
	//TEST CASE TO VIEW INTERVIEW MEMBERS BY GIVING CORRECT INTERVIEW ID - PASS
		@Test
		void viewInterviewMembersForTech() {
			RestTemplate restTemplate = new RestTemplate();
			Candidate candidate = restTemplate.getForObject("http://localhost:8080/cgits/interviewscheduler/tech/viewinterviewmembersfortech/30001004", Candidate.class);
			assertNotNull(candidate);

			/*
			InterviewScheduler interviewScheduler=restTemplate.getForObject
			("http://localhost:8080/cgits/interviewscheduler/tech/viewinterviewmembersfortech/30001004", InterviewScheduler.class);
			Candidate candidate=interviewScheduler.getCandidate();
			*/
			
		}
		
		
		//TEST CASE TO CHECK TECHRATING BY GIVING CORRECT INTERVIEW ID - PASS
		@Test
		public void giveTechRating() {
			RestTemplate restTemplate = new RestTemplate();
			InterviewScheduler interviewScheduler=restTemplate.getForObject("http://localhost:8080/cgits/interviewscheduler/tech/30001008",InterviewScheduler.class);
			assertNotNull(interviewScheduler.getTechrating());	

		}
		
	/*	
		
		//TEST CASE TO VIEW INTERVIEW MEMBERS BY GIVING CANDIDATE ID - FAIL
		@Test
		void viewInterviewMembersForTechUsingCandidateId() {
			RestTemplate restTemplate = new RestTemplate();
			Candidate candidate = restTemplate.getForObject("http://localhost:8080/cgits/interviewscheduler/tech/viewinterviewmembersfortech/20001004", Candidate.class);
			assertNotNull(candidate);
		}
		
	
	//TEST CASE TO CHECK TECHRATING BY GIVING INTERVIEW ID AS ALL 0s - FAIL
		@Test
		public void giveTechRatingForZeros() {
			RestTemplate restTemplate = new RestTemplate();
			InterviewScheduler interviewScheduler=restTemplate.getForObject("http://localhost:8080/cgits/interviewscheduler/tech/00000000",InterviewScheduler.class);
			assertNotNull(interviewScheduler.getTechrating());	

		}	
		
		//TEST CASE TO CHECK TECHRATING BY GIVING INTERVIEW ID AS A NEGATIVE NUMBER - FAIL
		@Test
		public void giveTechRatingForNegative() {
			RestTemplate restTemplate = new RestTemplate();
			InterviewScheduler interviewScheduler=restTemplate.getForObject("http://localhost:8080/cgits/interviewscheduler/tech/-30001008",InterviewScheduler.class);
			assertNotNull(interviewScheduler.getTechrating());	
		}
		
		//TEST CASE TO CHECK TECHRATING BY GIVING INTERVIEW ID(SIZE)- FAIL
				@Test
				public void giveTechRatingForSize() {
					RestTemplate restTemplate = new RestTemplate();
					InterviewScheduler interviewScheduler=restTemplate.getForObject("http://localhost:8080/cgits/interviewscheduler/tech/3005555550001008",InterviewScheduler.class);
					assertNotNull(interviewScheduler.getTechrating());	
				}
		*/
}
