package com.spring.cg.service;

import com.spring.cg.exception.EmployeeNotFoundException;
import com.spring.cg.json.Employee;

public interface EmployeeService {
	public Employee createEmployee(Employee employee);
	public Employee getEmployeeById(int employeeid) throws EmployeeNotFoundException;

}
