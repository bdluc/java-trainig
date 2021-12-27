package com.spring.jpa.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.jpa.main.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}