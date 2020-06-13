package com.group.jdbcexample.service;

import com.group.jdbcexample.exception.InsufficientAccountBalance;
import com.group.jdbcexample.model.Account;


public interface BankService {

	public abstract void transferFund(Account fromAccount,Account toAccount,Double amount)
			throws InsufficientAccountBalance;
	
}
