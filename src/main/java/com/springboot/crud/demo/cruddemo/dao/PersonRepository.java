package com.springboot.crud.demo.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.crud.demo.cruddemo.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
