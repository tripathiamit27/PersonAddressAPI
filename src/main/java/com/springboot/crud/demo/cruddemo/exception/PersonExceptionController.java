package com.springboot.crud.demo.cruddemo.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PersonExceptionController {

	@ExceptionHandler(value = PersonNotFoundException.class)
	public ResponseEntity<String> exception(PersonNotFoundException perException) {

		return new ResponseEntity<>("Person not found for Person Id : " + perException.getId(), HttpStatus.NOT_FOUND);
	}
	
	/*@ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handlePostExceptions(Exception ex) {
        return new ResponseEntity("Id cannot be null", HttpStatus.INTERNAL_SERVER_ERROR);
    }*/
}
