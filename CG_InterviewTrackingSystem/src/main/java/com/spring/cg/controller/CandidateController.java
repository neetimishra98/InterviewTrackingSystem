package com.spring.cg.controller;

import java.util.List;
import java.util.Map;

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
import com.spring.cg.json.Designation;
import com.spring.cg.json.Employee;
import com.spring.cg.json.Location;
import com.spring.cg.json.PanelMember;
import com.spring.cg.json.PrimarySkills;
import com.spring.cg.json.Qualification;
import com.spring.cg.json.SecondarySkills;
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
	
	
	@ApiOperation(value="Adds new Candidate")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="New candidate added"),
			@ApiResponse(code=404, message="No such candidate is added")
	})
	@PostMapping(value ="/candidate" ,produces = MediaType.APPLICATION_JSON_VALUE,consumes =MediaType.APPLICATION_JSON_VALUE)
	public Candidate addCandidate(@Valid @RequestBody Candidate candidate) {
		return candidateService.addCandidate(candidate);
	}
	
	
	@ApiOperation(value="Views all Candidate")
	@ApiResponses(value= {
			@ApiResponse(code=404, message = "No such candidate found")
	})
	@GetMapping(value = "/candidate",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Candidate> viewAllCandidates() {
		return candidateService.viewAllCandidates();
	}
	
	
	@ApiOperation(value="Views Specific Candidate by Id")
	@ApiResponses(value= {
			@ApiResponse(code=404, message = "No such candidate found")
	})
	@GetMapping(value ="/candidate/{candidateid}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Candidate viewCandidateById(@PathVariable int candidateid) throws CandidateNotFoundException{
		return candidateService.viewCandidateById(candidateid);
	}
	
	@ApiOperation(value="Views Candidate by Name")
	@ApiResponses(value= {
			@ApiResponse(code=404, message = "No such candidate found")
	})
	@GetMapping(value ="/candidatenm/{candidatename}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Candidate> viewCandidateByName(@PathVariable String candidatename) throws CandidateNotFoundException{
		return candidateService.viewCandidateByName(candidatename);
	}
	
	@ApiOperation(value="Views Candidate by Location")
	@ApiResponses(value= {
			@ApiResponse(code=404, message = "No such candidate found")
	})
	@GetMapping(value ="/candidateloc/{location}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Candidate> viewCandidateByLocation(@PathVariable String location) throws CandidateNotFoundException{
		return candidateService.viewCandidateByLocation(location);
	}
	
	@ApiOperation(value="Views Candidate by Qualification")
	@ApiResponses(value= {
			@ApiResponse(code=404, message = "No such candidate found")
	})
	@GetMapping(value ="/candidateqal/{qualification}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Candidate> viewCandidateByQualification(@PathVariable String qualification) throws CandidateNotFoundException{
		return candidateService.viewCandidateByQualification(qualification);
	}
	
	@ApiOperation(value="Views Candidate by Designation")
	@ApiResponses(value= {
			@ApiResponse(code=404, message = "No such candidate found")
	})
	@GetMapping(value ="/candidatedes/{designation}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Candidate> viewCandidateByDesignation(@PathVariable String designation) throws CandidateNotFoundException{
		return candidateService.viewCandidateByDesignation(designation);
	}
	
	@ApiOperation(value="Views Candidate by PrimarySkills")
	@ApiResponses(value= {
			@ApiResponse(code=404, message = "No such candidate found")
	})
	@GetMapping(value ="/candidateps/{primaryskills}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Candidate> viewCandidateByPrimarySkills(@PathVariable String primaryskills) throws CandidateNotFoundException{
		return candidateService.viewCandidateByPrimarySkills(primaryskills);
	}
	

	
	
	
	
	
	@ApiOperation(value="Returns all Distinct Candidate Names")
	@ApiResponses(value= {
			@ApiResponse(code=404, message = "No such candidate found")
	})
	@GetMapping(value ="/candidatenmdis",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getDistinctCandidateName(){
		return candidateService.getDistinctCandidateName();
	}
	
	@ApiOperation(value="Returns all Location from table")
	@ApiResponses(value= {
			@ApiResponse(code=404, message = "No such candidate found")
	})
	@GetMapping(value ="/candidateloctb",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getLocationsFromTable(){
		return candidateService.getLocationsFromTable();
	}
	
	@ApiOperation(value="Returns all Qualification from table")
	@ApiResponses(value= {
			@ApiResponse(code=404, message = "No such candidate found")
	})
	@GetMapping(value ="/candidatequaltb",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getQualificationsFromTable(){
		return candidateService.getQualificationsFromTable();
	}
	
	@ApiOperation(value="Returns all Designation from table")
	@ApiResponses(value= {
			@ApiResponse(code=404, message = "No such candidate found")
	})
	@GetMapping(value ="/candidatedestb",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getDesignationsFromTable(){
		return candidateService.getDesignationsFromTable();
	}
	
	@ApiOperation(value="Returns all Primary Skills from table")
	@ApiResponses(value= {
			@ApiResponse(code=404, message = "No such candidate found")
	})
	@GetMapping(value ="/candidatepstb",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getPrimarySkillsFromTable(){
		return candidateService.getPrimarySkillsFromTable();
	}
	
	
	
	
	
	
	
	
	@ApiOperation(value="Returns all Location")
	@ApiResponses(value= {
			@ApiResponse(code=404, message = "No such location found")
	})
	@GetMapping(value = "/candidateloc",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Location> getAllLocations() {
		return candidateService.getAllLocations();
	}
	
	@ApiOperation(value="Returns all Qualification")
	@ApiResponses(value= {
			@ApiResponse(code=404, message = "No such qualificaton found")
	})
	@GetMapping(value = "/candidatequal",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Qualification> getAllQualifications() {
		return candidateService.getAllQualifications();
	}
	
	@ApiOperation(value="Returns all Designation")
	@ApiResponses(value= {
			@ApiResponse(code=404, message = "No such designation found")
	})
	@GetMapping(value = "/candidatedes",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Designation> getAllDesignations() {
		return candidateService.getAllDesignations();
	}
	
	@ApiOperation(value="Returns all PrimarySkills")
	@ApiResponses(value= {
			@ApiResponse(code=404, message = "No such primaryskill found")
	})
	@GetMapping(value = "/candidateps",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PrimarySkills> getAllPrimarySkills() {
		return candidateService.getAllPrimarySkills();
	}

	@ApiOperation(value="Returns all SecondarySkills")
	@ApiResponses(value= {
			@ApiResponse(code=404, message = "No such secondaryskill found")
	})
	@GetMapping(value = "/candidatess",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SecondarySkills> getAllSecondarySkills() {
		return candidateService.getAllSecondarySkills();
	}

	
	//SEARCH CANDIDATE BY USING CANDIDATE ID AND CANDIDATE NAME FOR HR
	/*
		@ApiOperation(value="Searches candidate in the tables")
		@ApiResponses(value= {
				@ApiResponse(code=201, message="Found the candidate in schema"),
				@ApiResponse(code=404, message = "No such candidate found")
		})
		@GetMapping(value="/candidate/hr/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Map<Candidate, String>> viewCandidateForHR(@PathVariable ("id") String candidateId)throws CandidateNotFoundException {
			return new ResponseEntity<Map<Candidate, String>>(candidateService.viewCandidateForHR(candidateId), HttpStatus.OK);

		}*/
	
		@ApiOperation(value="Searches candidate in the tables")
		@ApiResponses(value= {
				@ApiResponse(code=201, message="Found the candidate in schema"),
				@ApiResponse(code=404, message = "No such candidate found")
		})
		@GetMapping(value="/candidate/hr/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
			public Candidate viewCandidateForHRPanel(@PathVariable ("id") String candidateName)throws CandidateNotFoundException {
			return candidateService.viewCandidateForHRPanel(candidateName);
	
		}
		

		//SEARCH CANDIDATE BY USING CANDIDATE ID AND CANDIDATE NAME FOR TECH
				@ApiOperation(value="Searches candidate in the tables")
				@ApiResponses(value= {
						@ApiResponse(code=201, message="Found the candidate in schema"),
						@ApiResponse(code=404, message = "No such candidate found")
				})
				@GetMapping(value="/candidate/techpanel/search/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
					public ResponseEntity<Map<Candidate, String>> viewCandidateForTech(@PathVariable ("id") String candidateId)throws CandidateNotFoundException {
					return new ResponseEntity<Map<Candidate, String>>(candidateService.viewCandidateForTech(candidateId), HttpStatus.OK);

				}
		
}
