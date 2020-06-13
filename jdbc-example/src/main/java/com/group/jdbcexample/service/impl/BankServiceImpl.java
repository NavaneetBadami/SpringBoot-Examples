package com.group.jdbcexample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.group.jdbcexample.dao.BankDao;
import com.group.jdbcexample.exception.InsufficientAccountBalance;
import com.group.jdbcexample.model.Account;
import com.group.jdbcexample.service.BankService;

@Service
public class BankServiceImpl implements BankService{

	@Autowired
	BankDao bankDao;
	
	
	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED,readOnly=false,timeout=100,rollbackFor=Exception.class)
	public void transferFund(Account fromAccount, Account toAccount,
			Double amount) throws InsufficientAccountBalance {
		bankDao.deposit(fromAccount, toAccount, amount);
		bankDao.withdraw(toAccount, amount);
		
	}
}

