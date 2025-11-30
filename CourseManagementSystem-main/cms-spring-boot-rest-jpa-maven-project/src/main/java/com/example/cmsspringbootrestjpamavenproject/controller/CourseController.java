package com.example.cmsspringbootrestjpamavenproject.controller;



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

import com.example.cmsspringbootrestjpamavenproject.model.CoursePojo;
import com.example.cmsspringbootrestjpamavenproject.service.CourseService;

import org.springframework.http.HttpStatus;

import jakarta.validation.Valid;



@RestController
@RequestMapping("v1")
public class CourseController {
	
	 
	// create the endpoints
	
		
		Logger logger = LoggerFactory.getLogger(CourseController.class);
		
		@Autowired
		CourseService courseService;

		@GetMapping("/api/courses")
		public ResponseEntity<List<CoursePojo>> getAllCourses(){
			logger.info("Entered fetchAllCourses()...");
			List<CoursePojo> allCourses= courseService.getAllCourses();
			logger.info("Exited fetchAllBook()...");
			//return allBooks;
			return new ResponseEntity<List<CoursePojo>>(allCourses, HttpStatus.OK);
		}
		
	
		@GetMapping("/api/courses/{Id}")
        public ResponseEntity<Optional<CoursePojo>> getCourseById(@PathVariable("Id") int CourseId){
			logger.info("Entered fetchABook()...");
			Optional<CoursePojo> getCourse = courseService.getCourseById(CourseId);
			
			logger.info("Exited fetchACourseById()...");
			//return allGenreBooks;
			return new ResponseEntity<Optional<CoursePojo>>(getCourse, HttpStatus.OK);
					
		}
		
		@GetMapping("/api/courses/name/{name}")
        public ResponseEntity<List<CoursePojo>> fetchByBookGenre(@PathVariable("name") String courseName){
			List<CoursePojo> getCourseByName =courseService.getCourseByName(courseName);
			//return allGenreBooks;
			return new ResponseEntity(getCourseByName, HttpStatus.OK);
					
		}
		
		@PostMapping("/api/courses")
		public ResponseEntity<CoursePojo> addBook(@Valid @RequestBody CoursePojo newCourse) {
			CoursePojo returnedPojo = courseService.addCourse(newCourse);
			//return returnedPojo;
			return new ResponseEntity(returnedPojo, HttpStatus.OK);
		}
		@PutMapping("/api/courses")
		public ResponseEntity<CoursePojo> updateBook(@Valid @RequestBody CoursePojo updateCourse) { 
			CoursePojo returnedPojo = courseService.updateCourse(updateCourse);
			//return returnedPojo;
			return new ResponseEntity(returnedPojo, HttpStatus.OK);
		}
	   
		@DeleteMapping("/api/courses/{courseId}")
	    public ResponseEntity<Void> removeCourse(@PathVariable("courseId") int courseId) {
			courseService.removeCourse(courseId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
}
