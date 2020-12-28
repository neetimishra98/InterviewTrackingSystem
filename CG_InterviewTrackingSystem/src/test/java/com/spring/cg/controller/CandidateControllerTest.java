package com.spring.cg.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import com.spring.cg.json.Candidate;

@SpringBootTest
public class CandidateControllerTest {
	
	public Candidate candidateInvalid;
	
	private static Logger logger = LogManager.getLogger(CandidateControllerTest.class);
	
	@Autowired
	private CandidateRepo candidateRepo;
	
	@Autowired
	private CandidateService candidateService;
	
	
	
	// Test Case for adding Candidate Details
/*	@Test
	public void testAddCandidateSuccess()
	{
		logger.info("[START] testAddCandidate()");
		RestTemplate restTemplate = new RestTemplate();
		Candidate candidate = new Candidate("Shivani", "Pune", "BE Electronics", "Junior Analyst", 3, "C", "C++", 2);
		ResponseEntity<Candidate> responseEntityCandidate = restTemplate.postForEntity("http://localhost:9090/cgits/candidate", candidate, Candidate.class);
		
		
		assertNotNull(responseEntityCandidate.getBody());
		assertNotNull(responseEntityCandidate.getBody().getCandidatename());
		
		//assertEquals(responseEntityCandidate.getBody().getCandidatename(),candidate.getCandidatename());
		logger.info("Candidate details added successfully!");
		logger.info("[END] testAddCandidate()");
	}
*/
	
	
	//Test Case for viewing Candidate Details
	@Test
	public void testViewAllCandidates(){
		
		logger.info("[START] testviewAllCandidates()");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Candidate[]> responseEntity = restTemplate.getForEntity("http://localhost:9090/cgits/candidate", Candidate[].class);
		assertNotNull(responseEntity);
        logger.info("[END] testviewAllCandidates()");
	
	}
	
	
	//Test Case for viewing Candidate details by specific Id - Success
	@Test
	public void testViewCandidateById(){
		
		logger.info("[START] testViewCandidateByIdPass()");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Candidate> responseEntity = restTemplate.getForEntity("http://localhost:9090/cgits/candidate/48", Candidate.class);
		assertNotNull(responseEntity);
		logger.info("[END] testViewCandidateByIdPass()");
	
	}
	
	
	//Test Case for viewing Candidate details by specific Id - Fail
	@Test
	public void testViewCandidateByIdFail_CandidateNotFoundException(){
		
		logger.info("[START] testViewCandidateByIdFail()");
		RestTemplate restTemplate = new RestTemplate();
		
		assertThrows(CandidateNotFoundException.class,
		()->{
			candidateService.viewCandidateById(-2);
		}	
	);
		logger.info("[END] testViewCandidateByIdFail()");
}
	
	
	//Test Case for viewing Candidate details by Name - Success
	@Test
	public void testViewCandidateByNamePass(){
		
		logger.info("[START] testViewCandidateByNamePass");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Candidate[]> responseEntity = restTemplate.getForEntity("http://localhost:9090/cgits/candidatenm/Shivani", Candidate[].class);
		assertNotNull(responseEntity);
		logger.info("[END] testViewCandidateByNamePass");
	
	}
	
 
	//Test Case for viewing Candidate details by Name - Fail
	@Test
	public void testViewCandidateByNameFail(){
		
		logger.info("[START] testViewCandidateByNameFail()");
		RestTemplate restTemplate = new RestTemplate();
		
		assertThrows(CandidateNotFoundException.class,
		()->{
			candidateService.viewCandidateByName("Neha");
		}	
	);
		
		logger.info("[END] testViewCandidateByIdFail()");
	}
	
	
	//Test Case for viewing Candidate details by Location - Success
	@Test
	public void testViewCandidateByLocationPass(){
			
		logger.info("[START] testViewCandidateByLocationPass");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Candidate[]> responseEntity = restTemplate.getForEntity("http://localhost:9090/cgits/candidateloc/Pune", Candidate[].class);
		assertNotNull(responseEntity);
		logger.info("[END] testViewCandidateByLocationPass");
		
	}
		
	 
	//Test Case for viewing Candidate details by Location - Fail
	@Test
	public void testViewCandidateByLocationFail(){
			
		logger.info("[START] testViewCandidateByLocationFail()");
		RestTemplate restTemplate = new RestTemplate();
			
		assertThrows(CandidateNotFoundException.class,
		()->{
				candidateService.viewCandidateByLocation("Ahemadnagar");
			}	
	);
			
		logger.info("[END] testViewCandidateByLocationFail()");
	}
	
	
	//Test Case for viewing Candidate details by Qualification - Success
	@Test
	public void testViewCandidateByQualificationPass(){
					
		logger.info("[START] testViewCandidateByQualificationPass");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Candidate[]> responseEntity = restTemplate.getForEntity("http://localhost:9090/cgits/candidateqal/BE Information Technology", Candidate[].class);
		assertNotNull(responseEntity);
		logger.info("[END] testViewCandidateByQualificationPass");
				
	}
				
			 
	//Test Case for viewing Candidate details by Qualification - Fail
	@Test
	public void testViewCandidateByQualificationFail(){
					
		logger.info("[START] testViewCandidateByQualificationFail()");
		RestTemplate restTemplate = new RestTemplate();
					
		assertThrows(CandidateNotFoundException.class,
		()->{
				candidateService.viewCandidateByQualification("BE Mechanical");
			}	
		);
					
		logger.info("[END] testViewCandidateByQualificationFail()");
	}
				
		
	//Test Case for viewing Candidate details by Designation - Success
	@Test
	public void testViewCandidateByDesignationPass(){
							
		//logger.info("[START] testViewCandidateByQualificationPass");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Candidate[]> responseEntity = restTemplate.getForEntity("http://localhost:9090/cgits/candidatedes/Senior Analyst", Candidate[].class);
		assertNotNull(responseEntity);
		//logger.info("[END] testViewCandidateByDesignationPass");
						
	}
						
					 
	//Test Case for viewing Candidate details by Designation - Fail
	@Test
	public void testViewCandidateByDesignationFail(){
							
		logger.info("[START] testViewCandidateByQualificationFail()");
		RestTemplate restTemplate = new RestTemplate();
							
		assertThrows(CandidateNotFoundException.class,
		()->{
				candidateService.viewCandidateByDesignation("Analyst A4");
			}	
		);
							
		logger.info("[END] testViewCandidateByDesignationFail()");
	}
		
				
	//Test Case for viewing Candidate details by PrimarySkills - Success
	@Test
	public void testViewCandidateByPrimarySkillsPass(){
							
		logger.info("[START] testViewCandidateByPrimarySkillsPass");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Candidate[]> responseEntity = restTemplate.getForEntity("http://localhost:9090/cgits/candidateps/Java", Candidate[].class);
		assertNotNull(responseEntity);
		logger.info("[END] testViewCandidateByPrimarySkillsPass");
						
	}
						
					 
	//Test Case for viewing Candidate details by PrimarySkills - Fail
	@Test
	public void testViewCandidateByPrimarySkillsFail(){
							
		logger.info("[START] testViewCandidateByPrimarySkillsFail()");
		RestTemplate restTemplate = new RestTemplate();
							
		assertThrows(CandidateNotFoundException.class,
			()->{
					candidateService.viewCandidateByPrimarySkills("Perl");
				}	
			);
							
		logger.info("[END] testViewCandidateByPrimarySkillsFail()");
	}	
				
		










	//TEST CASE TO VIEW A CANDIDATE FOR HR USING CANDIDATE ID - PASS
	@Test
	public void testFindCandidateByIdHr() {
		RestTemplate restTemplate = new RestTemplate();
		Candidate candidate=restTemplate.getForObject("http://localhost:9091/cgits/candidate/search/hr/12345678", Candidate.class);
		assertEquals(candidate.getCandidateid(), 12345678);
	}

	//TEST CASE TO VIEW A CANDIDATE FOR HR USING <<BLANK>> PATH VARIABLE - FAIL
	@Test
	public void testFindCandidateByBlank() {
		RestTemplate restTemplate = new RestTemplate();
		try {
			candidateInvalid = restTemplate.getForObject("http://localhost:9091/cgits/candidate/search/hr/", Candidate.class);
		}
		catch(Exception e){
			candidateInvalid = null;
		}
		finally{
			assertNotNull(candidateInvalid, "<<BLANK>> Was Not Found");
		}
	}
}
