package com.springboot.crud.demo.cruddemo.rest;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
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

import com.springboot.crud.demo.cruddemo.entity.Person;
import com.springboot.crud.demo.cruddemo.service.PersonService;



@SpringBootTest
public class PersonRestControllerTest{

	@Autowired
	  private WebApplicationContext webApplicationContext;
	  private MockMvc mockMvc;
	
	@Autowired
	@MockBean
	private PersonService service;
	
	
	@Test
	public void findPeopleSuccess()
	  throws Exception {
		Person person = new Person("Alex", "Thomas");
		person.setId(1);
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		 
	    List<Person> allEmployees = new ArrayList<Person>();
	    allEmployees.add(person);
	 
	    given(service.findAll()).willReturn(allEmployees);
	 
	    mockMvc.perform(get("/api/people")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(jsonPath("$", hasSize(1)))
	      .andExpect(jsonPath("$[0].firstName", is(person.getFirstName())));
	    
	}
	
	@Test
	public void findPersonByIdSuccess()
	  throws Exception {
		Person person = new Person("Alex", "Thomas");
		person.setId(1);
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		 
	    given(service.findPersonById(1)).willReturn(person);
	 
	    mockMvc.perform(get("/api/people/1")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(jsonPath("$.firstName", is(person.getFirstName())));
	    
	}
	
	@Test
	public void findPersonByIdFailure()
	  throws Exception {
		Person person = new Person("Alex", "Thomas");
		person.setId(1);
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		 
	    //given(service.findPersonById(2)).willThrow(new RuntimeException("Person id not found - " + 2));
	 
	    MvcResult mvcResult = mockMvc.perform(get("/api/people/2")
	  	      .contentType(MediaType.TEXT_PLAIN))
	  	      //.andExpect(new RuntimeException("Person id not found - " + 2))
	  	      .andReturn();
	  	      
	  	    String expectedErrorResponse = new String("Person not found for Person Id : " + 2);
	  	    String actualResponseBody = mvcResult.getResponse().getContentAsString();
	  	        mvcResult.getResponse().getContentAsString();
	  	    String expectedResponseBody = expectedErrorResponse;
	  	        assertThat(expectedResponseBody, containsString(actualResponseBody));

}
}
