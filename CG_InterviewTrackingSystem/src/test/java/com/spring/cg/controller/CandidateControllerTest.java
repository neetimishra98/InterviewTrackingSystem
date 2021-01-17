package com.spring.cg.controller;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.client.RestTemplate;

import com.spring.cg.exception.CandidateNotFoundException;
import com.spring.cg.json.Candidate;
import com.spring.cg.repo.CandidateRepo;
import com.spring.cg.service.CandidateService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;



public class CandidateControllerTest {
	
	private static Logger logger = LogManager.getLogger(CandidateControllerTest.class);
	
	public Candidate candidateInvalid;
	
	@Autowired
	private CandidateRepo candidateRepo;
	
	@Autowired
	private CandidateService candidateService;
	
	
	// Test Case for adding Candidate Details -PASS
	@Test
	public void testAddCandidateSuccess()
	{
		logger.info("[START] testAddCandidate()");
		RestTemplate restTemplate = new RestTemplate();
		Candidate candidate = new Candidate("Pooja", "Ahemdabad", "BE Electronics", "Junior Analyst", 3, "C", "C++", 2);
		ResponseEntity<Candidate> responseEntityCandidate = restTemplate.postForEntity("http://localhost:9090/cgits/candidate", candidate, Candidate.class);
		assertNotNull(responseEntityCandidate.getBody());
		assertNotNull(responseEntityCandidate.getBody().getCandidatename());
		logger.info("Candidate details added successfully!");
		logger.info("[END] testAddCandidate()");
	}

	
	
