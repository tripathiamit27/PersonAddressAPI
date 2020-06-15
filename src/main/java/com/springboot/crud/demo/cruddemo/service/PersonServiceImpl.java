package com.springboot.crud.demo.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.crud.demo.cruddemo.dao.PersonRepository;
import com.springboot.crud.demo.cruddemo.entity.Person;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonRepository personRepository;
	
	@Autowired
	public PersonServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	@Override
	public List<Person> findAll() {
		return personRepository.findAll();
	}

	@Override
	public Person findPersonById(Integer id) {
		Optional<Person> result = personRepository.findById(id);
		Person employee = null;
		if(result.isPresent()) {
			employee = result.get();
		}
		return employee;
	}

	@Override
	public void addPerson(Person person) {

		personRepository.save(person);
	}


	@Override
	public void deletePerson(Integer id) {
		personRepository.deleteById(id);;
		
	}

}
