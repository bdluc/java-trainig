package com.springmvcjdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springmvcjdbc.entities.Customer;
import com.springmvcjdbc.service.CustomerService;

@RestController
public class CustomerRestController {
	@Autowired
	private CustomerService customerService;
	@GetMapping("/users")
	  public ResponseEntity<List<Customer>> getAllCustomer() {
	    return new ResponseEntity<List<Customer>>(customerService.findAll(), HttpStatus.OK);
	}
	
	@DeleteMapping("/users/{id}")
	  public ResponseEntity<String> doDeleteCustomer(@PathVariable int id) {
	    customerService.deleteById(id);
	    return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	  }
}