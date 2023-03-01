package com.sowmya.model;

import java.util.ArrayList;

public class UserBooks implements Entity {

	private String userName;
	private ArrayList<String> books = new ArrayList<>();
	
	public UserBooks() {
		super();
	}

	public UserBooks(String uname) {
		super();
		this.userName = uname;
	}
	
	public String getName() {
		// TODO Auto-generated method stub
		return userName;
	}
	
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.userName = name;
	}
	
	public ArrayList<String> getUserBooks() {
		// TODO Auto-generated method stub
		return books;
	}
	
	public void setUserBooks(ArrayList<String> names) {
		// TODO Auto-generated method stub
		this.books = names;
	}
	
}