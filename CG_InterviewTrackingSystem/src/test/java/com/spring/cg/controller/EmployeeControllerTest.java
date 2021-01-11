package com.spring.cg.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import com.spring.cg.json.Employee;

class EmployeeControllerTest {
	private static Logger logger = LogManager.getLogger(EmployeeControllerTest.class);

	public Employee employeeInvalid;
	@Test
	public void testFindEmployeeById() {
		//Employee With The ID 45011005 Exists, valid Testcase
		logger.info("[START] testFindEmployeeById()");
		RestTemplate restTemplate = new RestTemplate();
		Employee employee =restTemplate.getForObject("http://localhost:8080/cgits/employee/45011005", Employee.class);
		assertEquals(employee.getEmployeeid(), 45011005);
		logger.info("[END] testFindEmployeeById()");
	}
	@Test
	public void testFindEmployeeByName() {
		//Employee With The Name Nitin Exists, valid Testcase
		logger.info("[START] testFindEmployeeByName()");
		RestTemplate restTemplate = new RestTemplate();
		Employee employee =restTemplate.getForObject("http://localhost:8080/cgits/employee/Nitin", Employee.class);
		assertEquals(employee.getName(), "Nitin");
		logger.info("[END] testFindEmployeeByName()");
	}
	@Test
	public void testFindEmployeeByNameInvalid() {
		logger.info("[START] testFindEmployeeByNameInvalid()");
		RestTemplate restTemplate = new RestTemplate();
		//Employee With The Name Chales Exists. Mistyped Charl : Invalid Testcase
		try {
			employeeInvalid = restTemplate.getForObject("http://localhost:8080/cgits/employee/Charl", Employee.class);
		} catch (Exception e) {
			employeeInvalid = null;
			logger.error("testFindEmployeeByNameInvalid()");
		} finally {
			assertNull(employeeInvalid, "Charl Was Not Found");
		}
		logger.info("[END] testFindEmployeeByNameInvalid()");
	}
	@Test
	public void testFindEmployeeByBlank() {
		logger.info("[START] testFindEmployeeByBlank()");
		RestTemplate restTemplate = new RestTemplate();
		//Employee With The <<Blank>> Path Variable as URL to localhost : Invalid Testcase
		try {
			employeeInvalid = restTemplate.getForObject("http://localhost:8080/cgits/employee/", Employee.class);
			logger.error("testFindEmployeeByBlank()");
		}
		catch(Exception e){
			employeeInvalid = null;
		}
		finally{
			assertNull(employeeInvalid, "<<BLANK>> Was Not Found");
		}
		logger.info("[END] testFindEmployeeByBlank()");
	}
	@Test
	public void testFindEmployeeByInvalidURL() {
		logger.info("[START] testFindEmployeeByInvalidURL()");
		RestTemplate restTemplate = new RestTemplate();
		//Employee With The Name Chales Exists. Mistyped Charl : Invalid Testcase
		try {
			employeeInvalid = restTemplate.getForObject("http://localhost:8080/interviews/employee/Charles", Employee.class);
		}
		catch(Exception e){
			employeeInvalid = null;
			logger.error("testFindEmployeeByInvalidURL()");
		}
		finally{
			assertNull(employeeInvalid, "Charles Was Not Found");
		}
		logger.info("[END] testFindEmployeeByInvalidURL()");
	}
}
