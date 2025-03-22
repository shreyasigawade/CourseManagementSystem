package com.example.cmsspringbootrestjpamavenproject.dao;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.cmsspringbootrestjpamavenproject.dao.entity.CourseEntity;



@Repository
public interface CourseDao extends JpaRepository<CourseEntity, Integer> {  //primary key of the CourseEntity is of type integer.
	 @Query("SELECT c FROM CourseEntity c WHERE c.courseName = ?1")
	    List<CourseEntity> getAllCoursesByName(String courseName);
}
//This is the JPQL query string. It's similar to SQL but operates on entity objects rather than database tables
//?1 is a positional parameter placeholder. It indicates that the value for the courseName parameter will be provided
//as the first parameter when calling the method.

/*
 * if you have a BookEntity class with a property named bookGenre, Spring Data JPA can automatically generate a query method named
 *  findByBookGenre.
 *   @Query annotation to define a custom JPQL query.
With @Query, you provide the JPQL query string directly in the annotation's value attribute.
This approach offers more flexibility and allows you to write complex queries that cannot be expressed using the method naming convention.
Here, the method name doesn't matter. You can name your method anything you want, as long as it's a valid Java method name.a
 */
