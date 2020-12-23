package com.spring.cg.exception;

public class InterviewSchedulerNotFoundException extends Exception {
	
	private String message;

	public InterviewSchedulerNotFoundException() {
		this.message = "";
	}

	public InterviewSchedulerNotFoundException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "Interview Scheduler Not Found " + this.message ;
	}
	
}
