package com.spring.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.cg.entity.DesignationEntity;

public interface DesignationRepo extends JpaRepository<DesignationEntity, String> {

}
