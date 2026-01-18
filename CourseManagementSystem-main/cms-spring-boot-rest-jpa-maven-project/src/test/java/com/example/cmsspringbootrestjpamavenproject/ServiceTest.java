package com.example.cmsspringbootrestjpamavenproject;


import com.example.cmsspringbootrestjpamavenproject.dao.CourseDao;
import com.example.cmsspringbootrestjpamavenproject.dao.entity.CourseEntity;
import com.example.cmsspringbootrestjpamavenproject.dao.entity.InstructorEntity;
import com.example.cmsspringbootrestjpamavenproject.model.CoursePojo;
import com.example.cmsspringbootrestjpamavenproject.model.InstructorPojo;
import com.example.cmsspringbootrestjpamavenproject.service.CourseServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ServiceTest {

    @Mock
    CourseDao courseDao;

    @InjectMocks
    CourseServiceImpl courseService;

    private CourseEntity course1;

    CoursePojo coursePojo;


    @BeforeEach
    void setUp(){
        InstructorEntity instructorEntity = new InstructorEntity();
        instructorEntity.setInstructorId(1);
        instructorEntity.setInstructorName("John Doe");

        InstructorPojo instructorPojo = new InstructorPojo();
        instructorPojo.setInstructorId(1);
        instructorPojo.setInstructorName("John Doe");

        course1 = new CourseEntity();
        course1.setCourseId(101);
        course1.setCourseName("Java Basics");
        course1.setLocation("Pune");
        course1.setCourseFee(new BigDecimal("15000"));
        course1.setInstructor(instructorEntity);
        course1.setDurationInWeeks(6);
        course1.setCourseLevel("Beginner");

        coursePojo = new CoursePojo();
        coursePojo.setCourseId(101);
        coursePojo.setCourseName("Java Basics");
        coursePojo.setLocation("Pune");
        coursePojo.setCourseFee(new BigDecimal("15000"));
        coursePojo.setInstructor(instructorPojo);
        coursePojo.setDurationInWeeks(6);
        coursePojo.setLevel("Beginner");




    }

    @Test
    void testgetAllCourses(){
      when(courseDao.findAll()).thenReturn(Arrays.asList(course1));
      List<CoursePojo> coursePojos = courseService.getAllCourses();
        assertEquals(1, coursePojos.size());


    }

    @Test
    void testRemoveCourse() {
        // Arrange
        int courseId = 1;

        // Act
        courseService.removeCourse(courseId);

        // Assert
        verify(courseDao, times(1)).deleteById(courseId);
    }



}
