package com.group.jdbcexample.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.jdbcexample.dao.CustomerDao;
import com.group.jdbcexample.model.Customer;
import com.group.jdbcexample.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public void insertCustomer(Customer customer) {
		this.customerDao.insertCustomer(customer);
	}

	@Override
	public void insertCustomers(List<Customer> employees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAllCustomers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getCustomerById(String custId) {
		// TODO Auto-generated method stub
		
	}

	
	
}
