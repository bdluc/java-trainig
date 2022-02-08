package com.tma.crud.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import com.tma.crud.config.CustomerHelper;
import com.tma.crud.entity.Customer;
import com.tma.crud.repository.CustomerRepository;
import com.tma.crud.service.CustomerService;

@Service("customerServiceImpl")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	@Transactional
	public String insertCustomer(Customer customer) {
		Long id = customer.getId();
		String customerName = customer.getCustomerName();
		String customerEmail = customer.getCustomerEmail();
		String phone = customer.getPhone();
		customerRepository.insertCustomerUsingQueryAnnotation(id, customerName, customerEmail, phone);
		return "Record inserted successfully using @Modifiying and @query Named Parameter";
	}

	@Transactional
	public String updateCustomer(Customer customer) {
		customerRepository.updateCustomerUsingQueryAnnotation(customer.getCustomerName(), customer.getId());
		return "Record updated successfully using @Modifiying and @query Named Parameter";
	}

	@Override
	@Transactional
	public String deleteCustomer(Customer customer) {
		customerRepository.deleteCustomerUsingQueryAnnotation(customer.getId());
		return "Record deleted successfully using @Modifiying and @query Named Parameter";
	}
	
	@Transactional
	public Customer findById(Long id) {
		Customer customerResponse = customerRepository.findById(id);
		return customerResponse;
	}

	/*
		upload excel
	*/

	@Override
	@Transactional(rollbackFor = IOException.class)
	public void save(MultipartFile file)  {

		Customer cus = new Customer();
		Customer customerEmail1 = customerRepository.existsByCustomerEmail(cus.getCustomerEmail());

			try {  
				List<Customer> customer = CustomerHelper.customerExcel(file.getInputStream());
				

				
				if (customerEmail1.equals(arg0)){
					
					
				} else {
					for (int i = 0 ; i < customer.size(); i++){
						customerRepository.saveAll(customer);
					}
					
				}
			} catch (IOException e) {
				throw new RuntimeException("fail excel data:" + e.getMessage());
			}
	}
}
