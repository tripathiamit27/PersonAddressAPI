package com.springboot.crud.demo.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crud.demo.cruddemo.entity.Person;
import com.springboot.crud.demo.cruddemo.exception.PersonNotFoundException;
import com.springboot.crud.demo.cruddemo.service.PersonService;

@RestController
@RequestMapping("/api")
public class PersonRestController {

	private PersonService personService;

	@Autowired
	public PersonRestController(PersonService personService) {
		
		this.personService = personService;
	}
	
	@GetMapping("/people")
	public List<Person> findAllPerson() {
		return personService.findAll();
	}
	
	@GetMapping("/people/count")
	public Integer findPersonCount() {
		return personService.findAll().size();
	}
	
	@GetMapping("/people/{id}")
	public Person findPersonById(@PathVariable Integer id) {
		Person person = personService.findPersonById(id);
		if(person == null) {
			throw new PersonNotFoundException(id.toString());
		}
		
		return person;
	}
	
	@PostMapping("/people")
	public Person addPerson( @RequestBody Person person) {
		//employee.setId(new Integer(0));
		personService.addPerson(person);
		return person;
	}
	
	@PutMapping("/people/{id}")
	public Person updatePerson(@PathVariable Integer id, @RequestBody Person person) {
		Person personToUpdate = personService.findPersonById(id);
		if(personToUpdate == null) {
			throw new PersonNotFoundException(id.toString());
		}
		personService.addPerson(person);
		return person;
	}
	
	@DeleteMapping("/people/{id}")
	public String deletPerson(@PathVariable Integer id) {
		Person personToDelete = personService.findPersonById(id);
		if(personToDelete == null) {
			throw new PersonNotFoundException(id.toString());
		}
		personService.deletePerson(id);
		return id.toString();
	}
}
