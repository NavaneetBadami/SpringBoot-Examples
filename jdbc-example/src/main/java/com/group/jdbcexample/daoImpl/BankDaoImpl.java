package com.group.jdbcexample.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.group.jdbcexample.dao.BankDao;
import com.group.jdbcexample.dao.mapper.AccountRowMapper;
import com.group.jdbcexample.exception.InsufficientAccountBalance;
import com.group.jdbcexample.model.Account;

@Repository
public class BankDaoImpl implements BankDao{

	@Autowired
	private JdbcTemplate jdbcTemplate; 

	@Override
	public void deposit(Account fromAccount, Account toAccount, Double amount) {

		System.out.println("====> Deposit request from Account: "+ fromAccount.getAccountNumber() +" To "+ toAccount.getAccountNumber());
		double accountBalance = this.getBalance(toAccount).getAccountBalance() +amount;
		String SQL="UPDATE bank set balance=? WHERE account_number=?";
		int update = jdbcTemplate.update(SQL, accountBalance, toAccount.getAccountNumber());
		if(update > 0){
			System.out.println("====> Amount Rs: "+amount+" is deposited to Account No: "+toAccount.getAccountNumber());
		}
	}

	@Override
	public void withdraw(Account fromAccount,Double amount) throws InsufficientAccountBalance {

		System.out.println("====> Withdraw request Amount"+ amount +" from "+ fromAccount.getAccountNumber());

		Account account = this.getBalance(fromAccount);
		if(account.getAccountBalance() >= amount) {
			
			System.out.println("====> AccountNo: "+fromAccount.getAccountNumber()+" Current Balance: "+account.getAccountBalance() );
			double balance = account.getAccountBalance() - amount;
		
			String SQL="UPDATE test.bank1 set balance=? WHERE account_number=?";
			int update = jdbcTemplate.update(SQL, balance, fromAccount.getAccountNumber());
			if(update > 0){
				System.out.println("===> Amount Rs: "+amount+" is Withdrawn from Account No: "+fromAccount.getAccountNumber());
			}
		} else {
			throw new InsufficientAccountBalance("****** INSUFFICIENT BALANCE *****" + account.getAccountBalance());
		}
	}

	private Account getBalance(Account account){

		String SQL ="SELECT * FROM test.bank WHERE account_number="+account.getAccountNumber();
		//Account acc = this.jdbcTemplate().queryForObject(SQL,new AccountRowMapper(), account.getAccountNumber());
		Account acc = jdbcTemplate.queryForObject(SQL,new AccountRowMapper());

		return acc;
	}
	
}
