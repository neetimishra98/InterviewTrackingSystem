package com.spring.cg.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cg.exception.EmployeeNotFoundException;
import com.spring.cg.json.Employee;
import com.spring.cg.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin("*")
@RequestMapping("/cgits")
@Api(value="Employee related REST APIs")
public class EmployeeController {
		
	@Autowired
	private EmployeeService employeeService;
	
	@ApiOperation(value="Returns all employee")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="New employee created"),
			@ApiResponse(code=404, message = "No such employee found")
	})	
	@GetMapping(value ="/employee/{employeeid}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployeeById(@PathVariable int employeeid) throws EmployeeNotFoundException{
		return employeeService.getEmployeeById(employeeid);
	}
	
	@ApiOperation(value="Creates employee")
	@PostMapping(value="/employee",produces =MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.createEmployee(employee), HttpStatus.OK);
	}
		
}
