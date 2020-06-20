package com.springboot.crud.demo.cruddemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AddressExceptionController {

	@ExceptionHandler(value = AddressNotFoundException.class)
	public ResponseEntity<String> exception(AddressNotFoundException addrException) {

		return new ResponseEntity<>("Address not found for Person Id : " + addrException.getId(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handlePostExceptions(Exception ex) {
        return new ResponseEntity("Id cannot be null", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
