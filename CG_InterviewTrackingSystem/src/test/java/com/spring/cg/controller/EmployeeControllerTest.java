package com.spring.cg.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import com.spring.cg.json.Employee;

class EmployeeControllerTest {
	public Employee employeeInvalid;
	@Test
	public void testFindEmployeeById() {
		//Employee With The ID 45011005 Exists, valid Testcase
		RestTemplate restTemplate = new RestTemplate();
		Employee employee =restTemplate.getForObject("http://localhost:8080/cgits/employee/search/45011005", Employee.class);
		assertEquals(employee.getEmployeeid(), 45011005);
	}
	@Test
	public void testFindEmployeeByName() {
		//Employee With The Name Nitin Exists, valid Testcase
		RestTemplate restTemplate = new RestTemplate();
		Employee employee =restTemplate.getForObject("http://localhost:8080/cgits/employee/search/Nitin", Employee.class);
		assertEquals(employee.getName(), "Nitin");
	}
	@Test
	public void testFindEmployeeByNameInvalid() {
		RestTemplate restTemplate = new RestTemplate();
		//Employee With The Name Chales Exists. Mistyped Charl : Invalid Testcase
		try {
			employeeInvalid = restTemplate.getForObject("http://localhost:8080/cgits/employee/search/Charl", Employee.class);
		} catch (Exception e) {
			employeeInvalid = null;
		} finally {
			assertNotNull(employeeInvalid, "Charl Was Not Found");
		}
	}
	@Test
	public void testFindEmployeeByBlank() {
		RestTemplate restTemplate = new RestTemplate();
		//Employee With The <<Blank>> Path Variable as URL to localhost : Invalid Testcase
		try {
			employeeInvalid = restTemplate.getForObject("http://localhost:8080/cgits/employee/search/", Employee.class);
		}
		catch(Exception e){
			employeeInvalid = null;
		}
		finally{
			assertNotNull(employeeInvalid, "<<BLANK>> Was Not Found");
		}
	}
	@Test
	public void testFindEmployeeByInvalidURL() {
		RestTemplate restTemplate = new RestTemplate();
		//Employee With The Name Chales Exists. Mistyped Charl : Invalid Testcase
		try {
			employeeInvalid = restTemplate.getForObject("http://localhost:8080/interviews/employee/search/Charles", Employee.class);
		}
		catch(Exception e){
			employeeInvalid = null;
		}
		finally{
			assertNotNull(employeeInvalid, "Charles Was Not Found");
		}
	}
}