	//Test Case for adding Candidate Details with blank values  -FAIL
	@Test
	public void testAddCandidateWithBlankValues() {
		logger.info("[START] testAddCandidateWithBlankValues()");
		RestTemplate restTemplate = new RestTemplate();
		Exception exception = assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
		()->{
			Candidate candidate = new Candidate("", "", "", "", 3, "", "", 2);
			candidateInvalid = restTemplate.postForObject("http://localhost:9090/cgits/candidate", candidate, Candidate.class);
		});
			logger.error(exception);
			logger.error("Please fill out all the fields. All fields are mandatory.");
			logger.info("[END] testAddCandidateWithBlankValues()");
	}
	
	
	
	
	//Test Case for adding Candidate Details with null values  -FAIL
	@Test
	public void testAddCandidateWithNullValues() {
		logger.info("[START] testAddCandidateWithNullValues()");
		RestTemplate restTemplate = new RestTemplate();
		Exception exception = assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
		()->{
			Candidate candidate = new Candidate(null, null, null, null, 3, null, null, 2);
			candidateInvalid = restTemplate.postForObject("http://localhost:9090/cgits/candidate", candidate, Candidate.class);
		});
			logger.error(exception);
			logger.error("Fields cannot be Null.");
			logger.info("[END] testAddCandidateWithNullValues()");
	}
	
	
	
	//Test Case for adding Candidate Details with negative experience -FAIL
	@Test
	public void testAddCandidateWithNegativeExperience() {
		logger.info("[START] testAddCandidateWithNegativeExperience()");
		RestTemplate restTemplate = new RestTemplate();
		Exception exception = assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
		()->{
			Candidate candidate = new Candidate("Monali", "Indore", "BE Mechanical", "Junior Analyst", -3, "C", "C++", 2);
			candidateInvalid = restTemplate.postForObject("http://localhost:9090/cgits/candidate", candidate, Candidate.class);
		});
			logger.error(exception);
			logger.error("Experience cannot be negative.");
			logger.info("[END] testAddCandidateWithNegativeExperience()");
	}
	
	
	
	//Test Case for adding Candidate Details with negative notice period  -FAIL
	@Test
	public void testAddCandidateWithNegativeNoticePeriod() {
		logger.info("[START] testAddCandidateWithNegativeNoticePeriod()");
		RestTemplate restTemplate = new RestTemplate();
		Exception exception = assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
		()->{
			Candidate candidate = new Candidate("Monali", "Indore", "BE Mechanical", "Junior Analyst", 3, "C", "C++", -2);
			candidateInvalid = restTemplate.postForObject("http://localhost:9090/cgits/candidate", candidate, Candidate.class);
		});
			logger.error(exception);
			logger.error("Notice Period cannot be negative.");
			logger.info("[END] testAddCandidateWithNegativeNoticePeriod()");
	}
	
	
	//Test Case for viewing Candidate Details -PASS
	@Test
	public void testViewAllCandidates(){
		
		logger.info("[START] testviewAllCandidates()");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Candidate[]> responseEntity = restTemplate.getForEntity("http://localhost:9090/cgits/candidate", Candidate[].class);
		assertNotNull(responseEntity);
        logger.info("[END] testviewAllCandidates()");
	
	}
	
	
	//Test Case for viewing Candidate details by specific Id - PASS
	@Test
	public void testViewCandidateById(){
		
		logger.info("[START] testViewCandidateByIdPass()");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Candidate> responseEntity = restTemplate.getForEntity("http://localhost:9090/cgits/candidate/48", Candidate.class);
		assertNotNull(responseEntity);
		logger.info(responseEntity);
		logger.info("Data fetched successfully for candidateId : 48");
		logger.info("[END] testViewCandidateByIdPass()");
	
	}
	
	
	
	//Test Case for viewing Candidate details by specific Id - FAIL
	@Test
	public void testViewCandidateByIdFail(){
		
		logger.info("[START] testViewCandidateByIdFail()");
		RestTemplate restTemplate = new RestTemplate();
		
		assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
		()->{
			 restTemplate.getForEntity("http://localhost:9090/cgits/candidate/-2", Candidate.class);
		});
		
		logger.error("Data for candidateId : -2  does not exists, candidateId cannot be negative.");
		logger.info("[END] testViewCandidateByIdFail()");
    }
	
	
	//Test Case for viewing Candidate details by Name - PASS
	@Test
	public void testViewCandidateByNamePass(){
		
		logger.info("[START] testViewCandidateByNamePass");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Candidate[]> responseEntity = restTemplate.getForEntity("http://localhost:9090/cgits/candidatenm/Shivani", Candidate[].class);
		assertNotNull(responseEntity);
		logger.info("Data fetched successfully for candidateName : Shivani");
		logger.info("[END] testViewCandidateByNamePass");
	
	}
	
 
	//Test Case for viewing Candidate details by Name - FAIL
	@Test
	public void testViewCandidateByNameFail(){
		
		logger.info("[START] testViewCandidateByNameFail()");
		RestTemplate restTemplate = new RestTemplate();
		
		assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
		()->{
			restTemplate.getForEntity("http://localhost:9090/cgits/candidatenm/Neha", Candidate[].class);
		});
		
		logger.error("Data for candidateName : Neha  does not exists.");
		logger.info("[END] testViewCandidateByIdFail()");
	}
	
	
	//Test Case for viewing Candidate details by Location - PASS
	@Test
	public void testViewCandidateByLocationPass(){
			
		logger.info("[START] testViewCandidateByLocationPass");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Candidate[]> responseEntity = restTemplate.getForEntity("http://localhost:9090/cgits/candidateloc/Pune", Candidate[].class);
		assertNotNull(responseEntity);
		logger.info("Data fetched successfully for location : Pune");
		logger.info("[END] testViewCandidateByLocationPass");
		
	}
		
	 
	//Test Case for viewing Candidate details by Location - FAIL
	@Test
	public void testViewCandidateByLocationFail(){
			
		logger.info("[START] testViewCandidateByLocationFail()");
		RestTemplate restTemplate = new RestTemplate();
			
		assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
		()->{
			restTemplate.getForEntity("http://localhost:9090/cgits/candidateloc/Ahemadnagar", Candidate[].class);
		});
		
		logger.error("Data for location : Ahemadnagar  does not exists.");	
		logger.info("[END] testViewCandidateByLocationFail()");
	}
	
	
	//Test Case for viewing Candidate details by Qualification - PASS
	@Test
	public void testViewCandidateByQualificationPass(){
					
		logger.info("[START] testViewCandidateByQualificationPass");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Candidate[]> responseEntity = restTemplate.getForEntity("http://localhost:9090/cgits/candidateqal/BE Information Technology", Candidate[].class);
		assertNotNull(responseEntity);
		logger.info("Data fetched successfully for Qualification : BE Information Technology");
		logger.info("[END] testViewCandidateByQualificationPass");
				
	}
				
			 
	//Test Case for viewing Candidate details by Qualification - FAIL
	@Test
	public void testViewCandidateByQualificationFail(){
					
		logger.info("[START] testViewCandidateByQualificationFail()");
		RestTemplate restTemplate = new RestTemplate();
					
		assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
		()->{
			 restTemplate.getForEntity("http://localhost:9090/cgits/candidateqal/BE Mechanical", Candidate[].class);
		});
					
		logger.error("Data for Qualification : BE Mechanical  does not exists.");	
		logger.info("[END] testViewCandidateByQualificationFail()");
	}
				
		
	//Test Case for viewing Candidate details by Designation - PASS
	@Test
	public void testViewCandidateByDesignationPass(){
							
		logger.info("[START] testViewCandidateByDesignationPass");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Candidate[]> responseEntity = restTemplate.getForEntity("http://localhost:9090/cgits/candidatedes/Senior Analyst", Candidate[].class);
		assertNotNull(responseEntity);
		logger.info("Data fetched successfully for Designation : Senior Analyst");
		logger.info("[END] testViewCandidateByDesignationPass");
						
	}
						
					 
	//Test Case for viewing Candidate details by Designation - FAIL
	@Test
	public void testViewCandidateByDesignationFail(){
							
		logger.info("[START] testViewCandidateByQualificationFail()");
		RestTemplate restTemplate = new RestTemplate();
							
		assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
		()->{
			 restTemplate.getForEntity("http://localhost:9090/cgits/candidatedes/Analyst A4", Candidate[].class);
		});
			
		logger.error("Data for Designation : Analyst A4  does not exists.");	
		logger.info("[END] testViewCandidateByDesignationFail()");
	}
	
	
		
				
	//Test Case for viewing Candidate details by PrimarySkills - PASS
	@Test
	public void testViewCandidateByPrimarySkillsPass(){
							
		logger.info("[START] testViewCandidateByPrimarySkillsPass");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Candidate[]> responseEntity = restTemplate.getForEntity("http://localhost:9090/cgits/candidateps/Java", Candidate[].class);
		assertNotNull(responseEntity);
		logger.info("Data fetched successfully for Primaryskill : Java");
		logger.info("[END] testViewCandidateByPrimarySkillsPass");
						
	}
						
					 
	//Test Case for viewing Candidate details by PrimarySkills - FAIL
	@Test
	public void testViewCandidateByPrimarySkillsFail(){
							
		logger.info("[START] testViewCandidateByPrimarySkillsFail()");
		RestTemplate restTemplate = new RestTemplate();
							
		assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
		()->{
			 restTemplate.getForEntity("http://localhost:9090/cgits/candidateps/Perl", Candidate[].class);
		});
				
		logger.error("Data for PrimarySkill : Perl  does not exists.");	
		logger.info("[END] testViewCandidateByPrimarySkillsFail()");
	}	
	
	
		//TEST CASE TO VIEW A CANDIDATE FOR HR BY GIVING CORRECT ID - PASS
		@Test
		public void testCandidateById() {
			logger.info("[START] testCandidateById()");
			RestTemplate restTemplate = new RestTemplate();
			Candidate candidate=restTemplate.getForObject("http://localhost:9091/cgits/candidate/hr/12345678", Candidate.class);
			assertNotNull(candidate);
			logger.info("[END] testCandidateById()");
		}
		
	
		//TEST CASE TO VIEW A CANDIDATE FOR HR USING CANDIDATE ID - PASS
		@Test
		public void testFindCandidateByIdHr() {
			logger.info("[START] testFindCandidateByIdHr()");
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Candidate> responseEntity = restTemplate.getForEntity("http://localhost:9091/cgits/candidate/hr/12345678", Candidate.class);
		
			assertNotNull(responseEntity);
			logger.info("Data fetched successfully for 12345678");
			logger.info("[END] testFindCandidateByIdHr()");
		}			
		/*
		//TEST CASE TO VIEW A CANDIDATE FOR HR USING NEGATIVE CANDIDATE ID - FAIL
		@Test
		public void testViewCandidateByIdForHRFail_CandidateNotFoundException(){
			    logger.info("[START] testViewCandidateByIdForHRFail()");		
				RestTemplate restTemplate = new RestTemplate();
				assertThrows(CandidateNotFoundException.class,
				()->{
						candidateService.viewCandidateForHR("-1111");
				}	
			);
				logger.info("Data for candidateid: -1111 does not exists.");
				logger.info("[END] testViewCandidateByIdForHRFail()");
		}			
				
<<<<<<< HEAD
		
		//TEST CASE TO VIEW A CANDIDATE FOR HR USING WRONG CANDIDATE ID SIZE - FAIL
		@Test
		public void testViewCandidateByIdForHRSize_CandidateNotFoundException(){
			    logger.info("[START] testViewCandidateByIdForHRFail()");		
				RestTemplate restTemplate = new RestTemplate();
				assertThrows(CandidateNotFoundException.class,
				()->{
						candidateService.viewCandidateForHR("1111");
				}	
			);
				logger.info("Data for candidateid: 1111 does not exists.");
				logger.info("[END] testViewCandidateByIdForHRFail()");
		}			
		*/
		//TEST CASE TO VIEW A CANDIDATE FOR HR USING CANDIDATE NAME - PASS
		@Test
		public void testFindCandidateByName() {
			logger.info("[START] testFindCandidateByName()");
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Candidate> responseEntity = restTemplate.getForEntity("http://localhost:9091/cgits/candidate/hr/sean", Candidate.class);
				
			assertNotNull(responseEntity);
			logger.info("Data fetched successfully for sean");
			logger.info("[END] testFindCandidateByName()");
		}			

		//TEST CASE TO VIEW A CANDIDATE FOR HR USING CANDIDATE NAME - FAIL
		@Test
		public void testViewCandidateByNameHRFail() {
			logger.info("[START] testViewCandidateByNameHRFail()");
			RestTemplate restTemplate = new RestTemplate();
			try {
				candidateInvalid = restTemplate.getForObject("http://localhost:9091/cgits/candidate/hr/jerry", Candidate.class);
			} catch (Exception e) {
				candidateInvalid = null;
				logger.error("testViewCandidateByNameHRFail()");
			} finally {
				assertNull(candidateInvalid, "Jerry Was Not Found");
			}
			logger.info("Please enter correct candidate name");
			logger.info("[END] testViewCandidateByNameHRFail()");
		}			
					
		//TEST CASE TO VIEW A CANDIDATE FOR HR USING <<BLANK>> PATH VARIABLE - FAIL
		@Test
		public void testViewCandidateByBlank() {
			logger.info("[START] testViewCandidateByNameBlank()");
			RestTemplate restTemplate = new RestTemplate();
			try {
				candidateInvalid = restTemplate.getForObject("http://localhost:9091/cgits/candidate/hr/", Candidate.class);
			}
			catch(Exception e){
				candidateInvalid = null;
			}
			finally{
				assertNull(candidateInvalid, "<<BLANK>> Was Not Found");
			}
			logger.info("[END] testViewCandidateByBlank()");
		}		
