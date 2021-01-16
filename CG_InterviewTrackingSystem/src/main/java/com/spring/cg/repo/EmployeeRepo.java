package com.spring.cg.repo;

import com.spring.cg.exception.EmployeeNotFoundException;
import com.spring.cg.json.PanelMember;
import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.cg.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer>{
    public EmployeeEntity findByEmployeeid(int employeeId) throws EmployeeNotFoundException;
    @Query( "select e from EmployeeEntity e")
    public List<EmployeeEntity> getAllEmployee();
    public EmployeeEntity findByNameContaining(String employeeName) throws EmployeeNotFoundException;
    public List<EmployeeEntity> deleteByEmployeeid(int employeeId);

}
