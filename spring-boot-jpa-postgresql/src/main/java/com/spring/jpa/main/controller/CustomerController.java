package com.spring.jpa.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.main.repository.CustomerRepository;
import com.spring.jpa.main.entity.Customer;

@RestController
public class CustomerController {
	@Autowired
    private CustomerRepository customerRepository;
	@GetMapping("/customers")
	public List<Customer> getAllCustomer() {
	    return customerRepository.findAll();
	}
	
	@DeleteMapping("/customers")
    public ResponseEntity<String> deleteAllById(@RequestBody List<Integer> listCustomerId){
		customerRepository.deleteAllById(listCustomerId);
        return new ResponseEntity<String>("Deleted", HttpStatus.OK);
    }
}
