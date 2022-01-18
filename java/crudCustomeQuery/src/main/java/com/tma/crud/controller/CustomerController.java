package com.tma.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tma.crud.entity.Customer;
import com.tma.crud.service.CustomerService;


@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public String insertCustomer(@RequestBody Customer customer) {
		String response = customerService.insertCustomer(customer);
		return response;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	@ResponseBody
	public String updateCustomer(@RequestBody Customer customer) {
		String response = customerService.updateCustomer(customer);
		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Customer getCustomer(@PathVariable Long id) {
		Customer customer = customerService.findById(id);
		return customer;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteCustomer(@RequestBody Customer customer) {
		String response = customerService.deleteCustomer(customer);
		return response;
	}
}