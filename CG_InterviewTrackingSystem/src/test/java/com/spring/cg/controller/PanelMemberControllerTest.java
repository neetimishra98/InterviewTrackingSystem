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
}
