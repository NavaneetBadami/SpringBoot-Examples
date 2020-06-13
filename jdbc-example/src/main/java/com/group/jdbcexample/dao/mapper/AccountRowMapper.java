package com.group.jdbcexample.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.group.jdbcexample.model.Account;

public class AccountRowMapper implements RowMapper<Account>{

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Account account = new Account();
		account.setAccountBalance(rs.getDouble("balance"));
		account.setAccountHolderName(rs.getString("holder_name"));
		account.setAccountNumber(rs.getString("account_number"));
		account.setAccountType(rs.getString("account_type"));
		return account;
	}
}
