package com.example.cmsspringbootrestjpamavenproject;

import com.example.cmsspringbootrestjpamavenproject.dao.CourseDao;
import com.example.cmsspringbootrestjpamavenproject.dao.InstructorDao;
import com.example.cmsspringbootrestjpamavenproject.dao.entity.CourseEntity;
import com.example.cmsspringbootrestjpamavenproject.dao.entity.InstructorEntity;
import com.example.cmsspringbootrestjpamavenproject.model.CoursePojo;
import com.example.cmsspringbootrestjpamavenproject.model.InstructorPojo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@ActiveProfiles("test")
public class CourseIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    InstructorDao instructorDao;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    ObjectMapper objectMapper;


    @Test
    void shouldCreateCourse() throws Exception {
        InstructorEntity instructorEntity = new InstructorEntity();
        instructorEntity.setInstructorName("john abbas");
        instructorEntity.setContactNo("eeee");
        instructorDao.save(instructorEntity);

        String requestJson = """
                {
                  "courseId": 10,
                  "courseName": "Java",
                  "courseFee": 5000,
                  "location": "Mumbai",
                  "courseLevel": "Beginner",
                  "durationInWeeks": 8,
                  "instructor": {
                    "instructorId": 1,
                    "instructorName": "John Smith",
                    "contactNo": "745698122"
                  }
                }
               
                """.formatted(instructorEntity.getInstructorId());

        mockMvc.perform(
                        post("/v1/api/courses")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestJson)
                )
                // STEP 4: Validate response
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.courseId").exists())
                .andExpect(jsonPath("$.courseName").value("Java"))
                .andExpect(jsonPath("$.instructor.instructorId").exists());

    }

    @Test
    void shouldRemoveCourse() throws Exception {
        CourseEntity course = new CourseEntity();
        course.setCourseName("java");
        course.setCourseFee(BigDecimal.ONE);
        course = courseDao.save(course);

        int courseId = course.getCourseId();


        mockMvc.perform(delete("/api/courses/{courseId}", courseId)
        ).andExpect(status().isOk());
        boolean exists = courseDao.existsById(courseId);
        assertFalse(exists);


    }

    @Test
    void shouldReturnAllCourses() throws Exception {
        mockMvc.perform(get("/v1/api/courses")).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].courseName").value("Java "));
    }

    @Test
    void shouldUpdateCourses() throws Exception {
        CoursePojo coursePojo = new CoursePojo();
        coursePojo.setCourseId(1);
        coursePojo.setCourseName("dgrtgrt");
        coursePojo.setCourseFee(BigDecimal.valueOf(4000));
        coursePojo.setInstructor(new InstructorPojo(1,"john", "789990", List.of(coursePojo)));
        coursePojo.setLevel("beginner");
        coursePojo.setDurationInWeeks(12);
        coursePojo.setLocation("mumbai");

        mockMvc.perform(put("/v1/api/courses").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(coursePojo))).andExpect(status().isOk())
                .andExpect(jsonPath("$.courseName").value("dgrtgrt"));

    }

/*
{
  "courseId": 1,
  "courseName": "Java",
  "courseFee": 5000,
  "location": "Mumbai",
  "courseLevel": "Beginner",
  "durationInWeeks": 8,
  "instructor": {
    "instructorId": 1,
    "instructorName": "John Smith",
    "contactNo": "9876543210"
  }
}

 */
}
