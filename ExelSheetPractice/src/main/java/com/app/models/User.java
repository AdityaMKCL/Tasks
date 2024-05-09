package com.app.models;

public class User {
	private Long userId;
	private String name;
	private String city;
	public User(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}
	public User() {
		super();
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", city=" + city + "]";
	}
	
	
}
