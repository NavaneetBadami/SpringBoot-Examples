package com.group.jdbcexample.dao;

import java.util.List;

import com.group.jdbcexample.model.Customer;

public interface CustomerDao {

	void insertCustomer(Customer customer);
	void insertCustomers(List<Customer> employees);
	void getAllCustomers();
	void getCustomerById(String custId);
	
}
