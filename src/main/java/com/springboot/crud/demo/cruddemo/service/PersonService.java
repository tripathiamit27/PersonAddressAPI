package com.springboot.crud.demo.cruddemo.service;

import java.util.List;

import com.springboot.crud.demo.cruddemo.entity.Person;

public interface PersonService {

public List<Person> findAll();
	
	public Person findPersonById(Integer id);
	
	public void addPerson(Person person);
	
	public void deletePerson(Integer id);
}
