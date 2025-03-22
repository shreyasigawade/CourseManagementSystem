package com.example.cmsspringbootjrestjdbcmavenproject.exception;

public class CourseNotFoundException extends RuntimeException {
	@Override
	public String getMessage() {
		return "Course Not Found";
		
	}
	
	

}
