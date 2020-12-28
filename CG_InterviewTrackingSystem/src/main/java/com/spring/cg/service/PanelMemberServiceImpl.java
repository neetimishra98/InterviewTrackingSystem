package com.spring.cg.service;

import com.spring.cg.entity.EmployeeEntity;
import com.spring.cg.entity.PanelMemberEntity;
import com.spring.cg.exception.EmployeeNotFoundException;
import com.spring.cg.exception.PanelMemberNotFoundException;
import com.spring.cg.exception.PanelMemberNotSurrenderedException;
import com.spring.cg.json.PanelMember;
import com.spring.cg.repo.EmployeeRepo;
import com.spring.cg.repo.PanelMemberRepo;
import com.spring.cg.util.PanelMemberUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PanelMemberServiceImpl implements PanelMemberService{
    @Autowired
    PanelMemberRepo panelMemberRepo;
   
    @Autowired
    EmployeeRepo employeeRepo;
    

    @Override
    public PanelMember addPanelMember(PanelMember panelMember, String employeeName) throws EmployeeNotFoundException{
        EmployeeEntity employeeEntity = employeeRepo.findByName(employeeName);
        PanelMemberEntity panelMemberEntity =
                panelMemberRepo.save(new PanelMemberEntity(panelMember.getPanelid(), panelMember.getLocation(), panelMember.getType(), employeeEntity));
        return new PanelMember(panelMember.getPanelid(), panelMember.getLocation(), panelMember.getType(), panelMemberEntity.getEmployeeEntity());
    }

    public List<PanelMember> getAllPanelMembers(){
        List<PanelMemberEntity> panelMemberEntityList = panelMemberRepo.findAll();
        List<PanelMember> panelMembers = new ArrayList<PanelMember>();
        for(PanelMemberEntity panelMemberEntity : panelMemberEntityList) {
            panelMembers.add(new PanelMember(panelMemberEntity.getPanelid(), panelMemberEntity.getLocation(), panelMemberEntity.getType(), panelMemberEntity.getEmployeeEntity()));
        }
        return panelMembers;
    }

    public PanelMember findPanelMember(int panelId) throws PanelMemberNotFoundException {
        PanelMemberEntity panelMemberEntity = panelMemberRepo.findById(panelId);
        if(panelMemberEntity==null){
            throw new PanelMemberNotFoundException("Invalid Employee Id");

        }
        PanelMember panelMember = new PanelMember(panelMemberEntity.getPanelid(), panelMemberEntity.getLocation(), panelMemberEntity.getType(), panelMemberEntity.getEmployeeEntity());

        return panelMember;
    }

    //DELETE AN EMPLOYEE
    @Override
    public List<PanelMember> deletePanelMemberByName(String employeeName) throws PanelMemberNotFoundException, PanelMemberNotSurrenderedException, EmployeeNotFoundException{
        EmployeeEntity employeeEntity = employeeRepo.findByName(employeeName);
        PanelMemberEntity panelMemberEntity =
                panelMemberRepo.findByEmployeeEntity(employeeEntity);
        if(panelMemberEntity==null){
            throw new PanelMemberNotFoundException("Invalid Panel Id");
        }
        if(panelMemberEntity.getType()!=null){
            throw new PanelMemberNotSurrenderedException("Panel Member has not yet surrendered, can't delete the employee directly");
        }
        panelMemberEntity.setEmployeeEntity(null);
        panelMemberRepo.deleteById(panelMemberEntity.getPanelid());
        List<PanelMemberEntity> panelMemberEntityList = panelMemberRepo.findAll();
        List<PanelMember> panelMembers = new ArrayList<PanelMember>();
        for(PanelMemberEntity p: panelMemberEntityList) {
            panelMembers.add(new PanelMember(p.getPanelid(), p.getLocation(), p.getType(), p.getEmployeeEntity()));
        }
        return panelMembers;
    }
    
    //SURRENDER AS TECH PANEL
    @Override
	public PanelMember updatePanelTech(int panelId) throws PanelMemberNotFoundException{
    	Optional<PanelMemberEntity> opPanelMemberEntity = Optional.of(panelMemberRepo.findById(panelId));
        if(opPanelMemberEntity.isPresent()){
        	PanelMemberEntity panelMemberEntity = opPanelMemberEntity.get();
        		panelMemberEntity.setType(null);
        		panelMemberEntity = panelMemberRepo.save(panelMemberEntity);
        	return PanelMemberUtil.convertPanelMemberEntitytoPanelMember(panelMemberEntity);
        }
        else {
            throw new PanelMemberNotFoundException("Invalid Panel Id");
        }
       
    }

 
    //SURRENDER AS HR PANEL (USING PANEL ID AS INPUT)
	@Override
  	public PanelMember surrenderAsHRPanel(int panelid) throws PanelMemberNotFoundException {
		Optional<PanelMemberEntity> opPanelMemberEntity = Optional.of(panelMemberRepo.findById(panelid));
        if(opPanelMemberEntity.isPresent()){
        	PanelMemberEntity panelMemberEntity = opPanelMemberEntity.get();
        		panelMemberEntity.setType(null);
        		panelMemberEntity = panelMemberRepo.save(panelMemberEntity);
        	return PanelMemberUtil.convertPanelMemberEntitytoPanelMember(panelMemberEntity);
        }
        else {
            throw new PanelMemberNotFoundException("Invalid Panel Id");
        }
  		
  	}
}
