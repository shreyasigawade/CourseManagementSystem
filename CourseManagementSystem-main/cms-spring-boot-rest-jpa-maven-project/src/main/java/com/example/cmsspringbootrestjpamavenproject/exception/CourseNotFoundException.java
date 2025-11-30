package com.example.cmsspringbootrestjpamavenproject.exception;

public class CourseNotFoundException extends RuntimeException{
	@Override
	public String getMessage() {
		return "Book Not Found!";
	} 

}
