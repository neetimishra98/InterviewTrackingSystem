package com.spring.cg.util;

import com.spring.cg.entity.EmployeeEntity;
import com.spring.cg.json.Employee;

public class EmployeeUtil {
    public static Employee convertEmployeeEntityToEmployee(EmployeeEntity employee){
        return new Employee(employee.getEmployeeid(), employee.getName());
    }
    public static EmployeeEntity convertEmployeeToEmployeeEntity(Employee employee){
        return new EmployeeEntity(employee.getEmployeeid(), employee.getName());
    }
}
