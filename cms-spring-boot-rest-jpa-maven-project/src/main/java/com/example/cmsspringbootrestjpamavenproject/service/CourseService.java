package com.example.cmsspringbootrestjpamavenproject.service;

import java.util.List;


import java.util.Optional;

import com.example.cmsspringbootrestjpamavenproject.model.CoursePojo;


public interface CourseService {
	 List<CoursePojo> getAllCourses();
	 Optional<CoursePojo>  getCourseById(int CourseId);
	 void removeCourse(int CourseId);
	 CoursePojo addCourse(CoursePojo newCourse);
	 CoursePojo updateCourse(CoursePojo updateCourse);
	 List<CoursePojo> getCourseByName(String CourseName);

}
