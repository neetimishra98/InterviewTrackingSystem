package com.spring.cg.controller;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.spring.cg.exception.CandidateNotFoundException;
import com.spring.cg.exception.InterviewNotFoundException;
import com.spring.cg.json.Candidate;
import com.spring.cg.json.HRInterviewScheduler;
import com.spring.cg.json.InterviewScheduler;
import com.spring.cg.service.HRInterviewSchedulerService;
import org.springframework.boot.test.context.SpringBootTest;



class HRInterviewSchedulerControllerTest {

	
		public Candidate candidateInvalid;
		public HRInterviewScheduler interviewschedulerInvalid;
		public InterviewScheduler InterviewschedulerInvalid;

		
		@Autowired
		private HRInterviewSchedulerService hrinterviewschedulerservice;
		private static Logger logger = LogManager.getLogger(HRInterviewSchedulerControllerTest.class);
		
		
		//TEST CASE TO VIEW LIST Of All INTERVIEW MEMBERS 
		// VALID TESTCASE
		@Test
		public void testgetAllInterviewMembershr(){
			logger.info("[START] testgetAllInterviewMembershr()");
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity <HRInterviewScheduler[]> responseEntity = restTemplate.getForEntity("http://localhost:9090/cgits/interviewmembers", HRInterviewScheduler[].class);
			assertNotNull(responseEntity);
			logger.info("[END] testgetAllInterviewMembershr()");
		}
			
			
		//TEST CASE TO VIEW INTERVIEW MEMBERS BY GIVING CORRECT INTERVIEW ID
	    // Interview id with 63000000 exist VALID TESTCASE
				@Test
				public void testviewInterviewMembersForHr() {
					logger.info("[START] testviewInterviewMembersForHr()");
					RestTemplate restTemplate = new RestTemplate();
					Candidate candidate = restTemplate.getForObject("http://localhost:9090/cgits/interviewscheduler/hr/63000000", Candidate.class);
					assertNotNull(candidate);
					logger.info("[END] testviewInterviewMembersForHr()");
					}
				
				/*		
				//Test Case for viewing InterviewMembers By details by specific Id - FAIL
				@Test
				public void  testgiveHrRatingForNegativeId() {
					
					logger.info("[START] testgiveHrRatingForNegativeId()");
					RestTemplate restTemplate = new RestTemplate();
					
					assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
					()->{
		 restTemplate.getForEntity("http://localhost:9090/cgits/interviewscheduler/-30001008", HRInterviewScheduler[].class);
					});
					
					logger.error("Data for interviewId : -30001008  does not exists, interviewidId cannot be negative.");
					logger.info("[END] testgiveHrRatingForNegativeId()");
			    }*/

				
				
				//TEST CASE TO GIVE RATING TO NEGATIVE INTERVIEW ID - FAIL
				@Test
				public void testViewCandidateByIdForHRFail_IntervieweNotFoundException(){
					    logger.info("[START] testgiveHrRatingById()");		
						RestTemplate restTemplate = new RestTemplate();
						assertThrows(InterviewNotFoundException.class,
						()->{
							hrinterviewschedulerservice.giveHrRating(-6700000);
						}	
					);
						logger.info("[END] testgiveHrRatingById())");
				}

				
				
				//TEST CASE TO CHECK HRRATING BY GIVING INTERVIEW ID(SIZE)- FAIL
				@Test
				public void  testRatingForsize() {
					
					logger.info("[START] testRatingForsize()");
					RestTemplate restTemplate = new RestTemplate();
					
					assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
					()->{
						 restTemplate.getForEntity("http://localhost:9090/cgits/interviewscheduler/30001008888888887555", HRInterviewScheduler.class);
					});
					
					logger.error("Data for interviewId : 3000010008888888888888875555555555  does not exists, interviewidId cannot be more than 8.");
					logger.info("[END] testRatingForsize()");
			    }		
				
					
				//TEST CASE TO CHECK HRRATING FIELD (CHARACTER RATING)- FAIL
				@Test
					public void testRatingFieldForSpecialCharacter() {
						RestTemplate restTemplate = new RestTemplate();
						String a = "a";
						HRInterviewScheduler hrinterviewScheduler = restTemplate.getForObject("http://localhost:9090/cgits/interviewscheduler/2300000", HRInterviewScheduler.class);	
						assertEquals(hrinterviewScheduler.getHrrating(),a);
					}
				
					
			// Test case to check candidate by entering WRONG URL.
					@Test
					public void testFindCandidateByInvalidURL() {
						logger.info("[START] testFindCandidateByInvalidURL()");
						
						RestTemplate restTemplate = new RestTemplate();
						//Candidate With The interviewid 2300000  Exists. Mistyped 23000RT : Invalid Testcase
						try {
							InterviewschedulerInvalid = restTemplate.getForObject("http://localhost:9090/interviews/interviewscheduler/2300RT00UYTR", InterviewScheduler.class);
						}
						catch(Exception e){
							InterviewschedulerInvalid = null;
							logger.error("testFindCandidateByInvalidURL(), Wrong URL Is Entered");
						}
						finally{
							assertNull(InterviewschedulerInvalid, "2300RT00UYTR Was Not Found");
						}
						logger.info("[END] testFindCandidateByInvalidURL()");
					}
					
					
					//TEST CASE TO CHECK HRRATING FIELD (NEGATIVE RATING)- FAIL
			
					public void testgiveHrRatingFieldForNegative() {
						logger.info("[START] testgiveHrRatingFieldForNegative()");
						RestTemplate restTemplate = new RestTemplate();
						HRInterviewScheduler interviewScheduler=restTemplate.getForObject("http://localhost:9090/cgits/interviewscheduler/67000000",HRInterviewScheduler.class);
						assertEquals(interviewScheduler.getHrrating(),-5);
						logger.info("[END] testgiveHrRatingFieldForNegative()");

					}	
					

					//TEST CASE TO CHECK HRRATING FIELD (ZERO RATING)- FAIL
					@Test
					public void giveHrRatingFieldForZero() {
						logger.info("[START] giveHrRatingFieldForZero()");
						RestTemplate restTemplate = new RestTemplate();
						HRInterviewScheduler hrinterviewScheduler=restTemplate.getForObject("http://localhost:9090/cgits/interviewscheduler/67000000",HRInterviewScheduler.class);
						assertEquals(hrinterviewScheduler.getHrrating(),0);
						logger.info("[END] giveTechRatingFieldForZero()");
					}
					
					
					
	       //Candidate With The <<Blank>> Path Variable as URL to localhost : Invalid Testcase
		     @Test
		       public void testInterviewMembersByBlank() {
			RestTemplate restTemplate = new RestTemplate();
			try {
				candidateInvalid = restTemplate.getForObject("http://localhost:9090/cgits/interviewscheduler/hr/", Candidate.class);
			}
			catch(Exception e){
				candidateInvalid = null;
			}
			finally{
				assertNotNull(candidateInvalid, "<<BLANK>> Was Not Found");
			}
		}
	}




