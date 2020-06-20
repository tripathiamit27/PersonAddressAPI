package com.springboot.crud.demo.cruddemo.exception;

public class AddressNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String id;
	
	
	public AddressNotFoundException(String id) {
		super();
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
