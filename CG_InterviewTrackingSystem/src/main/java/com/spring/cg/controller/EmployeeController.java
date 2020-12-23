package com.spring.cg.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.cg.exception.EmployeeNotFoundException;
import com.spring.cg.json.Employee;
import com.spring.cg.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/cgits")
@Api(value="Employee related REST APIs")
public class EmployeeController {
		
	@Autowired
	private EmployeeService employeeService;
	//FETCH ALL EMPLOYEES
	@ApiOperation(value="Returns all employee")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="New employee created"),
			@ApiResponse(code=404, message = "No such employee found")
	})	
	@GetMapping(value ="/employee/list",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	//CREATE A NEW EMPLOYEE
	@ApiOperation(value="Creates employee")
	@PostMapping(value="/employee/add",produces =MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.createEmployee(employee), HttpStatus.OK);
	}
	//UPDATE AN EMPLOYEE
	@ApiOperation(value="Updates a particular Employee")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Employee updated"),
			@ApiResponse(code=404, message = "No such employee found")
	})
	@PutMapping(value="/employee/update/{id}", produces= MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee, @PathVariable("id") int employeeId) throws EmployeeNotFoundException{
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, employeeId), HttpStatus.OK);
	}
	//SEARCH AN EMPLOYEE
	@ApiOperation(value="Searches an employee in the tables")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Found the employee in schema"),
			@ApiResponse(code=404, message = "No such employee found")
	})
	@GetMapping(value="/employee/search/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> searchEmployee(@PathVariable ("id") String employeeId)throws EmployeeNotFoundException {
		return new ResponseEntity<Employee>(employeeService.searchEmployee(employeeId), HttpStatus.OK);
	}
	//DELETE AN EMPLOYEE
	@ApiOperation(value="Deletes an Employee")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Employee deleted"),
			@ApiResponse(code=404, message = "No such employee found")
	})
	@DeleteMapping(value="/employee/delete/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> deleteEmployee(@PathVariable ("id") int employeeId)throws EmployeeNotFoundException {
		return new ResponseEntity<Employee>((Employee)employeeService.deleteEmployee(employeeId), HttpStatus.OK);
	}
}
