package com.group.java8.test.multithread;



public class Account {

	private static volatile int balance = 6000;
	private String custName;
	private static Account accObj = null;
	
	private Account() {
		System.out.println("Thread: "+ Thread.currentThread().getName());
	}
	
	public synchronized static Account getObjAccount() { // Singleton 
		if(accObj == null) {
			accObj = new Account();
		} 
		return accObj;
	}
	
	public Account(String name) {
	//	this.balance = bal;
		this.custName = name;
	}
	public void withDraw(int amt, String name ) {
		if(amt <= balance){
			balance = balance - amt;
		} else {
			System.out.println("no sufficient balance");
		}
	}
	public int getBalance() {
		return balance;
	}
	public  void setBalance(int balance) {
		this.balance = balance;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	
	
}
