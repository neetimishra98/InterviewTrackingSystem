package com.spring.cg.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cg.entity.EmployeeEntity;
import com.spring.cg.exception.EmployeeNotFoundException;
import com.spring.cg.json.Employee;
import com.spring.cg.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public Employee getEmployeeById(int employeeid) throws EmployeeNotFoundException{
		Optional<EmployeeEntity> opEmployeeEntity = employeeRepo.findById(employeeid);
		if(opEmployeeEntity.isPresent()) {
			EmployeeEntity employeeEntity = opEmployeeEntity.get();
			return new Employee(employeeEntity.getEmployeeid(), employeeEntity.getName(),employeeEntity.getPanelMemberEntity());
		}
		else {
			throw new EmployeeNotFoundException("employeeid" + employeeid);
		}
		
	}

	@Override
	public Employee createEmployee(Employee employee) {
		EmployeeEntity employeeEntity = employeeRepo.save(new EmployeeEntity(employee.getEmployeeid(),employee.getName(),employee.getPanelMemberEntity()));
		return new Employee(employeeEntity.getEmployeeid(),employeeEntity.getName(),employeeEntity.getPanelMemberEntity());
	}
}
