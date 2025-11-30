package com.example.cmsspringbootrestjpamavenproject.dao.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="instructor_details")
public class InstructorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="instructor_id")
	private int instructorId;
	
	@Column(name="instructor_name")
	private String instructorName;
	
	@Column(name="contact_no")
	private String contactNo;
	
	@OneToMany(mappedBy ="instructor") // bidirectional mapping from instructor to course
	@ToString.Exclude
	@JsonIgnore
	List<CourseEntity> allcourses;
}
