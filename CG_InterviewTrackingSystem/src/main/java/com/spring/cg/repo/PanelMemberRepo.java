package com.spring.cg.repo;

import com.spring.cg.entity.PanelMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanelMemberRepo extends JpaRepository<PanelMemberEntity, Integer> {
    public PanelMemberEntity findById(int panelid);
    public PanelMemberEntity deleteById(int panelMemberId);
}
