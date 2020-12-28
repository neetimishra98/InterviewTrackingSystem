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
			logger.info("[END] testFindPanelMemberByIdForHRSize_PanelMemberNotFoundException()");
		}
		
    //TEST CASE TO FIND PANEL MEMBER BY GIVING BLANK PANEL ID - FAIL
	@Test
	public void testFindPanelMemberByBlank() {
		logger.info("[START] testFindPanelMemberByBlank()");
		RestTemplate restTemplate = new RestTemplate();
		try {
			panelMemberInvalid = restTemplate.getForObject("http://localhost:9091/cgits/panelmember/", PanelMember.class);
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
	
	
	
	//ADD PANEL MEMBER TEST CASES
	//PANEL MEMBER WITH VALID EMPLOYEE FOREIGN KEY
	@Test
	public void testAddPanelMemberValid() {
		logger.info("[START] testAddPanelMemberValid()");
		RestTemplate restTemplate = new RestTemplate();
		try {
			PanelMember request = new PanelMember(10501505, "Pune", "HR", null);
			panelMemberInvalid = restTemplate.postForObject("http://localhost:8080/cgits/panelmember/Charles", request, PanelMember.class);
		}
		catch(Exception e){
				panelMemberInvalid = null;
				logger.error("testAddPanelMemberValid()");
		}
		finally{
			assertEquals(panelMemberInvalid.getPanelid(), 10501505);
		}
		logger.info("[END] testAddPanelMemberValid()");

	}
	//PANEL MEMBER BLANK WITH VALID EMPLOYEE FOREIGN KEY
	@Test
	public void testAddPanelMemberBlank() {

		logger.info("[START] testAddPanelMemberBlank()");
		RestTemplate restTemplate = new RestTemplate();
		try {
			PanelMember request = new PanelMember();
			panelMemberInvalid = restTemplate.postForObject("http://localhost:8080/cgits/panelmember/Charles", request, PanelMember.class);
		}
		catch(Exception e){
			panelMemberInvalid = null;
			logger.error("testAddPanelMemberBlank()");
		}
		finally{
			assertNull(panelMemberInvalid, "No panel member could be added/found");
		}

		logger.info("[END] testAddPanelMemberBlank()");
	}
	@Test
	//PANEL MEMBER WITH INVALID/BLANK EMPLOYEE FOREIGN KEY
	public void testAddPanelMemberBlankEmployee() {
		logger.info("[START] testAddPanelMemberBlankEmployee()");
		RestTemplate restTemplate = new RestTemplate();
		try {
			PanelMember request = new PanelMember();
			panelMemberInvalid = restTemplate.postForObject("http://localhost:8080/cgits/panelmember/", request, PanelMember.class);
		}
		catch(Exception e){
			panelMemberInvalid = null;
			logger.error("testAddPanelMemberBlankEmployee()");
		}
		finally{
			assertNull(panelMemberInvalid, "No panel member could be added/found");
		}
		logger.info("[END] testAddPanelMemberBlankEmployee()");
	}
	@Test
	//PANEL MEMBER WITH INVALID/BLANK EMPLOYEE FOREIGN KEY
	public void testAddPanelMemberInvalidConstructor() {
		logger.info("[START] testAddPanelMemberInvalidConstructor()");
		RestTemplate restTemplate = new RestTemplate();
		try {
			PanelMember request = new PanelMember(150000000, "Pune", "HR", null);
			panelMemberInvalid = restTemplate.postForObject("http://localhost:8080/cgits/panelmember/Charles", request, PanelMember.class);
		}
		catch(Exception e){
			panelMemberInvalid = null;
			logger.error("testAddPanelMemberInvalidConstructor()");
		}
		finally{
			assertNull(panelMemberInvalid, "No panel member could be added/found");
		}
		logger.info("[END] testAddPanelMemberInvalidConstructor()");

	}
	@Test
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
			assertThrows(Exception.class,
					()->{
						panelMemberService.deletePanelMemberByName("Neh");
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
			assertThrows(Exception.class,
					()->{
						panelMemberService.deletePanelMemberByName(" ");
					});
			logger.error("<<Blank>> - No Input Given.");
			logger.info("[END] testDeletePanelMemberByNameFail2()");
		}
		
		//TESTCASE_4
		@Test()
		public void testDeletePanelMemberByNameFail3() {
			logger.info("[START] testDeletePanelMemberByNameFail3()");
			//VALIDATING PANEL MEMBER USING EMPLOYEE NAME USING INVALID Values.INVALID TEST CASE.
			RestTemplate restTemplate = new RestTemplate();
			assertThrows(Exception.class,
					()->{
						panelMemberService.deletePanelMemberByName("123");
					});	
			
			logger.error("EmployeeName can not have numeric values.Please Enter Characters.");
			logger.info("[END] testDeletePanelMemberByNameFail3()");
			}
			
		//TESTCASE_5
		@Test()
		public void testDeletePanelMemberByNameFail4() {
			logger.info("[START] testDeletePanelMemberByNameFail4()");
			//VALIDATING PANEL MEMBER USING EMPLOYEE NAME USING INVALID CHARACTER IN NAME.INVALID TEST CASE.
			RestTemplate restTemplate = new RestTemplate();
			assertThrows(Exception.class,
					()->{
						panelMemberService.deletePanelMemberByName("@Yash");
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
			ResponseEntity<PanelMember[]> responseEntity =restTemplate.getForEntity("http://localhost:8080/cgits/panelmember/list", PanelMember[].class);
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
				panelMemberInvalid =restTemplate.getForEntity("http://localhost:8080/cgits/panelmember/list", PanelMember[].class);
				
			}catch(Exception e){
				panelMemberInvalid = null;
			}
			finally{
				logger.error("Panel Members Not Found. Please Add Panel Members.");
				assertNotNull(panelMemberInvalid, "PanelMembers Not Found");
			}
			logger.info("[END] testGetAllPanelMembersFail()");
			
		}
	
	
	
}
