package com.spring.cg.service;

import com.spring.cg.entity.PanelMemberEntity;
import com.spring.cg.exception.EmployeeNotFoundException;
import com.spring.cg.exception.PanelMemberNotFoundException;
import com.spring.cg.exception.PanelMemberNotSurrenderedException;
import com.spring.cg.json.PanelMember;

import java.util.List;

public interface PanelMemberService {
    public PanelMember addPanelMember(PanelMember panelMember, String employeeName) throws EmployeeNotFoundException;
    public List<PanelMember> getAllPanelMembers();
    public PanelMember findPanelMember(int panelId) throws PanelMemberNotFoundException;
    public List<PanelMember> deletePanelMember(int panelMemberId) throws PanelMemberNotFoundException, PanelMemberNotSurrenderedException;
    public PanelMemberEntity updatePanelTech(int panelId) throws PanelMemberNotFoundException;
    public PanelMemberEntity surrenderAsHRPanel(int panelid) throws PanelMemberNotFoundException;
}
