package com.tma.crud.service;

import org.springframework.stereotype.Component;

import com.tma.crud.entity.Customer;


@Component
public interface CustomerService {
	public String insertCustomer(Customer customer);

	public String updateCustomer(Customer customer);

	public String deleteCustomer(Customer customer);

	public Customer findById(Long id);
}