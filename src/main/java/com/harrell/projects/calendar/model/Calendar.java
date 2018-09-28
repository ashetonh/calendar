package com.harrell.projects.calendar.model;

public class Calendar {

	private User user;
	private String name;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Calendar [user=" + user + ", name=" + name + "]";
	}
	
	
}
