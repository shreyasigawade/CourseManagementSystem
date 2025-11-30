package com.example.cmsspringbootrestjpamavenproject.service;

import java.util.List;
import java.util.Optional;

import com.example.cmsspringbootrestjpamavenproject.model.InstructorPojo;

public interface InstructorService {
	    List<InstructorPojo> fetchAllInstructors();
		Optional<InstructorPojo> fetchAInstructorById(int instructorId);
		void removeInstructor(int instructorId);
		InstructorPojo addInstructor(InstructorPojo newInstructor);
		InstructorPojo updateInstructor(InstructorPojo updateInstructor);
	}


