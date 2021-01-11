package com.spring.cg.controller;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.spring.cg.json.Candidate;
import com.spring.cg.json.InterviewScheduler;

class InterviewSchedulerControllerTest {

		
		private static Logger logger = LogManager.getLogger(InterviewSchedulerControllerTest.class);
		
		public Candidate candidateInvalid;
		
		public InterviewScheduler interviewschedulerInvalid;
/*
		//TEST CASE TO VIEW ALL INTERVIEW MEMBERS
		@Test
		public void testViewAllInterviewMembersForTech(){
			logger.info("[START] testViewAllInterviewMembersForTech()");
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<InterviewScheduler[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/cgits/interviewscheduler/tech",
					InterviewScheduler[].class);
			assertNotNull(responseEntity);
			logger.info("All Interview members viewed successfully!");
	       logger.info("[END] testViewAllInterviewMembersForTech()");
		
		}
		
		

		//TEST CASE TO VIEW INTERVIEW MEMBERS BY GIVING CORRECT INTERVIEW ID - PASS
			@Test
			public void testViewInterviewMembersForTech() {
				logger.info("[START] testViewInterviewMembersForTech()");
				RestTemplate restTemplate = new RestTemplate();
				Candidate candidate = restTemplate.getForObject("http://localhost:8080/cgits/interviewscheduler/tech/30001001", Candidate.class);
				assertNotNull(candidate);	
				logger.info("Interview member for tech viewed successfully with given interviewid 30001001");
				logger.info("[END] testViewInterviewMembersForTech()");
			}		
			

			
			//TEST CASE TO VIEW INTERVIEW MEMBERS BY GIVING CANDIDATE ID - FAIL
			@Test
			void testViewInterviewMembersForTechUsingCandidateId() {
				logger.info("[START] testViewInterviewMembersForTechUsingCandidateId()");
				RestTemplate restTemplate = new RestTemplate();
				assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
						()->{
							restTemplate.getForObject("http://localhost:8080/cgits/interviewscheduler/tech/20001002", InterviewScheduler[].class);
						});
				logger.error("Data for interview id: 20001002 does not exists as 20001002 is candidateid ");	
				logger.info("[END] testViewInterviewMembersForTechUsingCandidateId()");

			}
				
			
			
			//TEST CASE TO CHECK TECHRATING BY GIVING CORRECT INTERVIEW ID - PASS
					@Test
					public void testGiveTechRating() {
						logger.info("[START] testGiveTechRating()");
						RestTemplate restTemplate = new RestTemplate();
						InterviewScheduler interviewScheduler=restTemplate.getForObject("http://localhost:8080/cgits/interviewscheduler/tech/rating/30001007",InterviewScheduler.class);
						assertNotNull(interviewScheduler.getTechrating());	
						logger.info("TechRating given successfully for interviewid 30001007");
						logger.info("[END] testGiveTechRating()");

					}	
					
		
		//TEST CASE TO CHECK TECHRATING BY GIVING INTERVIEW ID AS ALL 0s - FAIL
			@Test
			public void testGiveTechRatingForZeros() {
				logger.info("[START] testGiveTechRatingForZeros()");
				RestTemplate restTemplate = new RestTemplate();
				assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
						()->{
							restTemplate.getForObject("http://localhost:8080/cgits/interviewscheduler/tech/rating/00000000",InterviewScheduler[].class);
						});		
				logger.error("Data for interview id: 00000000 does not exists, interview id cannot be 0 ");	
				logger.info("[END] testGiveTechRatingForZeros()");

			}	
			
			//TEST CASE TO CHECK TECHRATING BY GIVING INTERVIEW ID AS A NEGATIVE NUMBER - FAIL
			@Test
			public void testGiveTechRatingForNegative() {
				logger.info("[START] testGiveTechRatingForNegative()");
				RestTemplate restTemplate = new RestTemplate();
					assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
					()->{
						restTemplate.getForEntity("http://localhost:8080/cgits/interviewscheduler/tech/rating/-30001001",InterviewScheduler[].class);
				});
				logger.error("Data for interview id: -30001001 does not exists, interview id cannot be negative ");
				logger.info("[END] testGiveTechRatingForNegative()");
			}
			

			
			
			
			//TEST CASE TO CHECK TECHRATING BY GIVING INTERVIEW ID(SIZE)- FAIL
					@Test
					public void testGiveTechRatingForSize() {
						logger.info("[START] testGiveTechRatingForSize()");
						RestTemplate restTemplate = new RestTemplate();
						assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
								()->{
									restTemplate.getForObject("http://localhost:8080/cgits/interviewscheduler/tech/rating/3005555550001008",InterviewScheduler[].class);
								});			
						logger.error("Data for interview id: 3005555550001008 does not exists, interviewid size cannot be greater than 8 digits ");
						logger.info("[END] testGiveTechRatingForSize()");
					}
					
					
				
					
					//--------TEST CASE TO CHECK TECHRATING FIELD------//
					
					//TEST CASE TO CHECK TECHRATING FIELD (NEGATIVE RATING)- FAIL
					@Test
					public void testGiveTechRatingFieldForNegative() {
						logger.info("[START] testGiveTechRatingFieldForNegative()");
						RestTemplate restTemplate = new RestTemplate();
						InterviewScheduler interviewScheduler=restTemplate.getForObject("http://localhost:8080/cgits/interviewscheduler/tech/rating/30001001",InterviewScheduler.class);
						assertEquals(interviewScheduler.getTechrating(),-3);
						logger.error("Tech rating field cannot be negative ");
						logger.info("[END] testGiveTechRatingFieldForNegative()");

					}	
					
			
			
					
					//TEST CASE TO CHECK TECHRATING FIELD (CHARACTER RATING)- FAIL
					@Test
					public void giveTechRatingFieldForCharacter() {
						logger.info("[START] giveTechRatingFieldForCharacter()");
						RestTemplate restTemplate = new RestTemplate();
						String a="a";
						InterviewScheduler interviewScheduler=restTemplate.getForObject("http://localhost:8080/cgits/interviewscheduler/tech/rating/30001001",InterviewScheduler.class);	
						assertEquals(interviewScheduler.getTechrating(),a);
						logger.error("Tech rating field cannot have character and should be of int type only ");
						logger.info("[END] giveTechRatingFieldForCharacter()");

					}	
					
					
					//TEST CASE TO CHECK TECHRATING FIELD (ZERO RATING)- FAIL
					@Test
					public void giveTechRatingFieldForZero() {
						logger.info("[START] giveTechRatingFieldForZero()");
						RestTemplate restTemplate = new RestTemplate();
						InterviewScheduler interviewScheduler=restTemplate.getForObject("http://localhost:8080/cgits/interviewscheduler/tech/rating/30001001",InterviewScheduler.class);
						assertEquals(interviewScheduler.getTechrating(),0);
						logger.error("Tech rating field cannot be zero ");
						logger.info("[END] giveTechRatingFieldForZero()");

					}	
					
					
					//TEST CASE TO CHECK TECHRATING FIELD (SPECIAL CHARACTER RATING)- FAIL
					@Test
					public void giveTechRatingFieldForSpecialCharacter() {
						logger.info("[START] giveTechRatingFieldForSpecialCharacter()");
						RestTemplate restTemplate = new RestTemplate();
						String a="@";
						InterviewScheduler interviewScheduler=restTemplate.getForObject("http://localhost:8080/cgits/interviewscheduler/tech/rating/30001001",InterviewScheduler.class);
						assertEquals(interviewScheduler.getTechrating(),a);
						logger.error("Tech rating field cannot have special character and should be of int type only ");
						logger.info("[END] giveTechRatingFieldForSpecialCharacter()");
						
					}	
					
		*/			
					
	}