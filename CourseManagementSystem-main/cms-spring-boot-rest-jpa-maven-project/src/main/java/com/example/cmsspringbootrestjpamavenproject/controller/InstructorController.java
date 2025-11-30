package com.example.cmsspringbootrestjpamavenproject.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.cmsspringbootrestjpamavenproject.model.InstructorPojo;
import com.example.cmsspringbootrestjpamavenproject.service.InstructorService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:5173")

@RestController
@RequestMapping("v1")
public class InstructorController {
	
	Logger logger = LoggerFactory.getLogger(CourseController.class);
	
	@Autowired
	InstructorService instructorService;
	
	@GetMapping("/api/instructors")
	public ResponseEntity<List<InstructorPojo>> fetchAllInstructors(){
		logger.info("Entered fetchAllInstructors()...");
		List<InstructorPojo> allInstructors= instructorService.fetchAllInstructors();
		logger.info("Exited fetchAllInstructors()...");
		return new ResponseEntity<List<InstructorPojo>>(allInstructors, HttpStatus.OK);
	}
	
	@GetMapping("/api/instructors/{id}")
	public ResponseEntity<Optional<InstructorPojo>> fetchAInstructor(@PathVariable("id") int instructorId) { // PathVaribale literally tells spring to copy the bid into bookId
		logger.info("Entered fetchAAuthor()...");
		Optional<InstructorPojo> optionalInstructor = instructorService.fetchAInstructorById(instructorId);
		logger.info("Exited fetchAInstructor()...");
		return new ResponseEntity<Optional<InstructorPojo>>(optionalInstructor, HttpStatus.OK);
	}

	@PostMapping("/api/instructors")
	public ResponseEntity<InstructorPojo> addInstructor(@Valid @RequestBody InstructorPojo newInstructor) {
		InstructorPojo returnedPojo = instructorService.addInstructor(newInstructor);
		return new ResponseEntity(returnedPojo, HttpStatus.OK);
	}

	@PutMapping("/api/instructors")
	public ResponseEntity<InstructorPojo> updateInstructor(@Valid @RequestBody InstructorPojo updateInstructorPojo) {
		InstructorPojo returnedPojo = instructorService.updateInstructor(updateInstructorPojo);
		return new ResponseEntity(returnedPojo, HttpStatus.OK);
	}
   
	@DeleteMapping("/api/instructors/{instructorId}")
	public ResponseEntity<Void> removeInstructor(@PathVariable("instructorId") int id) {
		instructorService.removeInstructor(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	
}

}
