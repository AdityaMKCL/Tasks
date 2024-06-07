package com.app.entity;

public class Student {
	
	Integer roll;
	
	String name;
	 
	Integer marks;
	
	String school;
	
	String email;
	public Student(Integer roll, String name, Integer marks, String school,String email) {
		super();
		this.roll = roll;
		this.name = name;
		this.marks = marks;
		this.school = school;
		this.email = email;
	}


	public Student(String name, Integer marks, String school,String email) {
		super();
		this.name = name;
		this.marks = marks;
		this.school = school;
		this.email = email;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getRoll() {
		return roll;
	}

	public void setRoll(Integer roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	
}
