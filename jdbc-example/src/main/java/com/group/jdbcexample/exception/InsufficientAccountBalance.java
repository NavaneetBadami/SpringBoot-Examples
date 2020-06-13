package com.group.jdbcexample.exception;

public class InsufficientAccountBalance extends Exception{

	public InsufficientAccountBalance() {
		super();
	}
	
	public InsufficientAccountBalance(String message) {
		super(message);
	}
}
