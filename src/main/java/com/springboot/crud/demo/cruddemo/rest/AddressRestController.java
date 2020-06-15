package com.springboot.crud.demo.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crud.demo.cruddemo.entity.Address;
import com.springboot.crud.demo.cruddemo.service.AddressService;

@RestController
@RequestMapping("/api")
public class AddressRestController {

	private AddressService addressService;
	
	@Autowired
	public AddressRestController(AddressService addressService) {
		this.addressService = addressService;
	}
	
	@GetMapping("/people/{id}/addresses")
	public @ResponseBody List<Address> findAllAddress(@PathVariable(value = "id") Integer id) {
		return addressService.findAll(id);
	}
	
	@GetMapping("/people/{id}/addresses/{addressId}")
	public Address findAddressById(@PathVariable Integer id, @PathVariable Integer addressId) {
		Address address = addressService.findAddressById(id, addressId);
		if(address == null) {
			throw new RuntimeException("Address id not found - " + id);
		}
		
		return address;
	}
	
	@PostMapping("/people/{id}/addresses")
	public List<Address> addAddress(@PathVariable Integer id, @RequestBody List<Address> addressList) {
		//employee.setId(new Integer(0));
		addressService.addAddress(id, addressList);
		return addressList;
	}
	
	@PutMapping("/people/{id}/addresses/{addressId}")
	public Address updatePerson(@PathVariable Integer id, @PathVariable Integer addressId, @RequestBody Address address) {
		Address addressToUpdate = addressService.findByIdAndPersonId(addressId, id);
		if(addressToUpdate == null) {
			throw new RuntimeException("Address id not found - " + id);
		}
		addressToUpdate.setCity(address.getCity());
		addressToUpdate.setPostalCode(address.getPostalCode());
		addressToUpdate.setState(address.getState());
		addressToUpdate.setStreet(address.getStreet());
		addressService.updateAddress(addressToUpdate);
		return addressToUpdate;
	}
	
	@DeleteMapping("/people/{id}/addresses/{addressId}")
	public String deletAddress(@PathVariable Integer id, @PathVariable Integer addressId) {
		Address addressToDelete = addressService.findByIdAndPersonId(addressId, id);
		if(addressToDelete == null) {
			throw new RuntimeException("Address id not found - " + id);
		}
		addressService.deleteAddress(id, addressId);
		return id.toString()+ "::" + addressId.toString();
	}
}
