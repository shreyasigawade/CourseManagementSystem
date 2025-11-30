package com.example.cmsspringbootrestjpamavenproject.model;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoursePojo {
	    private int courseId;
	    
	    @NotNull
	    private String courseName;
	    
	    @NotNull
	    private String location;
	    
	    @NotNull
	    private BigDecimal  courseFee;
	    
	    @NotNull
	    private InstructorPojo instructor;
	    
	    private int durationInWeeks;
		private String level;





}