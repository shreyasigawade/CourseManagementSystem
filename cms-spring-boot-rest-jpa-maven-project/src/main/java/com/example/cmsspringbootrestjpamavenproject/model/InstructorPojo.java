package com.example.cmsspringbootrestjpamavenproject.model;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorPojo {


	private int instructorId;
	
	private String instructorName;
	
	 
	private String contactNo;
	 
	
	List<CoursePojo> allCourses;
	
	
	

}
