package com.group.java8.test.multithread;

public class BankClient {

	public static void main(String[] args) throws InterruptedException {
		
		Account account = Account.getObjAccount();
		
		Thread[] threads = new Thread[3];
		for (int i = 0; i < threads.length; i++) {
			if(i == 2){
				threads[i] = new Thread(new AccountHolder(account, 6000),"Chickki-"+i); 
				threads[i].start();
				} else {
					threads[i] = new Thread(new AccountHolder(account, 2000),"Navaneet-"+i);
					threads[i].start();
				}
		}
	
		/*AccountHolder accountHolder1 = new AccountHolder(account, 6000);
		AccountHolder accountHolder2 = new AccountHolder(account, 2000);
		AccountHolder accountHolder3 = new AccountHolder(account, 2000);
		Thread thread1 = new Thread(accountHolder1);
		Thread thread2 = new Thread(accountHolder2);
		Thread thread3 = new Thread(accountHolder3);
		
		thread1.setName("Navaneet");
		thread2.setName("Chickki");
		thread3.setName("ROhan");
		
		thread1.start();
//		thread1.join();	
		thread2.start();
//		thread2.join();
		thread3.start();
//		thread3.join();
*/		
		
	}
	
}
