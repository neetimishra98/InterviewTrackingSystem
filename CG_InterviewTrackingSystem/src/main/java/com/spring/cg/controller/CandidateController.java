package com.spring.cg.controller;

import java.util.List;

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

import com.spring.cg.exception.CandidateNotFoundException;
import com.spring.cg.exception.EmployeeNotFoundException;
import com.spring.cg.json.Candidate;
import com.spring.cg.json.PanelMember;
import com.spring.cg.service.CandidateService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@CrossOrigin("*")
@RequestMapping("/cgits")
@Api(value="Candidate related REST APIs")
public class CandidateController {
	
	@Autowired
	private CandidateService candidateService;
	
	
	@ApiOperation(value="Adds Candidate")
	@PostMapping(value ="/candidate" ,produces = MediaType.APPLICATION_JSON_VALUE,consumes =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Candidate> createCandidate(@Valid @RequestBody Candidate candidate) {
		return new ResponseEntity<Candidate>(candidateService.createCandidate(candidate), HttpStatus.OK);
	}
	
	
	 

	
	
	
	
	@ApiOperation(value="Returns all Candidate")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="New candidate created"),
			@ApiResponse(code=404, message = "No such candidate found")
	})
	@GetMapping(value = "/candidate",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Candidate> getAllCandidates() {
		return candidateService.getAllCandidates();
	}
	
	
	
	@ApiOperation(value="Returns Specific Candidate")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="New candidate created"),
			@ApiResponse(code=404, message = "No such candidate found")
	})
	@GetMapping(value ="/candidate/{candidateid}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Candidate getCandidateById(@PathVariable int candidateid) throws CandidateNotFoundException{
		return candidateService.getCandidateById(candidateid);
	}

}
