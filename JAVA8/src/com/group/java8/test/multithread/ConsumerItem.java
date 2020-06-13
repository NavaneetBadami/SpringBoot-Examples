package com.group.java8.test.multithread;

import java.util.concurrent.BlockingQueue;

public class ConsumerItem implements Runnable {

	private BlockingQueue<Integer> sharedQueue;

	public ConsumerItem(BlockingQueue<Integer> blockingQueue) {
		this.sharedQueue = blockingQueue;
	}

	@Override
	public void run() {
		boolean flag = true;
		try {
			while(flag){
				Integer i =	sharedQueue.take();
				System.err.println("CONSUMED: "+ i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
