package com.group.jdbcexample.model;

public class Customer {

	private String custId;
	private String custName;
	
	public Customer(String custId, String custName) {
		super();
		this.custId = custId;
		this.custName = custName;
	}

	
	/**
	 * @return the custId
	 */
	public String getCustId() {
		return custId;
	}


	/**
	 * @param custId the custId to set
	 */
	public void setCustId(String custId) {
		this.custId = custId;
	}


	/**
	 * @return the custName
	 */
	public String getCustName() {
		return custName;
	}


	/**
	 * @param custName the custName to set
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Customer [Customer Id=" + custId + ", CustomerName=" + custName + "]";
	}
	
}
