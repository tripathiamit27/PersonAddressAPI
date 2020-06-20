package com.springboot.crud.demo.cruddemo.exception;

public class PersonNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String id;
	
	public PersonNotFoundException(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
