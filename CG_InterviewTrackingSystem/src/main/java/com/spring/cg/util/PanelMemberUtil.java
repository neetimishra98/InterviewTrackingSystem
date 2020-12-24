package com.spring.cg.util;

import com.spring.cg.entity.PanelMemberEntity;

import com.spring.cg.json.PanelMember;


public class PanelMemberUtil {

	public static PanelMember convertPanelMemberEntitytoPanelMember(PanelMemberEntity panelMemberEntity) {
		return new PanelMember(panelMemberEntity.getPanelid(),panelMemberEntity.getLocation(),panelMemberEntity.getType(),panelMemberEntity.getEmployeeEntity());
	}
}
