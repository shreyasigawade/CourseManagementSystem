package com.example.cmsspringbootrestjpamavenproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cmsspringbootrestjpamavenproject.dao.InstructorDao;
import com.example.cmsspringbootrestjpamavenproject.dao.entity.CourseEntity;
import com.example.cmsspringbootrestjpamavenproject.dao.entity.InstructorEntity;
import com.example.cmsspringbootrestjpamavenproject.model.CoursePojo;
import com.example.cmsspringbootrestjpamavenproject.model.InstructorPojo;

@Service
public class InstructorServiceImpl implements InstructorService{
	
	@Autowired
	InstructorDao instructorDao;

	@Override
	public List<InstructorPojo> fetchAllInstructors() {
		List<InstructorEntity> allInstructorsEntity = instructorDao.findAll();
		List<InstructorPojo> allInstructorsPojo = new ArrayList<>();

		for (InstructorEntity eachInstructorEntity : allInstructorsEntity) {
			InstructorPojo instructorPojo = new InstructorPojo();
			BeanUtils.copyProperties(eachInstructorEntity, instructorPojo);

			List<CoursePojo> allCoursesPojo = new ArrayList<>();
			for (CourseEntity eachCourseEntity : eachInstructorEntity.getAllcourses()) {
				CoursePojo coursePojo = new CoursePojo();
				BeanUtils.copyProperties(eachCourseEntity, coursePojo);
				allCoursesPojo.add(coursePojo);   // ✔️ Add course here
			}

			instructorPojo.setAllCourses(allCoursesPojo);
			allInstructorsPojo.add(instructorPojo); // ✔️ Add instructor once
		}
		return allInstructorsPojo;
	}


	@Override
	public Optional<InstructorPojo> fetchAInstructorById(int instructorId) {
		Optional<InstructorEntity> optionInstructorEntity = instructorDao.findById(instructorId);
		if(optionInstructorEntity.isPresent()) {
			InstructorEntity instructorEntity = optionInstructorEntity.get();
			InstructorPojo instructorPojo = new InstructorPojo();
			BeanUtils.copyProperties(instructorEntity, instructorPojo);
			List<CoursePojo> allCoursesPojo = new ArrayList<>();
			for(CourseEntity eachCourseEntity: instructorEntity.getAllcourses()) {
				CoursePojo coursePojo = new CoursePojo();
				BeanUtils.copyProperties(eachCourseEntity, coursePojo);
				allCoursesPojo.add(coursePojo);		
			}
			instructorPojo.setAllCourses(allCoursesPojo);
			return Optional.of(instructorPojo);
		}
		return Optional.empty();
	}

	@Override
	public void removeInstructor(int instructorId) {
		instructorDao.deleteById(instructorId);
		
	}

	@Override
	public InstructorPojo addInstructor(InstructorPojo newInstructor) {
		InstructorEntity instructorEntity = new InstructorEntity();
	    BeanUtils.copyProperties(newInstructor, instructorEntity);
	    InstructorEntity savedInstructorEntity = instructorDao.save(instructorEntity);
	    InstructorPojo savedInstructorPojo = new InstructorPojo();
	    BeanUtils.copyProperties(savedInstructorEntity, savedInstructorPojo);
	    return savedInstructorPojo;
		
	}

	@Override
	public InstructorPojo updateInstructor(InstructorPojo updateInstructor) {
		Optional<InstructorEntity> optionalInstructorEntity = instructorDao.findById(updateInstructor.getInstructorId());
	    if (optionalInstructorEntity.isPresent()) {
	        InstructorEntity instructorEntity = optionalInstructorEntity.get();
	        BeanUtils.copyProperties(updateInstructor, instructorEntity);
	        InstructorEntity updatedInstructorEntity = instructorDao.save(instructorEntity);
	        InstructorPojo updatedInstructorPojo = new InstructorPojo();
	        BeanUtils.copyProperties(updatedInstructorEntity, updatedInstructorPojo);
	        return updatedInstructorPojo;
	    }
	    return null; // or throw an exception indicating instructor not found
	}

}
