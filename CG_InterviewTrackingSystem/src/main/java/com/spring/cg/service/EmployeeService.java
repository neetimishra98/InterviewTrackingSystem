package com.spring.cg.service;

import com.spring.cg.exception.EmployeeNotFoundException;
import com.spring.cg.json.Employee;

import java.util.List;

public interface EmployeeService {
	public Employee createEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Employee searchEmployee(int employeeId) throws EmployeeNotFoundException;
	public Employee updateEmployee(Employee employee, int employeeId) throws EmployeeNotFoundException;
	public List<Employee> deleteEmployee(int employeeId) throws EmployeeNotFoundException;
}
