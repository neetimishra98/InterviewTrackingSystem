package com.spring.cg.exception;

public class InterviewNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public InterviewNotFoundException() {
		this.message="";
	}

	public InterviewNotFoundException(String message) {
		this.message=message;
		
	}

	@Override
	public String toString() {
		return "Interview Not Found "+this.message;
	}

}
