package com.spring.cg.exception;

public class EmployeeNotFoundException extends Exception{
	private String message;

	public EmployeeNotFoundException() {
		this.message="";
	}

	public EmployeeNotFoundException(String message) {
		this.message=message;
		
	}

	@Override
	public String toString() {
		return "Employee Not Found "+this.message;
	}
}
