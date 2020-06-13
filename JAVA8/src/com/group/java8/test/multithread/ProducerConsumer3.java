package com.group.java8.test.multithread;

class RecordCount {

	private volatile int num;
	boolean valPut = false;

	public void put(int val) {
		synchronized (this) {
			if(valPut) {
				try {this.wait();} catch (InterruptedException e) { e.printStackTrace();}
			} else {
				this.num = val;
				System.out.println(Thread.currentThread().getName() +" - "+ num);
				valPut = true;
				this.notify();
			}	
		}
	}

	public int get() {
		synchronized (this) {
			if(!valPut) {
				try {this.wait();} catch (InterruptedException e) { e.printStackTrace();}
			} else {
				System.out.println(Thread.currentThread().getName() +" - "+ num);
				valPut = false;
				this.notify();
			}
		}
		return num;
	}
}

class Producer implements Runnable {

	RecordCount recCount;
	public Producer(RecordCount recordCount) {
		this.recCount = recordCount;
	}

	@Override
	public void run() {
		int i = 0;
		while(true) {
			recCount.put(i++);
			try {Thread.sleep(1000);} catch (Exception e) {}
		}		
	}
}

class Consumer implements Runnable {
	RecordCount recCount;
	public Consumer(RecordCount recordCount) {
		this.recCount = recordCount;
	}

	@Override
	public void run() {
		while(true) {
			recCount.get();
			try {Thread.sleep(1000);} catch (Exception e) {}
		}	
	}
}

public class ProducerConsumer3 {

	public static void main(String[] args) {
		RecordCount recordCount = new RecordCount();
		new Thread(new Producer(recordCount),"Producer").start();
		new Thread(new Consumer(recordCount),"Consumer").start();
	}
}
