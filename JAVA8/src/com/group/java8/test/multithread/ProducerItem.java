package com.group.java8.test.multithread;

import java.util.concurrent.BlockingQueue;

public class ProducerItem implements Runnable{
	
	private BlockingQueue<Integer> sharedQueue;
	
	public ProducerItem(BlockingQueue<Integer> blockingQueue) {
		this.sharedQueue = blockingQueue;
	}
	
	@Override
	public void run() {
		try {
			for (int i = 1; i <= 10; i++) {
				System.out.println("PRODUCED: " + i);
				sharedQueue.put(i);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
