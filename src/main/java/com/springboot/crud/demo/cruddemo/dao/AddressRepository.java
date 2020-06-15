package com.springboot.crud.demo.cruddemo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.crud.demo.cruddemo.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

	Optional<Address> findByIdAndPersonId(Integer id, Integer personId);
	Optional<List<Address>> findByPersonId(Integer personId);
}
