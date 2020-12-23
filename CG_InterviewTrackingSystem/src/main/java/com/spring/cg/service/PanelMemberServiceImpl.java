package com.spring.cg.service;

import com.spring.cg.entity.EmployeeEntity;
import com.spring.cg.entity.PanelMemberEntity;
import com.spring.cg.exception.EmployeeNotFoundException;
import com.spring.cg.exception.PanelMemberNotFoundException;
import com.spring.cg.exception.PanelMemberNotSurrenderedException;
import com.spring.cg.json.Employee;
import com.spring.cg.json.PanelMember;
import com.spring.cg.repo.EmployeeRepo;
import com.spring.cg.repo.PanelMemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PanelMemberServiceImpl implements PanelMemberService{
    @Autowired
    PanelMemberRepo panelMemberRepo;
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    private EmployeeService employeeService;

    @Override
    public PanelMember addPanelMember(PanelMember panelMember, String employeeName) throws EmployeeNotFoundException{
        EmployeeEntity employeeEntity = employeeRepo.findByName(employeeName);
        PanelMemberEntity panelMemberEntity =
                panelMemberRepo.save(new PanelMemberEntity(panelMember.getPanelid(), panelMember.getLocation(), panelMember.getType()));
        Employee emp = new Employee(employeeEntity.getEmployeeid(), employeeEntity.getName(), panelMemberEntity);
        employeeService.updateEmployee(emp, employeeEntity.getEmployeeid());
        return new PanelMember(panelMember.getPanelid(), panelMember.getLocation(), panelMember.getType());
    }

    public List<PanelMember> getAllPanelMembers(){
        List<PanelMemberEntity> panelMemberEntityList = panelMemberRepo.findAll();
        List<PanelMember> panelMembers = new ArrayList<PanelMember>();
        for(PanelMemberEntity panelMemberEntity : panelMemberEntityList) {
            panelMembers.add(new PanelMember(panelMemberEntity.getPanelid(), panelMemberEntity.getLocation(), panelMemberEntity.getType()));
        }
        return panelMembers;
    }

    public PanelMember findPanelMember(int panelId) throws PanelMemberNotFoundException {
        PanelMemberEntity panelMemberEntity = panelMemberRepo.findById(panelId);
        if(panelMemberEntity==null){
            throw new PanelMemberNotFoundException("Invalid Employee Id");

        }
        PanelMember panelMember = new PanelMember(panelMemberEntity.getPanelid(), panelMemberEntity.getLocation(), panelMemberEntity.getType());

        return panelMember;
    }

    //DELETE AN EMPLOYEE
    @Override
    public List<PanelMember> deletePanelMember(int panelMemberId) throws PanelMemberNotFoundException, PanelMemberNotSurrenderedException{
        PanelMemberEntity panelMemberEntity =
                panelMemberRepo.findById(panelMemberId);
        if(panelMemberEntity==null){
            throw new PanelMemberNotFoundException("Invalid Panel Id");
        }
        if(panelMemberEntity.getType()!=null){
            throw new PanelMemberNotSurrenderedException("Panel Member has not yet surrendered, can't delete the employee directly");
        }
        panelMemberRepo.deleteById(panelMemberId);
        List<PanelMemberEntity> panelMemberEntityList = panelMemberRepo.findAll();
        List<PanelMember> panelMembers = new ArrayList<PanelMember>();
        for(PanelMemberEntity p: panelMemberEntityList) {
            panelMembers.add(new PanelMember(p.getPanelid(), p.getLocation(), p.getType()));
        }
        return panelMembers;
    }
    
    //SURRENDER AS HR PANEL (USING PANEL ID AS INPUT)
	@Override
  	public PanelMemberEntity surrenderAsHRPanel(int panelid) throws PanelMemberNotFoundException {
  		PanelMemberEntity panelMemberEntity = panelMemberRepo.findById(panelid);
  		if(panelMemberEntity==null) {
  			throw new PanelMemberNotFoundException("Invalid Panel Id");
  		}
  		else 
  			panelMemberEntity.setType(null);
  		
  		return panelMemberRepo.save(panelMemberEntity);
  		
  	}
}
