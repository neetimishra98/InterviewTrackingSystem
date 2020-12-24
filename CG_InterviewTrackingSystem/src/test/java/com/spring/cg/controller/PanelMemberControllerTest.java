package com.spring.cg.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import com.spring.cg.json.PanelMember;

class PanelMemberControllerTest {

	//TEST CASE TO FIND PANEL MEMBER BY GIVING CORRECT PANEL ID - PASS
	@Test
	public void testFindPanelMemberById() {
		RestTemplate restTemplate = new RestTemplate();
		PanelMember panelMember = restTemplate.getForObject("http://localhost:9091/cgits/panelmember/surrender/hr/11000000", PanelMember.class);
		assertNotNull(panelMember);
	}

}
