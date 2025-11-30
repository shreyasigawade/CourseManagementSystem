package com.example.cmsspringbootjrestjdbcmavenproject.service;
//Encapsulates Business Logic
import java.util.List;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cmsspringbootjrestjdbcmavenproject.dao.CourseDao;

import com.example.cmsspringbootjrestjdbcmavenproject.model.CoursePojo;


@Service
public class CourseServiceImpl implements CourseService{
	
	Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);
	
	  @Autowired 
      CourseDao courseDao;
      
    
	public CourseServiceImpl() {
    	 
			}

      @Override
	public List<CoursePojo> getAllCourses() {
    	 logger.info("Entered fetchAllBook()...");
		 List<CoursePojo> allCourses= courseDao.getAllCourses();
		 logger.info("Exited fetchAllBook()...");
		return allCourses;
	}

	@Override
	public Optional<CoursePojo> getCourseById(int CourseId) {
		logger.info("Entered fetchABook()...");
		Optional<CoursePojo> courseById =courseDao.getCourseById(CourseId);
	    logger.info("existed fetchABook()...");
		return courseById;
	}

	@Override
	public void removeCourse(int CourseId) {
		courseDao.removeCourse(CourseId);
		
	}

	@Override
	public CoursePojo addCourse(CoursePojo newCourse) {
		CoursePojo addedCourse =courseDao.addCourse(newCourse);
		return addedCourse;
	}

	@Override
	public CoursePojo updateCourse(CoursePojo updateCourse) {
		CoursePojo update =courseDao.updateCourse(updateCourse);
		return update;
	}

	@Override
	public List<CoursePojo> getCourseByName(String CourseName) {
		List<CoursePojo> course =courseDao.getCourseByName(CourseName);
		return course;
	}

}
