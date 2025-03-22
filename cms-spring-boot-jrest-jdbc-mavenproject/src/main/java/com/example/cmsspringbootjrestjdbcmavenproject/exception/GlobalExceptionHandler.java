package com.example.cmsspringbootjrestjdbcmavenproject.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers, HttpStatusCode status, WebRequest request){
		Map<String, String> errors = new HashMap<>();
		errors.put("time", LocalDateTime.now().toString());
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName = ((FieldError)error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return new ResponseEntity(errors, HttpStatus.BAD_REQUEST);	
	}
	
	@ExceptionHandler(CourseNotFoundException.class)
	protected ResponseEntity<Object> handleBookNotFoundException(CourseNotFoundException be){
		Map<String, String> errors = new HashMap<>();
		errors.put("error", be.getMessage());
		return new ResponseEntity(errors, HttpStatus.BAD_REQUEST);
	}

}
