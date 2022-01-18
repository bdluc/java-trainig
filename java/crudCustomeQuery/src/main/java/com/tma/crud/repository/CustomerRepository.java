package com.tma.crud.repository;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tma.crud.entity.Customer;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Serializable> {

	@Modifying
	@Transactional
	@Query(value = "insert into Customer (id,customerName,customerEmail, phone) "
			+ "VALUES(:id,:customerName,:customerEmail,:phone)", nativeQuery = true)
	public void insertCustomerUsingQueryAnnotation(@Param("id") Long id, @Param("customerName") String customerName,
			@Param("customerEmail") String customerEmail, @Param("phone") String phone);

	@Modifying
	@Transactional
	@Query("update Customer s SET s.customerName = :customerName WHERE s.id = :id")
	public void updateCustomerUsingQueryAnnotation(@Param("customerName") String customerName, @Param("id") Long id);

	@Modifying
	@Transactional
	@Query("delete from Customer s where s.id = :id")
	public void deleteCustomerUsingQueryAnnotation(@Param("id") Long id);

	@Query("select s from Customer s where s.id = :id")
	public Customer findById(@Param("id") Long id);
}
