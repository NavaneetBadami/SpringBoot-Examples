package com.group.java8.test.multithread;

import java.util.Scanner;

class UserData {
	
	private volatile String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

class PC {
	
	public void producer(UserData userData) throws InterruptedException {
		
		synchronized (this) {
			Scanner sc = new Scanner(System.in);
			System.out.println(Thread.currentThread().getName() +" - Please Enter data");
			String data =  sc.next();
			userData.setName(data);
			wait();
			System.out.println(Thread.currentThread().getName() +" - RESUMED");
		}
	}
	
	public void consume(UserData userData) throws InterruptedException {
		
		Thread.sleep(1000);
		Scanner sc = new Scanner(System.in);
		
		synchronized (this) {
			
			System.out.print(Thread.currentThread().getName() +" - PRESS ENTER TO CONSUME");
			sc.nextLine();
			System.out.println(Thread.currentThread().getName() +" - Data CONSUMED - "+ userData.getName());
			
			// notifies the produce thread that it 
            // can wake up. 
            notify(); 

            // Sleep 
            Thread.sleep(1000); 
		}
	}
	
}


public class ProducerConsumer2 {

	public static void main(String[] args) throws InterruptedException {
		
		final PC pc = new PC();
		UserData userData = new UserData();
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				try {
					pc.producer(userData);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
			try {
				pc.consume(userData);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		});
		
		thread1.setName("Producer-Thread");
		thread2.setName("Consumer-Thread");
	
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
		
	}
}
