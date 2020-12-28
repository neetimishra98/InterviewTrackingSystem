package com.spring.cg.controller;

import com.spring.cg.entity.PanelMemberEntity;
import com.spring.cg.exception.EmployeeNotFoundException;
import com.spring.cg.exception.PanelMemberNotFoundException;
import com.spring.cg.exception.PanelMemberNotSurrenderedException;
import com.spring.cg.json.Employee;
import com.spring.cg.json.PanelMember;
import com.spring.cg.service.PanelMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/cgits")
@Api(value="Panel Member related REST APIs")
public class PanelMemberController {
    @Autowired
    private PanelMemberService panelMemberService;

   //RETURNS ALL PANEL MEMBERS FROM THE DATABASE
    @ApiOperation(value="Returns all panel members")
    @ApiResponses(value= {
            @ApiResponse(code=201, message="Panel members have been found"),
            @ApiResponse(code=404, message = "No panel members found")
    })
    @GetMapping(value="/panelmembers", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<PanelMember> getAllPanelMembers() {
        return panelMemberService.getAllPanelMembers();
    }

    //RETURNS SPECIFIC PANEL MEMBERS FROM THE DATABASE
    @ApiOperation(value="Returns a specific panel members")
    @ApiResponses(value= {
            @ApiResponse(code=201, message="Found the panel member"),
            @ApiResponse(code=404, message = "No panel member found")
    })
    @GetMapping(value="/panelmember/search/{pid}", produces= MediaType.APPLICATION_JSON_VALUE)
    public PanelMember getAllPanelMembers(@PathVariable("pid") int panelId) throws PanelMemberNotFoundException {
        return panelMemberService.findPanelMember(panelId);
    }
     // RETURNS PANEL MEMBER CREATED IN DATABASE
    @ApiOperation(value="Adds a panel member")
    @ApiResponses(value= {
            @ApiResponse(code=201, message="New panel members created"),
            @ApiResponse(code=404, message = "No panel member found")
    })
    @PostMapping(value="/panelmember/{EmployeeName}", produces= MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PanelMember> addPanelMember(@Valid @RequestBody PanelMember panelMember, @PathVariable("EmployeeName") String employeeName) throws EmployeeNotFoundException {
        return new ResponseEntity<PanelMember>(panelMemberService.addPanelMember(panelMember, employeeName), HttpStatus.OK);
    }

    //DELETE AN PANEL MEMBER [IFF THE TYPE IS NULL]
    @ApiOperation(value="Deletes an panel member, just enter employee name")
    @ApiResponses(value= {
            @ApiResponse(code=201, message="Panel Member deleted"),
            @ApiResponse(code=404, message = "No such panel member found")
    })
    @DeleteMapping(value="/panelmember/{Name}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PanelMember>> deletePanelMember(@PathVariable ("Name") String employeeName)throws PanelMemberNotFoundException, PanelMemberNotSurrenderedException, EmployeeNotFoundException {
        return new ResponseEntity<List<PanelMember>>(panelMemberService.deletePanelMember(employeeName), HttpStatus.OK);
    }
    
    //SURRENDER AS TECH PANEL
    @ApiOperation(value="Returns PanelMember Entity after Surrendering")
	@ApiResponses(value= {
			@ApiResponse(code=200, message="surrendered given successfully"),
			@ApiResponse(code=404, message = "No such Panel found"),
  			@ApiResponse(code=201, message="Panel Member updated")

	})
	@GetMapping(value="/panelmember/surrendertech/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public PanelMember updatePanelTech(@PathVariable("id")int panelId) throws PanelMemberNotFoundException{
		return panelMemberService.updatePanelTech(panelId);
	}
  	
    //SURRENDER AS HR PANEL (USING PANEL ID AS INPUT)
  	@ApiOperation(value="Updates a particular Panel Member")
  	@ApiResponses(value= {
  			@ApiResponse(code=201, message="Panel Member updated"),
  			@ApiResponse(code=404, message = "No such panel member found")
  	})
  	@GetMapping(value="/panelmember/hr/{panelid}", produces=MediaType.APPLICATION_JSON_VALUE)
  	public PanelMember surrenderAsHRPanel(@PathVariable int panelid) throws PanelMemberNotFoundException {
  		return panelMemberService.surrenderAsHRPanel(panelid);
  	}
}
