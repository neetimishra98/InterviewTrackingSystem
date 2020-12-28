package com.spring.cg.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import com.spring.cg.json.Candidate;
import com.spring.cg.json.InterviewScheduler;

class InterviewSchedulerControllerTest {
	public Candidate candidateInvalid;

	//TEST CASE TO VIEW INTERVIEW MEMBERS BY GIVING CORRECT INTERVIEW ID - PASS
		@Test
		void viewInterviewMembersForTech() {
			RestTemplate restTemplate = new RestTemplate();
			Candidate candidate = restTemplate.getForObject("http://localhost:8080/cgits/interviewscheduler/tech/viewinterviewmembersfortech/30001004", Candidate.class);
			assertNotNull(candidate);						
		}		
		//TEST CASE TO CHECK TECHRATING BY GIVING CORRECT INTERVIEW ID - PASS
		@Test
		public void giveTechRating() {
			RestTemplate restTemplate = new RestTemplate();
			InterviewScheduler interviewScheduler=restTemplate.getForObject("http://localhost:8080/cgits/interviewscheduler/tech/30001008",InterviewScheduler.class);
			assertNotNull(interviewScheduler.getTechrating());	

		}	
		
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

	
  //Candidate With The <<Blank>> Path Variable as URL to localhost : Invalid Testcase
	@Test
	public void testviewInterviewMembersForTechByBlank() {
		RestTemplate restTemplate = new RestTemplate();
		//Candidate With The <<Blank>> Path Variable as URL to localhost : Invalid Testcase
		try {
			candidateInvalid = restTemplate.getForObject("http://localhost:8080/cgits/interviewscheduler/tech/", Candidate.class);
		}
		catch(Exception e){
			candidateInvalid = null;
		}
		finally{
			assertNotNull(candidateInvalid, "<<BLANK>> Was Not Found");
		}
	}
	
		//TEST CASE TO VIEW INTERVIEW MEMBERS BY GIVING CORRECT INTERVIEW ID - PASS
				@Test
				public void testviewInterviewMembersForHr() {
					RestTemplate restTemplate = new RestTemplate();
					Candidate candidate = restTemplate.getForObject("http://localhost:9090/cgits/interviewscheduler/hr/viewinterviewmembersforhr/2300000", Candidate.class);
					assertNotNull(candidate);
					}		
				
				
				//TEST CASE TO VIEW INTERVIEW MEMBERS BY GIVING CANDIDATE ID - FAIL
				@Test
				void testviewInterviewMembersbyCandidateId() {
					RestTemplate restTemplate = new RestTemplate();
					Candidate candidate = restTemplate.getForObject("http://localhost:9090/cgits/interviewscheduler/hr/viewinterviewmembersforhr/1001", Candidate.class);
					assertNotNull(candidate);
				}
			
			
      	
     
     	
	
    //Candidate With The <<Blank>> Path Variable as URL to localhost : Invalid Testcase
	@Test
	public void testInterviewMembersByBlank() {
		RestTemplate restTemplate = new RestTemplate();
		try {
			candidateInvalid = restTemplate.getForObject("http://localhost:9090/cgits/interviewscheduler/hr/viewinterviewmembersforhr/", Candidate.class);
		}
		catch(Exception e){
			candidateInvalid = null;
		}
		finally{
			assertNotNull(candidateInvalid, "<<BLANK>> Was Not Found");
		}
	}
}


/*InterviewScheduler interviewScheduler=restTemplate.getForObject
("http://localhost:8080/cgits/interviewscheduler/tech/viewinterviewmembersfortech/30001004", InterviewScheduler.class);
Candidate candidate=interviewScheduler.getCandidate();*/
