package com.example.cmsspringbootjrestjdbcmavenproject.exception;

public class CourseAlreadyExistException extends RuntimeException {
	@Override
	public String getMessage() {
		return "Course Already Exists!";
		
	}

}
