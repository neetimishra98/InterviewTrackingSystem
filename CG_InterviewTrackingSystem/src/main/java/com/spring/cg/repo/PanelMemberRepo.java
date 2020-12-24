package com.spring.cg.repo;

import com.spring.cg.entity.EmployeeEntity;
import com.spring.cg.entity.PanelMemberEntity;
import com.spring.cg.json.Employee;
import com.spring.cg.json.PanelMember;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.print.attribute.standard.PrinterName;

public interface PanelMemberRepo extends JpaRepository<PanelMemberEntity, Integer> {
    public PanelMemberEntity findById(int panelid);
    public PanelMemberEntity deleteById(int panelMemberId);
	//public PanelMemberEntity save(PanelMember panelMember);
    public PanelMemberEntity findByEmployeeEntity(EmployeeEntity employeeEntity);
}
