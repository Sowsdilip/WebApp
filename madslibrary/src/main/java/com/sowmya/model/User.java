package com.sowmya.model;

public class User implements Entity {

	private String name;
	// long userId;

	public User() {
		super();
	}

	public User(String uname) {
		super();
		this.name = uname;
	}

	public String getName() {
		return name;
	}

	public void setName(String uname) {
		this.name = uname;
	}

	public String toString() {
		return "User [uname=" + name + "]";
	}

}
