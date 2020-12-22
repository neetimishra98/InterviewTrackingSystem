package com.spring.cg.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import com.spring.cg.json.Employee;

class EmployeeControllerTest {

	@Test
	public void testFindEmployeeById() {
		RestTemplate restTemplate = new RestTemplate();
		Employee employee =restTemplate.getForObject("http://localhost:8080/cgits/employee/1", Employee.class);
		assertNotNull(employee);
	}
}
