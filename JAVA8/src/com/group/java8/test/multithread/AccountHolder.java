package com.group.java8.test.multithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountHolder implements Runnable{

	private Account account;
	private int amount;
	private static Lock lock = null;
	
	public AccountHolder(Account account, int amount) {
		this.account = account;
		this.amount = amount;
		lock =  new ReentrantLock();
	}

	@Override
	public void run() {
		this.withDrawAmmount(amount);
	}
	
	public void withDrawAmmount(int withdrawAmount) {
		System.out.println(Thread.currentThread().getName()	+ " withdraw Request - $"+withdrawAmount);
		
		try {
			/*	Using Lock Interface */
			lock.lock();
			if (account.getObjAccount().getBalance() >= withdrawAmount) {
				System.out.println(Thread.currentThread().getName()	+ " is going to withdraw $"+withdrawAmount);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException ex) {
				}
				account.getObjAccount().withDraw(withdrawAmount, account.getCustName());
				System.out.println(Thread.currentThread().getName()	+ " completes the withdrawal of $"+withdrawAmount);
			} else {
				System.out.println("Not enough in account for "	+ Thread.currentThread().getName() + " to withdraw $"+withdrawAmount +", balance $"
						+ account.getBalance());
			}
		}catch(Exception e) {
				System.out.println(e.getMessage());
		} finally {
			lock.unlock();
		}
		
		
		
		 /*  Using Synchronized Block*/
		  
//		synchronized (account) {
//			if (account.getObjAccount().getBalance() >= withdrawAmount) {
//				System.out.println(Thread.currentThread().getName()	+ " is going to withdraw $"+withdrawAmount);
//				try {
//					Thread.sleep(3000);
//				} catch (InterruptedException ex) {
//				}
//				account.getObjAccount().withDraw(withdrawAmount, account.getCustName());
//				System.out.println(Thread.currentThread().getName()	+ " completes the withdrawal of $"+withdrawAmount);
//			} else {
//				System.out.println("Not enough in account for "	+ Thread.currentThread().getName() + " to withdraw "
//						+ account.getBalance());
//			}
//		}
	}
}
