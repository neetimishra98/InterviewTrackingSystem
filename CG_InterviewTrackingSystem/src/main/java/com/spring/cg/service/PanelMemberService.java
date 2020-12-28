package com.spring.cg.service;

import com.spring.cg.exception.EmployeeNotFoundException;
import com.spring.cg.exception.PanelMemberNotFoundException;
import com.spring.cg.exception.PanelMemberNotSurrenderedException;
import com.spring.cg.json.PanelMember;

import java.util.List;

public interface PanelMemberService {
    public PanelMember addPanelMember(PanelMember panelMember, String employeeName) throws EmployeeNotFoundException;
    public List<PanelMember> getAllPanelMembers();
    public PanelMember findPanelMember(int panelId) throws PanelMemberNotFoundException;
    public List<PanelMember> deletePanelMemberByName(String employeeName) throws PanelMemberNotFoundException, PanelMemberNotSurrenderedException, EmployeeNotFoundException;
    
    //Surrender As A TECH Panel
    public PanelMember updatePanelTech(int panelId) throws PanelMemberNotFoundException;
   
    //Surrender As A HR Panel
    public PanelMember surrenderAsHRPanel(int panelid) throws PanelMemberNotFoundException;
}
