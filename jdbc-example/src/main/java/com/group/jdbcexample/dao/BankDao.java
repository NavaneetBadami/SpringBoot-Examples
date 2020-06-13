package com.group.jdbcexample.dao;

import com.group.jdbcexample.exception.InsufficientAccountBalance;
import com.group.jdbcexample.model.Account;


public interface BankDao {

	public abstract void deposit(Account fromAccount,Account toAccount,Double amount);
	public abstract void withdraw(Account fromAccount,Double amount) throws InsufficientAccountBalance;
	
}
