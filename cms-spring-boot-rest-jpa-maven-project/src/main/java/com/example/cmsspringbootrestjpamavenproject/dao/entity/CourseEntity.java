package com.example.cmsspringbootrestjpamavenproject.dao.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Course_details")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id") // Corrected column name
    private int courseId;
    
    @Column(name="course_name")
    private String courseName;
    
    @Column(name="location")
    private String location;
    
    @Column(name="course_Fee")
    private BigDecimal courseFee;
    
    @ManyToOne
    @JoinColumn(name="instructor_id")
    private InstructorEntity instructor;
    
    @Column(name="duration_In_Weeks")
    private int durationInWeeks;
    
    @Column(name="course_level")
    private String level;


	
	
	
	

}
