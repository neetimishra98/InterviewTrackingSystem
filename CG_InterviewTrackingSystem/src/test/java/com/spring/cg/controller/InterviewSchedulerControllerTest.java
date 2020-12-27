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
		/*@Test
		void viewInterviewMembersForTech() {
			RestTemplate restTemplate = new RestTemplate();
			Candidate candidate = restTemplate.getForObject("http://localhost:8080/cgits/interviewscheduler/tech/viewinterviewmembersfortech/30001004", Candidate.class);
			assertNotNull(candidate);

			/*
			InterviewScheduler interviewScheduler=restTemplate.getForObject
			("http://localhost:8080/cgits/interviewscheduler/tech/viewinterviewmembersfortech/30001004", InterviewScheduler.class);
			Candidate candidate=interviewScheduler.getCandidate();
			*/
			
	//	}		
		//TEST CASE TO CHECK TECHRATING BY GIVING CORRECT INTERVIEW ID - PASS
		//@Test
		//public void giveTechRating() {
			//RestTemplate restTemplate = new RestTemplate();
			//InterviewScheduler interviewScheduler=restTemplate.getForObject("http://localhost:8080/cgits/interviewscheduler/tech/30001008",InterviewScheduler.class);
			//assertNotNull(interviewScheduler.getTechrating());	

		//}
		
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
		//TEST CASE TO VIEW INTERVIEW MEMBERS BY GIVING CORRECT INTERVIEW ID - PASS
				//@Test
			/*	void viewInterviewMembersForHr() {
					RestTemplate restTemplate = new RestTemplate();
					Candidate candidate = restTemplate.getForObject("http://localhost:9090/cgits/interviewscheduler/hr/viewinterviewmembersforhr/2300000", Candidate.class);
					assertNotNull(candidate);*/

					/*
					InterviewScheduler interviewScheduler=restTemplate.getForObject
					("http://localhost:8080/cgits/interviewscheduler/tech/viewinterviewmembersforhr/30001004", InterviewScheduler.class);
					Candidate candidate=interviewScheduler.getCandidate();
					*/
					
			//	}		
				
				//TEST CASE TO CHECK HRRATING BY GIVING CORRECT INTERVIEW ID - PASS
				//@Test
   /*public void giveHrRating() {
					RestTemplate restTemplate = new RestTemplate();
					InterviewScheduler interviewScheduler=restTemplate.getForObject("http://localhost:9090/cgits/interviewscheduler/hr/6800000",InterviewScheduler.class);
					assertNotNull(interviewScheduler.getHrrating());	

				}			
				//TEST CASE TO VIEW INTERVIEW MEMBERS BY GIVING CANDIDATE ID - FAIL
				@Test
				void viewInterviewMembersForHrUsingCandidateId() {
					RestTemplate restTemplate = new RestTemplate();
					Candidate candidate = restTemplate.getForObject("http://localhost:9090/cgits/interviewscheduler/hr/viewinterviewmembersforhr/1001", Candidate.class);
					assertNotNull(candidate);
				}
					
			//TEST CASE TO CHECK HRRATING BY GIVING INTERVIEW ID AS ALL 0s - FAIL
				@Test
				public void giveHrRatingForZeros() {
					RestTemplate restTemplate = new RestTemplate();
					InterviewScheduler interviewScheduler=restTemplate.getForObject("http://localhost:9090/cgits/interviewscheduler/hr/00000000",InterviewScheduler.class);
					assertNotNull(interviewScheduler.getHrrating());	

				}	
				
				//TEST CASE TO CHECK HRRATING BY GIVING INTERVIEW ID AS A NEGATIVE NUMBER - FAIL
				@Test
				public void giveHrRatingForNegative() {
					RestTemplate restTemplate = new RestTemplate();
					InterviewScheduler interviewScheduler=restTemplate.getForObject("http://localhost:9090/cgits/interviewscheduler/hr/-2300000",InterviewScheduler.class);
					assertNotNull(interviewScheduler.getHrrating());	
				}				
				//TEST CASE TO CHECK HRRATING BY GIVING INTERVIEW ID(SIZE)- FAIL
						@Test
						public void giveHrRatingForSize() {
							RestTemplate restTemplate = new RestTemplate();
							InterviewScheduler interviewScheduler=restTemplate.getForObject("http://localhost:9090/cgits/interviewscheduler/hr/2300000045464477448",InterviewScheduler.class);
							assertNotNull(interviewScheduler.getHrrating());	
						}*/
	//TEST CASE TO GIVE RATING TO A CANDIDATE BY STATUS - PASS
      	/*@Test
	      public void giveHrRating() {
						RestTemplate restTemplate = new RestTemplate();
						InterviewScheduler interviewScheduler=restTemplate.getForObject("http://localhost:9090/cgits/interviewscheduler/hr/pending",InterviewScheduler.class);
						assertNotNull(interviewScheduler.getHrrating());	
	}*/
	
      //TEST CASE TO GIVE RATING TO A CANDIDATE BY WRONG STATUS - FAIL
     /* 	@Test
	      public void giveHrRating() {
						RestTemplate restTemplate = new RestTemplate();
						InterviewScheduler interviewScheduler=restTemplate.getForObject("http://localhost:9090/cgits/interviewscheduler/hr/notcomplete",InterviewScheduler.class);
						assertNotNull(interviewScheduler.getHrrating());	
	}*/

}
