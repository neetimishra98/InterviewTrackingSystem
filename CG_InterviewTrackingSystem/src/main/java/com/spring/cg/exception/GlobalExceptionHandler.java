package com.spring.cg.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler(value = {EmployeeNotFoundException.class})
	public ResponseEntity<ErrorMessage> handleEmployeeNotFoundException(EmployeeNotFoundException ex){
		String error = "Employee is not found";
		
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST,ex.getLocalizedMessage(),error);
		return new ResponseEntity<ErrorMessage>(errorMessage,new HttpHeaders(), errorMessage.getStatus());
	}
	
	@ExceptionHandler(value = {CandidateNotFoundException.class})
	public ResponseEntity<ErrorMessage> handleCandidateNotFoundException(CandidateNotFoundException ex){
		String error = "Candidate is not found";
		
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST,ex.getLocalizedMessage(),error);
		return new ResponseEntity<ErrorMessage>(errorMessage,new HttpHeaders(), errorMessage.getStatus());
	}
	
	@ExceptionHandler(value = {PanelMemberNotFoundException.class})
	public ResponseEntity<ErrorMessage> handlePanelMemberNotFoundException(PanelMemberNotFoundException ex){
		String error = "PanelMember is not found";
		
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST,ex.getLocalizedMessage(),error);
		return new ResponseEntity<ErrorMessage>(errorMessage,new HttpHeaders(), errorMessage.getStatus());
	}
	
	@ExceptionHandler(value = {PanelMemberNotSurrenderedException.class})
	public ResponseEntity<ErrorMessage> handlePanelMemberNotSurrenderedException(PanelMemberNotSurrenderedException ex){
		String error = "PanelMember is not Surrendered";
		
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST,ex.getLocalizedMessage(),error);
		return new ResponseEntity<ErrorMessage>(errorMessage,new HttpHeaders(), errorMessage.getStatus());
	}
	
	@ExceptionHandler(value = {InterviewSchedulerNotFoundException.class})
	public ResponseEntity<ErrorMessage> handleInterviewSchedulerNotFoundException(
			InterviewSchedulerNotFoundException ex) {
		String error = "Interview not found";

	ErrorMessage errorMessage = 
      new ErrorMessage(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
    return new ResponseEntity<ErrorMessage>(
    		errorMessage, new HttpHeaders(), errorMessage.getStatus());
	
}
	
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request){
		
		List<String> errors = new ArrayList<String>();
		for(FieldError fieldError: ex.getBindingResult().getFieldErrors())
			errors.add(fieldError.getField()+ " - "+ fieldError.getDefaultMessage());
		for(ObjectError objectError: ex.getBindingResult().getGlobalErrors())
			errors.add(objectError.getObjectName()+" - "+objectError.getDefaultMessage());
		
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST,ex.getLocalizedMessage(),errors);
		
		
		return handleExceptionInternal(ex,errorMessage,headers,HttpStatus.BAD_REQUEST,request);
		
	}

}
