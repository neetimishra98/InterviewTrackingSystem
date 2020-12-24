package com.spring.cg.controller;

import com.spring.cg.json.PanelMember;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class PanelMemberControllerTest {
    @Test
    public void testFindPanelMemberById(){
        RestTemplate restTemplate = new RestTemplate();
        PanelMember panelMember = restTemplate.getForObject("http://localhost:8080/cgits/panelmember/search/15010115", PanelMember.class);
        assertNotNull(panelMember);
    }

}