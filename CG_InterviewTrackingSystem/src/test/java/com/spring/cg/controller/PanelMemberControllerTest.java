package com.spring.cg.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.client.RestTemplate;

import com.spring.cg.exception.PanelMemberNotFoundException;
import com.spring.cg.json.PanelMember;
import com.spring.cg.service.PanelMemberService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class PanelMemberControllerTest {
	
	private static Logger logger = LogManager.getLogger(PanelMemberControllerTest.class);

	public PanelMember panelMemberInvalid;
	
	@Autowired
	private PanelMemberService panelMemberService;
	
	//TEST CASE TO FIND PANEL MEMBER BY GIVING CORRECT PANEL ID - PASS
	@Test
	public void testFindPanelMemberById() {
		logger.info("[START] testFindPanelMemberById()");
		RestTemplate restTemplate = new RestTemplate();
		PanelMember panelMember = restTemplate.getForObject("http://localhost:9091/cgits/panelmember/hr/11000000", PanelMember.class);
		assertNotNull(panelMember);
		logger.info("[END] testFindPanelMemberById()");
	}
	
	//TEST CASE TO FIND PANEL MEMBER BY GIVING CORRECT PANEL ID - PASS
	@Test
	public void testFindPanelMemberByIdPass() {
		logger.info("[START] testFindPanelMemberByIdPass()");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<PanelMember> responseEntity = restTemplate.getForEntity("http://localhost:9091/cgits/panelmember/hr/11000000", PanelMember.class);
		assertNotNull(responseEntity);
		logger.info("Surrendered successfully!");
		logger.info("[END] testFindPanelMemberByIdPass()");
	}
	
	//TEST CASE TO FIND PANEL MEMBER BY USING NEGATIVE PANEL ID - FAIL
	@Test
	public void testFindPanelMemberByIdForHRFail_PanelMemberNotFoundException(){
		logger.info("[START] testFindPanelMemberByIdForHRFail_PanelMemberNotFoundException()");
		RestTemplate restTemplate = new RestTemplate();						
		assertThrows(PanelMemberNotFoundException.class,
		()->{
				panelMemberService.surrenderAsHRPanel(-1111);
			}	
		);
		logger.info("Please enter correct Panel Id");
		logger.info("[END] testFindPanelMemberByIdForHRFail_PanelMemberNotFoundException()");	
	}
	
	//TEST CASE TO FIND PANEL MEMBER BY USING WRONG PANEL ID SIZE - FAIL
	@Test
	public void testFindPanelMemberByIdForHRSize_PanelMemberNotFoundException(){
		logger.info("[START] testFindPanelMemberByIdForHRSize_PanelMemberNotFoundException()");				
		RestTemplate restTemplate = new RestTemplate();						
		assertThrows(PanelMemberNotFoundException.class,
		()->{
				panelMemberService.surrenderAsHRPanel(1111);
			}	
		);
		logger.info("Please enter correct Panel Id");
		logger.info("[END] testFindPanelMemberByIdForHRSize_PanelMemberNotFoundException()");
	}	
		
    //TEST CASE TO FIND PANEL MEMBER BY GIVING BLANK PANEL ID - FAIL
	@Test
	public void testFindPanelMemberByBlank() {
		logger.info("[START] testFindPanelMemberByBlank()");
		RestTemplate restTemplate = new RestTemplate();
		try {
			panelMemberInvalid = restTemplate.getForObject("http://localhost:9091/cgits/panelmember/hr/", PanelMember.class);
			logger.error("testFindPanelMemberByBlank()");
		}
		catch(Exception e){
			panelMemberInvalid = null;
		}
		finally{
			assertNull(panelMemberInvalid, "<<BLANK>> Was Not Found");
		}
		logger.info("[END] testFindPanelMemberByBlank()");
	}
	
	//TEST CASE TO CHECK IF PANEL MEMBER ALREADY SURRENDERED OR NOT - FAIL
	@Test
	public void testPanelMemberSurrendered() {
		logger.info("[START] testPanelMemberSurrendered()");
		RestTemplate restTemplate = new RestTemplate();
		PanelMember panelMember = restTemplate.getForObject("http://localhost:9091/cgits/panelmember/hr/11000000", PanelMember.class);
		assertEquals(panelMember.getType(), null);
		logger.info("Panel Member is already surrendered!");
		logger.info("[END] testPanelMemberSurrendered() - Already surrendered");
	}
	
	
	/*@Test
>>>>>>> 4aedf3c058fae8417c68ee2dbd434f8c3be8bda1
	//PANEL MEMBER WITH INVALID/BLANK EMPLOYEE FOREIGN KEY
	public void testAddPanelMemberInvalidEmployee() {
		logger.info("[START] testAddPanelMemberInvalidEmployee()");
		RestTemplate restTemplate = new RestTemplate();
		try {
			PanelMember request = new PanelMember(150000000, "Pune", "HR", null);
			panelMemberInvalid = restTemplate.postForObject("http://localhost:8080/cgits/panelmember/Andruw", request, PanelMember.class);
		}
		catch(Exception e){
			panelMemberInvalid = null;
			logger.error("testAddPanelMemberInvalidEmployee()");
		}
		finally{
			assertNull(panelMemberInvalid, "No panel member could be added/found");
		}
		logger.info("[END] testAddPanelMemberInvalidEmployee()");
	}
	*/
	//DELETE PANEL MEMBER TEST CASES
		//TESTCASE_1
		@Test
		public void testDeletePanelMemberByNameSuccess() {
			logger.info("[START] testDeletePanelMemberByNameSuccess()");
			//DELETING PANEL MEMBER USING EMPLOYEE NAME.VALID TEST CASE.
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.delete("http://localhost:8080/cgits/panelmember/{Name}","shristhi");
			logger.info("[END] testDeletePanelMemberByNameSuccess()");
		}
		
		//TESTCASE_2
		@Test()
		public void testDeletePanelMemberByNameFail1() {
			logger.info("[START] testDeletePanelMemberByNameFail1()");
			//VALIDATING PANEL MEMBER USING EMPLOYEE NAME WITH INVALID NAME.INVALID TEST CASE.
			RestTemplate restTemplate = new RestTemplate();
			assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
					()->{
						restTemplate.delete("http://localhost:8080/cgits/panelmember/{Name}","Neh");
					});	
			logger.error("No Employee Found as Neh.");
			logger.info("[END] testDeletePanelMemberByNameFail1()");
		}
		
		//TESTCASE_3
		@Test()
		public void testDeletePanelMemberByNameFail2() {
			logger.info("[START] testDeletePanelMemberByNameFail2()");
			//VALIDATING PANEL MEMBER USING EMPLOYEE NAME USING NO VALUES.INVALID TEST CASE.
			RestTemplate restTemplate = new RestTemplate();
			assertThrows(org.springframework.web.client.HttpClientErrorException.NotFound.class,
					()->{
						restTemplate.delete("http://localhost:8080/cgits/panelmember/");
					});
			logger.error("<<Blank>> - No Input Given.");
			logger.info("[END] testDeletePanelMemberByNameFail2()");
		}
		
		//TESTCASE_4
		@Test()
		public void testDeletePanelMemberByNameFail3() {
			logger.info("[START] testDeletePanelMemberByNameFail3()");
			//VALIDATING PANEL MEMBER USING EMPLOYEE NAME USING INVALID NUMERIC VALUES.INVALID TEST CASE.
			RestTemplate restTemplate = new RestTemplate();
			assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
					()->{
						restTemplate.delete("http://localhost:8080/cgits/panelmember/{Name}","123");
					});	
			
			logger.error("EmployeeName can not have numeric values.Please Enter Characters.");
			logger.info("[END] testDeletePanelMemberByNameFail3()");
			}
			
		//TESTCASE_5
		@Test()
		public void testDeletePanelMemberByNameFail4() {
			logger.info("[START] testDeletePanelMemberByNameFail4()");
			//VALIDATING PANEL MEMBER USING EMPLOYEE NAME USING INVALID CHARACTERS IN NAME.INVALID TEST CASE.
			RestTemplate restTemplate = new RestTemplate();
			assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
					()->{
						restTemplate.delete("http://localhost:8080/cgits/panelmember/{Name}","@Yash");
					});	
			
			logger.error("EmployeeName can not have Special Characters.");
			logger.info("[END] testDeletePanelMemberByNameFail4()");
			}
		
		
		//VIEW ALL PANEL MEMBERS TEST CASES
		//TESTCASE_1
		@Test()
		public void TestGetAllPanelMembersSuccess() {
			logger.info("[START] testGetAllPanelMembersSuccess()");
			//PANEL MEMBER DATA EXISTS. VALID TEST CASE.
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<PanelMember[]> responseEntity =restTemplate.getForEntity("http://localhost:8080/cgits/panelmembers", PanelMember[].class);
			assertNotNull(responseEntity, "Panel Member Found Successfully");
			logger.info("[END] testGetAllPanelMembersSuccess()");
			
		}
		
		//TESTCASE_2
		@Test()
		public void TestGetAllPanelMembersFail() {
			
			logger.info("[START] testGetAllPanelMembersFail()");
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<PanelMember[]> panelMemberInvalid = null;
			try {
				panelMemberInvalid =restTemplate.getForEntity("http://localhost:8080/cgits/panelmembers", PanelMember[].class);
				
			}catch(Exception e){
				panelMemberInvalid = null;
			}
			finally{
				logger.error("Panel Members Not Found. Please Add Panel Members.");
				assertNotNull(panelMemberInvalid, "PanelMembers Not Found");
			}
			logger.info("[END] testGetAllPanelMembersFail()");
		}
	
		//Tech Panel Service to surrender
		//TEST CASE TO SURRENDER TECH PANEL USING PANEL ID - PASS
		@Test
		public void testFindPanelByIdTech() {
			logger.info("[START] testFindPanelByIdTech()");
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<PanelMember> responseEntity = restTemplate.getForEntity("http://localhost:8080/cgits/panelmember/tech/search/44444444", PanelMember.class);
		
			assertNotNull(responseEntity);
			logger.debug(responseEntity);
			logger.info("PanelID 44444441 Found and surrendered successfully.");
			logger.info(responseEntity);
			logger.info("[END] testFindPanelByIdTech()");
		}
		
			//TEST CASE TO VIEW A CANDIDATE FOR TECH USING <<BLANK>> PATH VARIABLE - FAIL
			@Test
			public void testTechSurrenderByBlank() {
				logger.info("[START] testTechSurrenderByBlank()");
				RestTemplate restTemplate = new RestTemplate();
				try {
					panelMemberInvalid = restTemplate.getForObject("http://localhost:8080/cgits/panelmember/tech/search/", PanelMember.class);
				}
				catch(Exception e){
					panelMemberInvalid = null;
				}
				finally{
					assertNull(panelMemberInvalid, "<<BLANK>> Was Not Found");
				}
				logger.info("PanelID was blank. Enter valid ID");
				logger.info("[END] testTechSurrenderByBlank()");
			}
			
			//TEST CASE TO CHECK IF PANEL MEMBER ALREADY SURRENDERED OR NOT - FAIL
			@Test
			public void testTechPanelMemberSurrendered() {
				logger.info("[START] testPanelMemberSurrendered()");
				RestTemplate restTemplate = new RestTemplate();
				PanelMember panelMember = restTemplate.getForObject("http://localhost:8080/cgits/panelmember/tech/search/44444443", PanelMember.class);
				assertEquals(panelMember.getType(), null);
				logger.debug(panelMember);
				logger.info("PanelID 44444443 already surrendered" + panelMember);
				logger.info("[END] testPanelMemberSurrendered()");

			}
			
						
					//TEST CASE TO VIEW A CANDIDATE FOR TECH USING ZERO PATH VARIABLE - FAIL
					@Test
					public void testSurrenderByIdForTechZero() {
						logger.info("[START] testSurrenderByIdForTechZero()");
						RestTemplate restTemplate = new RestTemplate();
						try {
							panelMemberInvalid = restTemplate.getForObject("http://localhost:8080/cgits/panelmember/tech/search/00000000", PanelMember.class);
						}
						catch(Exception e){
							panelMemberInvalid = null;
						}
						finally{
							assertNull(panelMemberInvalid, "00000000 Was Not Found");
						}
						logger.info("PanelID 0000000 is Invalid. Enter valid ID");
						logger.info("[END] testSurrenderByIdForTechZero()");
					}
					
					//TEST CASE TO VIEW A CANDIDATE FOR TECH USING NEGATIVE PATH VARIABLE - FAIL
					@Test
					public void testSurrenderByIdForTechNegative() {
						logger.info("[START] testSurrenderByIdForTechNegative()");
						RestTemplate restTemplate = new RestTemplate();
						try {
							panelMemberInvalid = restTemplate.getForObject("http://localhost:8080/cgits/panelmember/tech/search/-12345678", PanelMember.class);
						}
						catch(Exception e){
							panelMemberInvalid = null;
						}
						finally{
							assertNull(panelMemberInvalid, "-12345678 Was Not Found");
						}
						logger.info("PanelID -12345678 is Invalid. Enter valid ID");
						logger.info("[END] testSurrenderByIdForTechNegative()");
					}
					
					//TEST CASE TO VIEW A CANDIDATE FOR TECH USING SIZE PATH VARIABLE - FAIL
					@Test
					public void testSurrenderByIdForTechSizeFail() {
						logger.info("[START] testSurrenderByIdForTechSizeFail()");
						RestTemplate restTemplate = new RestTemplate();
						try {
							panelMemberInvalid = restTemplate.getForObject("http://localhost:8080/cgits/panelmember/tech/search/-1234", PanelMember.class);
						}
						catch(Exception e){
							panelMemberInvalid = null;
						}
						finally{
							assertNull(panelMemberInvalid, "1234 Was Not Found");
						}
						logger.info("PanelID 1234 is Invalid. Enter valid ID");
						logger.info("[END] testSurrenderByIdForTechSizeFail()");
					}

}