=======
	//TEST CASE TO VIEW A CANDIDATE FOR HR USING <<BLANK>> PATH VARIABLE - FAIL
	@Test
	public void testViewCandidateByBlank() {
		logger.info("[START] testViewCandidateByNameBlank()");
		RestTemplate restTemplate = new RestTemplate();
		try {
			candidateInvalid = restTemplate.getForObject("http://localhost:9091/cgits/candidate/hr/", Candidate.class);
		}
		catch(Exception e){
			candidateInvalid = null;
		}
		finally{
			assertNull(candidateInvalid, "<<BLANK>> Was Not Found");
		}
		logger.info("[END] testViewCandidateByBlank()");
	}			
	
	
	
	
>>>>>>> fb5c9702b60aaa193992cd619f6595ab24b97232
			
	
	
	//Tech services for viewing a candidate
	//TEST CASE TO VIEW A CANDIDATE FOR TECH USING <<BLANK>> PATH VARIABLE - FAIL
	@Test
	public void testTechViewCandidateByBlank() {
		logger.info("[START] testTechViewCandidateByBlank()");
		RestTemplate restTemplate = new RestTemplate();
		try {
			candidateInvalid = restTemplate.getForObject("http://localhost:8080/cgits/candidate/search/tech/", Candidate.class);
		}
		catch(Exception e){
			candidateInvalid = null;
		}
		finally{
			assertNull(candidateInvalid, "<<BLANK>> Was Not Found");
		}
		logger.info("CandidateID was blank. Enter valid ID");
		logger.info("[END] testTechViewCandidateByBlank()");
	}
	
	//TEST CASE TO VIEW A CANDIDATE FOR TECH USING NEGATIVE CANDIDATE ID - FAIL
	@Test
	public void testViewCandidateByIdForTechFail_CandidateNotFoundException(){
		    logger.info("[START] testViewCandidateByIdForTechFail_CandidateNotFoundException()");		
			RestTemplate restTemplate = new RestTemplate();
			assertThrows(CandidateNotFoundException.class,
			()->{
					candidateService.viewCandidateForTech("-12345678");
			}	
		);
			logger.info("CandidateID -12345678 is Invalid. Enter valid ID");
			logger.info("[END] testViewCandidateByIdForTechFail_CandidateNotFoundException()");
	}
	
	//TEST CASE TO VIEW A CANDIDATE FOR TECH USING WRONG CANDIDATE ID SIZE - FAIL
		@Test
		public void testViewCandidateByIdForTechSize_CandidateNotFoundException(){
			    logger.info("[START] testViewCandidateByIdForTechSize_CandidateNotFoundException()");		
				RestTemplate restTemplate = new RestTemplate();
				assertThrows(CandidateNotFoundException.class,
				()->{
						candidateService.viewCandidateForTech("1111");
				}	
			);
				logger.info("CandidateID 1111 is Invalid. Enter valid ID");
				logger.info("[END] testViewCandidateByIdForTechSize_CandidateNotFoundException()");
		}
		
		//TEST CASE TO VIEW A CANDIDATE FOR Tech USING CANDIDATE NAME - FAIL
		@Test
		public void testViewCandidateByNameTechFail() {
			logger.info("[START] testViewCandidateByNameTechFail()");
			RestTemplate restTemplate = new RestTemplate();
			try {
				candidateInvalid = restTemplate.getForObject("http://localhost:8080/cgits/candidate/search/tech/Jack", Candidate.class);
			} catch (Exception e) {
				candidateInvalid = null;
				logger.error("testViewCandidateByNameHRFail()");
			} finally {
				assertNull(candidateInvalid, "Not Found");
			}
			logger.info("Candidate Name Jack Not Found");
			logger.info("[END] testViewCandidateByNameTechFail()");
		}
		
		//TEST CASE TO VIEW A CANDIDATE FOR TECH USING CANDIDATE ID - PASS
		@Test
		public void testFindCandidateByIdTech() {
			logger.info("[START] testFindCandidateByIdTech()");
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Candidate> responseEntity = restTemplate.getForEntity("http://localhost:8080/cgits/candidate/search/tech/11111111", Candidate.class);
		
			assertNotNull(responseEntity);
			logger.info("Candidate ID 11111111 Found");
			logger.info("[END] testFindCandidateByIdTech()");
		}
		//TEST CASE TO VIEW A CANDIDATE FOR TECH USING CANDIDATE ID NOT PRESENT IN DB- FAIL
		@Test
		public void testFindCandidateByIdTechFail() {
			logger.info("[START] testFindCandidateByIdTechFail()");		
			RestTemplate restTemplate = new RestTemplate();
			assertThrows(CandidateNotFoundException.class,
			()->{
					candidateService.viewCandidateForTech("12345678");
			}	
		);
			logger.info("CandidateID 12345678 Not Found");
			logger.info("[END] testFindCandidateByIdTechFail()");
		}
		
		//TEST CASE TO VIEW A CANDIDATE FOR TECH USING CANDIDATE NAME - PASS
		@Test
		public void testFindCandidateByNameTech() {
			logger.info("[START] testFindCandidateByNameTech()");
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Candidate> responseEntity = restTemplate.getForEntity("http://localhost:8080/cgits/candidate/search/tech/Pranav", Candidate.class);
				
			assertNotNull(responseEntity);
			logger.info("Candidate Name Pranav Found");
			logger.info("[END] testFindCandidateByNameTech()");
		}
}
