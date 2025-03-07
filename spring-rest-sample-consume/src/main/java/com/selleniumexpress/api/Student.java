package com.selleniumexpress.api;

import java.io.Serializable;

public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9147377968919166468L;

	private int id;

	private String name;
	private String country;
	
	
	

	public Student() {
		
	}

	public Student(int id, String name, String country) {
	
		this.id = id;
		this.name = name;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", country=" + country + "]";
	}

}
