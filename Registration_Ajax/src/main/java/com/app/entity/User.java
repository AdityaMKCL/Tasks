package com.app.entity;

public class User {
	private Integer uid;
	private String fname;
	private String lname;
	private String state;
	private String city;
	public User(Integer uid, String fname, String lname, String state, String city) {
		super();
		this.uid = uid;
		this.fname = fname;
		this.lname = lname;
		this.state = state;
		this.city = city;
	}
	public User(String fname, String lname, String state, String city) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.state = state;
		this.city = city;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", fname=" + fname + ", lname=" + lname + ", state=" + state + ", city=" + city
				+ "]";
	}
}
