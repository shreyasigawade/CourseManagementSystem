package com.example.cmsspringbootjrestjdbcmavenproject.model;

import java.util.Objects;

public class InstructorPojo {

	private int InstructorId;
	private String InstructorName;
	private long ContactNo;
	
	public InstructorPojo(int instructorId, String instructorName, long contactNo) {
		super();
		InstructorId = instructorId;
		InstructorName = instructorName;
		ContactNo = contactNo;
	}
	public int getInstructorId() {
		return InstructorId;
	}
	public void setInstructorId(int instructorId) {
		InstructorId = instructorId;
	}
	public String getInstructorName() {
		return InstructorName;
	}
	public void setInstructorName(String instructorName) {
		InstructorName = instructorName;
	}
	public long getContactNo() {
		return ContactNo;
	}
	public void setContactNo(long contactNo) {
		ContactNo = contactNo;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(ContactNo, InstructorId, InstructorName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InstructorPojo other = (InstructorPojo) obj;
		return ContactNo == other.ContactNo && InstructorId == other.InstructorId
				&& Objects.equals(InstructorName, other.InstructorName);
	}
	@Override
	public String toString() {
		return "InstructorPojo [InstructorId=" + InstructorId + ", InstructorName=" + InstructorName + ", ContactNo="
				+ ContactNo + "]";
	}
	
	

}
