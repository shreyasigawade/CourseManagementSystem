package com.example.cmsspringbootjrestjdbcmavenproject.controller;

import java.util.List;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import jakarta.validation.Valid;

import com.example.cmsspringbootjrestjdbcmavenproject.model.CoursePojo;
import com.example.cmsspringbootjrestjdbcmavenproject.service.CourseService;


@RestController
@RequestMapping("v1")
public class CourseController {
	
	 
	// create the endpoints
	//CourseService courseService = new CourseServiceImpl();
		
		Logger logger = LoggerFactory.getLogger(CourseController.class);
		
		@Autowired
		CourseService courseService;

		@GetMapping("/api/courses")
		public ResponseEntity<List<CoursePojo>> getAllCourses(){
			logger.info("Entered fetchAllBook()...");
			List<CoursePojo> allBooks = courseService.getAllCourses();
			logger.info("Exited fetchAllBook()...");
			
			return new ResponseEntity<List<CoursePojo>>(allBooks, HttpStatus.OK);
		}
		
	
		@GetMapping("/api/courses/{Id}")
//		public List<BookPojo> fetchByBookGenre(@PathVariable("genre") String bookGenre){
		public ResponseEntity<Optional<CoursePojo>> getCourseById(@PathVariable("Id") int CourseId){
			logger.info("Entered fetchABook()...");
			Optional<CoursePojo> getCourse = courseService.getCourseById(CourseId);
			
			logger.info("Exited fetchABook()...");
			
			return new ResponseEntity<Optional<CoursePojo>>(getCourse, HttpStatus.OK);
					
		}
		
		@GetMapping("/api/courses/name/{name}")
//		
		public ResponseEntity<List<CoursePojo>> getCourseByName(@PathVariable("name") String courseName){
			List<CoursePojo> getCourseByName =courseService.getCourseByName(courseName);
			
			return new ResponseEntity<List<CoursePojo>>(getCourseByName, HttpStatus.OK);
					
		}
		// add a course
		// http://localhost:8080/v1/api/courses
		@PostMapping("/api/courses")
//		 // using @RequestBody annotation will copy the incoming request body into the newcourse object
		public ResponseEntity<CoursePojo> addBook(@Valid @RequestBody CoursePojo newCourse) { // using @RequestBody annotation will copy the incoming request body into the newBook object
			CoursePojo returnedPojo = courseService.addCourse(newCourse);
			//return returnedPojo;
			return new ResponseEntity<CoursePojo>(returnedPojo, HttpStatus.OK);
		}
		// update a course
		// http://localhost:8080/v1/api/courses
		@PutMapping("/api/courses")
        // using @RequestBody annotation will copy the incoming request body into the newCourse object
		public ResponseEntity<CoursePojo> updateBook(@Valid @RequestBody CoursePojo updateCourse) { // using @RequestBody annotation will copy the incoming request body into the newCourse object
			CoursePojo returnedPojo = courseService.updateCourse(updateCourse);
			//return returnedPojo;
			return new ResponseEntity<CoursePojo>(returnedPojo, HttpStatus.OK);
		}
	   
		@DeleteMapping("/api/courses/{courseId}")
	    public ResponseEntity<Void> removeCourse(@PathVariable("courseId") int courseId) {
			courseService.removeCourse(courseId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
}
