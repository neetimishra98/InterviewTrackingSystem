package com.spring.cg.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.spring.cg.exception.PanelMemberNotFoundException;
import com.spring.cg.json.PanelMember;
import com.spring.cg.service.PanelMemberService;

class PanelMemberControllerTest {

	public PanelMember panelMemberInvalid;
	
	@Autowired
	private PanelMemberService panelMemberService;
	private static Logger logger = LogManager.getLogger(PanelMemberControllerTest.class);

	//TEST CASE TO FIND PANEL MEMBER BY GIVING CORRECT PANEL ID - PASS
		@Test
		public void testFindPanelMemberById() {
			RestTemplate restTemplate = new RestTemplate();
			PanelMember panelMember = restTemplate.getForObject("http://localhost:9091/cgits/panelmember/hr/11000000", PanelMember.class);
			assertEquals(panelMember.getPanelid(), 11000000);
		}
		
		//TEST CASE TO FIND PANEL MEMBER BY GIVING BLANK PANEL ID - FAIL
		@Test
		public void testFindPanelMemberByBlank() {
			RestTemplate restTemplate = new RestTemplate();
			try {
				panelMemberInvalid = restTemplate.getForObject("http://localhost:9091/cgits/panelmember/hr/", PanelMember.class);
			}
			catch(Exception e){
				panelMemberInvalid = null;
			}
			finally{
				assertNotNull(panelMemberInvalid, "<<BLANK>> Was Not Found");
			}
		}
		
		//TEST CASE TO VIEW A CANDIDATE FOR HR USING NEGATIVE PANEL ID - Fail
		@Test
		public void testFindPanelMemberByIdForHRFail_PanelMemberNotFoundException(){
								
			RestTemplate restTemplate = new RestTemplate();						
			assertThrows(PanelMemberNotFoundException.class,
			()->{
				panelMemberService.surrenderAsHRPanel(-1111);
				}	
			);
		}
		
		//TEST CASE TO VIEW A CANDIDATE FOR HR USING WRONG PANEL ID SIZE - FAIL
		@Test
		public void testFindPanelMemberByIdForHRSize_PanelMemberNotFoundException(){
									
			RestTemplate restTemplate = new RestTemplate();						
			assertThrows(PanelMemberNotFoundException.class,
			()->{
					panelMemberService.surrenderAsHRPanel(1111);
				}	
			);
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
	
	
	
}
