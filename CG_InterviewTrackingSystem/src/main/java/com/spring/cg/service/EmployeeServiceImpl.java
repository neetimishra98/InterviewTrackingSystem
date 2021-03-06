package com.spring.cg.service;

import java.util.ArrayList;
import java.util.List;


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
	//FETCH ALL EMPLOYEES
	//@Override
	public List<Employee> getAllEmployees() {
		List<EmployeeEntity> employeeEntityList = employeeRepo.findAll();
		List<Employee> employees = new ArrayList<Employee>();
		for(EmployeeEntity employeeEntity: employeeEntityList) {
			employees.add(new Employee(employeeEntity.getEmployeeid(), employeeEntity.getName()));
		}
		return employees;
	}
	//CREATE A NEW EMPLOYEE
	@Override
	public Employee createEmployee(Employee employee) {
		EmployeeEntity employeeEntity = employeeRepo.save(new EmployeeEntity(employee.getEmployeeid(),employee.getName()));
		return new Employee(employeeEntity.getEmployeeid(),employeeEntity.getName());
	}

	//UPDATE AN EMPLOYEE
	@Override
	public Employee updateEmployee(Employee employee, int employeeId) throws EmployeeNotFoundException{
		EmployeeEntity newEmployeeEntity = employeeRepo.findByEmployeeid(employeeId);
		if(newEmployeeEntity==null){
			throw new EmployeeNotFoundException("Invalid Employee Id");
		}
		EmployeeEntity employeeEntity = employeeRepo.save(new EmployeeEntity(employee.getEmployeeid(), employee.getName()));
		employeeEntity.setName(newEmployeeEntity.getName());
		return new Employee(employee.getEmployeeid(), employee.getName());
	}

	//DELETE AN EMPLOYEE
	@Override
	public List<Employee> deleteEmployee(int employeeId) throws EmployeeNotFoundException{
		EmployeeEntity employeeEntity =
				employeeRepo.findByEmployeeid(employeeId);
		if(employeeEntity==null){
			throw new EmployeeNotFoundException("Invalid Employee Id");
		}
		employeeRepo.deleteById(employeeId);
		List<EmployeeEntity> employeeEntityList = employeeRepo.findAll();
		List<Employee> employees = new ArrayList<Employee>();
		for(EmployeeEntity e: employeeEntityList) {
			employees.add(new Employee(e.getEmployeeid(), e.getName()));
		}
		return employees;
	}

	//SEARCH EMPLOYEE
	public Employee searchEmployee(String employeeId) throws EmployeeNotFoundException {

		EmployeeEntity employeeEntity = employeeRepo.findByNameContaining(employeeId);
		if(employeeEntity!=null) {
			Employee employee = new Employee(employeeEntity.getEmployeeid(), employeeEntity.getName());
			return employee;
		}
		else{
			employeeEntity = employeeRepo.findByEmployeeid(Integer.valueOf(employeeId));
			System.out.println("Entered the else loop...");
			if(employeeEntity==null) {
				throw new EmployeeNotFoundException("Invalid Employee Id");
			}
			Employee employee = new Employee(employeeEntity.getEmployeeid(), employeeEntity.getName());
			return employee;
		}
	}
}
