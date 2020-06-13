package com.group.java8.test.multithread;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerSolution {

	public static void main(String[] args) {
		
//		BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(15);
		BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<Integer>();
				
		ProducerItem producerItem = new ProducerItem(blockingQueue);
		ConsumerItem consumerItem = new ConsumerItem(blockingQueue);
		
		new Thread(producerItem).start();
		new Thread(consumerItem).start();
		
	}	
}
