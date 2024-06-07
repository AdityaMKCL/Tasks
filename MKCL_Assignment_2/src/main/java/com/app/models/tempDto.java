package com.app.models;

public class tempDto {

	private String name;
	
	private String lname;
	

	
	public tempDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public tempDto(String name, String lname) {
		super();
		this.name = name;
		this.lname = lname;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	


	@Override
	public String toString() {
		return "tempDto [name=" + name + ", lname=" + lname + "]";
	}
	
	
	
	
}
