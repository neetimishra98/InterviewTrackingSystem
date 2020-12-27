package com.spring.cg.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import com.spring.cg.json.PanelMember;

class PanelMemberControllerTest {

	public PanelMember panelMemberInvalid;
	
	//TEST CASE TO FIND PANEL MEMBER BY GIVING CORRECT PANEL ID - PASS
	@Test
	public void testFindPanelMemberById() {
		RestTemplate restTemplate = new RestTemplate();
		PanelMember panelMember = restTemplate.getForObject("http://localhost:9091/cgits/panelmember/surrender/hr/11000000", PanelMember.class);
		assertEquals(panelMember.getPanelid(), 11000000);
	}
	
	//TEST CASE TO FIND PANEL MEMBER BY GIVING BLANK PANEL ID - FAIL
	@Test
	public void testFindPanelMemberByBlank() {
		RestTemplate restTemplate = new RestTemplate();
		try {
			panelMemberInvalid = restTemplate.getForObject("http://localhost:9091/cgits/panelmember/surrender/hr/", PanelMember.class);
		}
		catch(Exception e){
			panelMemberInvalid = null;
		}
		finally{
			assertNotNull(panelMemberInvalid, "<<BLANK>> Was Not Found");
		}
	}
	
	//ADD PANEL MEMBER TEST CASES
	//PANEL MEMBER WITH VALID EMPLOYEE FOREIGN KEY
	@Test
	public void testAddPanelMemberValid() {
		RestTemplate restTemplate = new RestTemplate();
		try {
			PanelMember request = new PanelMember(10501505, "Pune", "HR", null);
			panelMemberInvalid = restTemplate.postForObject("http://localhost:8080/cgits/panelmember/add/Charles", request, PanelMember.class);
		}
		catch(Exception e){
				panelMemberInvalid = null;
		}
		finally{
			assertEquals(panelMemberInvalid.getPanelid(), 10501505);
		}
	}
	//PANEL MEMBER BLANK WITH VALID EMPLOYEE FOREIGN KEY
	@Test
	public void testAddPanelMemberBlank() {
		RestTemplate restTemplate = new RestTemplate();
		try {
			PanelMember request = new PanelMember();
			panelMemberInvalid = restTemplate.postForObject("http://localhost:8080/cgits/panelmember/add/Charles", request, PanelMember.class);
		}
		catch(Exception e){
			panelMemberInvalid = null;
		}
		finally{
			assertNull(panelMemberInvalid, "No panel member could be added/found");
		}
	}
	@Test
	//PANEL MEMBER WITH INVALID/BLANK EMPLOYEE FOREIGN KEY
	public void testAddPanelMemberBlankEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		try {
			PanelMember request = new PanelMember();
			panelMemberInvalid = restTemplate.postForObject("http://localhost:8080/cgits/panelmember/add/", request, PanelMember.class);
		}
		catch(Exception e){
			panelMemberInvalid = null;
		}
		finally{
			assertNull(panelMemberInvalid, "No panel member could be added/found");
		}
	}
	@Test
	//PANEL MEMBER WITH INVALID/BLANK EMPLOYEE FOREIGN KEY
	public void testAddPanelMemberInvalidConstructor() {
		RestTemplate restTemplate = new RestTemplate();
		try {
			PanelMember request = new PanelMember(150000000, "Pune", "HR", null);
			panelMemberInvalid = restTemplate.postForObject("http://localhost:8080/cgits/panelmember/add/Charles", request, PanelMember.class);
		}
		catch(Exception e){
			panelMemberInvalid = null;
		}
		finally{
			assertNull(panelMemberInvalid, "No panel member could be added/found");
		}
	}
	@Test
	//PANEL MEMBER WITH INVALID/BLANK EMPLOYEE FOREIGN KEY
	public void testAddPanelMemberInvalidEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		try {
			PanelMember request = new PanelMember(150000000, "Pune", "HR", null);
			panelMemberInvalid = restTemplate.postForObject("http://localhost:8080/cgits/panelmember/add/Andruw", request, PanelMember.class);
		}
		catch(Exception e){
			panelMemberInvalid = null;
		}
		finally{
			assertNull(panelMemberInvalid, "No panel member could be added/found");
		}
	}
	
	
}
