package com.group.jdbcexample.daoImpl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.group.jdbcexample.dao.CustomerDao;
import com.group.jdbcexample.model.Customer;

@Repository
public class CustomerDaoImpl extends JdbcDaoSupport implements CustomerDao{
	
	@Autowired
	private DataSource  dataSource;
	
	@PostConstruct
	private void initialize() {
		this.setDataSource(dataSource);  // JdbcDaoSupport
	}
	
	
	@Override
	public void insertCustomer(Customer customer) {
		String sql = "INSERT INTO customer " +"(custId, custName) VALUES (?, ?)" ;
		int res = this.getJdbcTemplate().update(sql, new Object[]{customer.getCustId(), customer.getCustName()});
		System.out.println("Customer Data inserted: "+ res);
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
