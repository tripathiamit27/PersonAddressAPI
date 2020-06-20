package com.springboot.crud.demo.cruddemo.rest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.springboot.crud.demo.cruddemo.entity.Address;
import com.springboot.crud.demo.cruddemo.entity.Person;
import com.springboot.crud.demo.cruddemo.service.AddressService;

@SpringBootTest
public class AddressRestControllerTest {

	@Autowired
	  private WebApplicationContext webApplicationContext;
	  private MockMvc mockMvc;
	
	@Autowired
	@MockBean
	private AddressService service;
	
	@Test
	public void findAddressSuccess()
	  throws Exception {
		Address address = new Address();
		address.setCity("Hyderabad");
		address.setPostalCode("500088");
		address.setState("TEL");
		address.setStreet("10 Downing");
		address.setId(1);
		Person person = new Person("Alex", "Thomas");
		person.setId(1);
		address.setPerson(person);
		List<Address> addressList = new ArrayList<> ();
		addressList.add(address);
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		 
	 
	    given(service.findAll(1)).willReturn(addressList);
	 
	    mockMvc.perform(get("/api/people/1/addresses")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(jsonPath("$", hasSize(1)))
	      .andExpect(jsonPath("$[0].city", is(address.getCity())));
	    
	}
	
	@Test
	public void findAddressByIdSuccess()
	  throws Exception {
		Address address = new Address();
		address.setCity("Hyderabad");
		address.setPostalCode("500088");
		address.setState("TEL");
		address.setStreet("10 Downing");
		address.setId(1);
		Person person = new Person("Alex", "Thomas");
		person.setId(1);
		address.setPerson(person);
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		 
	    given(service.findAddressById(1, 1)).willReturn(address);
	 
	    mockMvc.perform(get("/api/people/1/addresses/1")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(jsonPath("$.state", is(address.getState())));
	    
	}
	
	@Test
	public void findAddressByIdFailure()
	  throws Exception {
		Address address = new Address();
		address.setCity("Hyderabad");
		address.setPostalCode("500088");
		address.setState("TEL");
		address.setStreet("10 Downing");
		address.setId(1);
		Person person = new Person("Alex", "Thomas");
		person.setId(1);
		address.setPerson(person);
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		 
	    
	 
	    MvcResult mvcResult = mockMvc.perform(get("/api/people/1/addresses/2")
	  	      .contentType(MediaType.TEXT_PLAIN))
	  	      .andReturn();
	  	      
	  	    String expectedErrorResponse = new String("Address not found for Person Id : 1");
	  	    String actualResponseBody = mvcResult.getResponse().getContentAsString();
	  	        mvcResult.getResponse().getContentAsString();
	  	    String expectedResponseBody = expectedErrorResponse;
	  	        assertThat(expectedResponseBody, containsString(actualResponseBody));

}


}
