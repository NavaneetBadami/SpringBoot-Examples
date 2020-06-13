package com.group.jdbcexample.service;

import java.util.List;

import com.group.jdbcexample.model.Customer;

public interface CustomerService {

	void insertCustomer(Customer customer);
	void insertCustomers(List<Customer> employees);
	void getAllCustomers();
	void getCustomerById(String custId);
	
}
