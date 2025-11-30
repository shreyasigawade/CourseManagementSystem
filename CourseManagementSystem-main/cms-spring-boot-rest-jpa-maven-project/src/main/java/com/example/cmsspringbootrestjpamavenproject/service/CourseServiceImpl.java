package com.example.cmsspringbootrestjpamavenproject.service;
import java.util.ArrayList;
//Encapsulates Business Logic
import java.util.List;



import java.util.Optional;

import com.example.cmsspringbootrestjpamavenproject.dao.InstructorDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cmsspringbootrestjpamavenproject.dao.CourseDao;
import com.example.cmsspringbootrestjpamavenproject.dao.entity.CourseEntity;
import com.example.cmsspringbootrestjpamavenproject.dao.entity.InstructorEntity;
import com.example.cmsspringbootrestjpamavenproject.model.CoursePojo;
import com.example.cmsspringbootrestjpamavenproject.model.InstructorPojo;

//CourseServiceImpl class is a service class responsible for implementing business logic related to courses. 

@Service      // class is a service component in the Spring application context.
public class CourseServiceImpl implements CourseService{
	//Logger is an essential tool for developers to understand and debug their applications
	Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);
	
	@Autowired       // injects an instance of the CourseDao interface into the courseDao field. 
    CourseDao courseDao;

	@Autowired
	InstructorDao instructorDao;
      
    
	public CourseServiceImpl() {
    	 
			}

	@Override
	public List<CoursePojo> getAllCourses() {
		List<CourseEntity> entityList = courseDao.findAll();
		List<CoursePojo> pojoList = new ArrayList<>();

		for (CourseEntity entity : entityList) {
			CoursePojo pojo = new CoursePojo();
			BeanUtils.copyProperties(entity, pojo);

			// handle instructor safely
			if (entity.getInstructor() != null) {
				InstructorPojo instPojo = new InstructorPojo();
				BeanUtils.copyProperties(entity.getInstructor(), instPojo);
				pojo.setInstructor(instPojo);
			} else {
				pojo.setInstructor(null);
			}

			pojoList.add(pojo);
		}
		return pojoList;
	}



	@Override
	public Optional<CoursePojo> getCourseById(int CourseId) {
		
		 Optional<CourseEntity> optionalCourseEntity =courseDao.findById(CourseId);
		 if(optionalCourseEntity.isPresent()) {
			 CourseEntity eachCourseEntity= optionalCourseEntity.get(); //f the course entity exists, it is extracted from the Optional using the get method.
			 CoursePojo coursePojo = new CoursePojo();
				BeanUtils.copyProperties(eachCourseEntity, coursePojo);//copies the properties from the retrieved CourseEntity (eachCourseEntity) to the  CoursePojo .
				InstructorPojo authorPojo = new InstructorPojo();
				BeanUtils.copyProperties(eachCourseEntity.getInstructor(), authorPojo);
				coursePojo.setInstructor(authorPojo);
				return Optional.of(coursePojo);
			}
			return Optional.empty();
		 
	}

	@Override
	public void removeCourse(int CourseId) {
		courseDao.deleteById(CourseId);
		
	}

	@Override
	public CoursePojo addCourse(CoursePojo newCourse) {
		CourseEntity newCourseEntity = new CourseEntity();
		BeanUtils.copyProperties(newCourse, newCourseEntity);

		// Fetch instructor from DB using ID in request
		Integer instructorId = newCourse.getInstructor().getInstructorId();
		InstructorEntity instructor = instructorDao.findById(instructorId)
				.orElseThrow(() -> new RuntimeException("Instructor not found"));

		// Set instructor into course entity
		newCourseEntity.setInstructor(instructor);

		// Save course
		courseDao.saveAndFlush(newCourseEntity);

		// Set generated ID back into response
		newCourse.setCourseId(newCourseEntity.getCourseId());
		InstructorPojo instructorPojo = new InstructorPojo();
		instructorPojo.setInstructorId(instructor.getInstructorId());
		instructorPojo.setInstructorName(instructor.getInstructorName());
		instructorPojo.setContactNo(instructor.getContactNo());

		newCourse.setInstructor(instructorPojo);

        return newCourse;
    }


	@Override
	public CoursePojo updateCourse(CoursePojo updateCourse) {
		CourseEntity updateCourseEntity = new CourseEntity();
		BeanUtils.copyProperties(updateCourse, updateCourseEntity); 
		InstructorEntity instructorEntity = new InstructorEntity();
		BeanUtils.copyProperties(updateCourse.getInstructor(),instructorEntity);
		updateCourseEntity.setInstructor(instructorEntity);;
		
		courseDao.save(updateCourseEntity); 
		return updateCourse;
	}

	@Override
	public List<CoursePojo> getCourseByName(String CourseName) {
		List<CourseEntity> allCoursesEntity = courseDao.getAllCoursesByName(CourseName);
		List<CoursePojo> allCoursesPojo = new ArrayList<>();
		for(CourseEntity eachCourseEntity: allCoursesEntity) {
			CoursePojo coursePojo = new CoursePojo();
			BeanUtils.copyProperties(eachCourseEntity, coursePojo);
			InstructorPojo instructorPojo = new InstructorPojo();
			BeanUtils.copyProperties(eachCourseEntity.getInstructor(), instructorPojo);
			coursePojo.setInstructor(instructorPojo);
			allCoursesPojo.add(coursePojo);
		}
		return allCoursesPojo;
	}
}
