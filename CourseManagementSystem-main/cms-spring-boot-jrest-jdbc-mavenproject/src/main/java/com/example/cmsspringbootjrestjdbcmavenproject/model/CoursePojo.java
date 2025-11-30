package com.example.cmsspringbootjrestjdbcmavenproject.model;

import java.util.Objects;

import jakarta.validation.constraints.NotNull;

public class CoursePojo {
	 private int CourseId;
	 
	    @NotNull
	    private String CourseName;
	    
	    @NotNull
	    private String Location;
	    
	    @NotNull
	    private int CourseFee;
	    
	    @NotNull
	    private int durationInWeeks;
	    private String level;
	    
	    
	    private InstructorPojo instructor;
	    
		public CoursePojo(int courseId, String courseName, String location, int courseFee, int durationInWeeks,String level, InstructorPojo instructor) {
			super();
			CourseId = courseId;
			CourseName = courseName;
			Location = location;
			CourseFee = courseFee;
			this.durationInWeeks =durationInWeeks;
			this.level =level;
			this.instructor = instructor;
		}

		public int getCourseId() {
			return CourseId;
		}

		public void setCourseId(int courseId) {
			CourseId = courseId;
		}

		public String getCourseName() {
			return CourseName;
		}

		public void setCourseName(String courseName) {
			CourseName = courseName;
		}

		public String getLocation() {
			return Location;
		}

		public void setLocation(String location) {
			Location = location;
		}

		public int getCourseFee() {
			return CourseFee;
		}

		public void setCourseFee(int courseFee) {
			CourseFee = courseFee;
		}

		public int getDurationInWeeks() {
			return durationInWeeks;
		}

		public void setDurationInWeeks(int durationInWeeks) {
			this.durationInWeeks = durationInWeeks;
		}

		public String getLevel() {
			return level;
		}

		public void setLevel(String level) {
			this.level = level;
		}

		public InstructorPojo getInstructor() {
			return instructor;
		}

		public void setInstructor(InstructorPojo instructor) {
			this.instructor = instructor;
		}

		
		
		@Override
		public int hashCode() {
			return Objects.hash(CourseFee, CourseId, CourseName, Location, durationInWeeks, instructor, level);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CoursePojo other = (CoursePojo) obj;
			return CourseFee == other.CourseFee && CourseId == other.CourseId
					&& Objects.equals(CourseName, other.CourseName) && Objects.equals(Location, other.Location)
					&& durationInWeeks == other.durationInWeeks && Objects.equals(instructor, other.instructor)
					&& Objects.equals(level, other.level);
		}

		@Override
		public String toString() {
			return "CoursePojo [CourseId=" + CourseId + ", CourseName=" + CourseName + ", Location=" + Location
					+ ", CourseFee=" + CourseFee + ", durationInWeeks=" + durationInWeeks + ", level=" + level
					+ ", instructor=" + instructor + "]";
		}
		
		
		
}