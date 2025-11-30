package com.example.cmsspringbootjrestjdbcmavenproject.dao;

public class DBNativeSqlQueries {

	public static final String GetAllCourses = "SELECT courseId, courseName, location, courseFee, instructorId ,durationInWeeks,Course_level FROM course";
	public static final String AddCourse = "INSERT INTO course (coursename, location, coursefee, instructorId, durationInWeeks, Course_level) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String DeleteCourse ="delete from course where courseId= ? ";
    public static final String getCourse_By_ID ="select * from course where courseId= ? ";
    public static final String getCourseByName ="select  courseId,courseName, location, coursefee, instructorId, durationInWeeks, Course_level from course where courseName=? ";
    public static final String UpdateCourse ="Update course set coursename= ?, location =? ,coursefee =? ,durationInWeeks=? ,Course_level=? where courseId=?" ;
}
