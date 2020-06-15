package com.springboot.crud.demo.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.crud.demo.cruddemo.dao.AddressRepository;
import com.springboot.crud.demo.cruddemo.dao.PersonRepository;
import com.springboot.crud.demo.cruddemo.entity.Address;
import com.springboot.crud.demo.cruddemo.entity.Person;

@Service
public class AddressServiceImpl implements AddressService {

	private AddressRepository addressRepository;
	private PersonRepository personRepository;
	
	
	@Autowired
	public AddressServiceImpl(AddressRepository addressRepository, PersonRepository personRepository) {
		this.addressRepository = addressRepository;
		this.personRepository = personRepository;
	}

	@Override
	public List<Address> findAll(Integer id) {
		return addressRepository.findByPersonId(id).get();
	}

	@Override
	public Address findAddressById(Integer id, Integer addressId) {
		return addressRepository.findByIdAndPersonId(addressId, id).get();
	}
	

	@Override
	public void addAddress(Integer id, List<Address> addressList) {

		Person person = personRepository.findById(id).get();
		for (Address address : addressList) {
			address.setPerson(person);
			addressRepository.save(address);
		}
	}

	@Override
	public Address findByIdAndPersonId(Integer addressId, Integer id) {
		return addressRepository.findByIdAndPersonId(addressId, id).get();
	}

	@Override
	public void deleteAddress(Integer id, Integer addressId) {
		Address address = addressRepository.findByIdAndPersonId(addressId, id).get();
		addressRepository.delete(address);
		
	}

	@Override
	public void updateAddress(Address address) {
		addressRepository.save(address);
		
	}

}
