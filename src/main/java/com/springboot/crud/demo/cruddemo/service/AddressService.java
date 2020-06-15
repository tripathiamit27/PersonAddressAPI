package com.springboot.crud.demo.cruddemo.service;

import java.util.List;

import com.springboot.crud.demo.cruddemo.entity.Address;

public interface AddressService {

	public List<Address> findAll(Integer id);
	public Address findAddressById(Integer id, Integer addressId);
	public void addAddress(Integer id, List<Address> addressList);
	public Address findByIdAndPersonId(Integer addressId, Integer id);
	public void deleteAddress(Integer id, Integer addressId);
	public void updateAddress(Address address);
	
}
