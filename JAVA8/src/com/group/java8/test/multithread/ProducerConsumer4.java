package com.group.java8.test.multithread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

class Message {
	
	int MAX_SIZE = 5;
	private ArrayList<String> queue = new ArrayList<String>(5);
	public Message() {
		Collections.synchronizedList(queue);
	}
	
	public synchronized void putMessage(String message) {
		System.out.println(Thread.currentThread().getName() +" - "+ "PUT REQUEST: "+ message +" - "+ new Date());
		while(queue.size() == MAX_SIZE) {
			System.out.println(Thread.currentThread().getName() +" - "+ " --- QUEUE FULL, WAITING --- QUEUE SIZE: "+ queue.size());
			try { wait(); System.out.println(Thread.currentThread().getName() +" - "+ " --- QUEUE FREE NOW SIZE--- QUEUE SIZE: "+ queue.size() );} catch (InterruptedException e) { e.printStackTrace();}
		}
		System.out.println(Thread.currentThread().getName() +" - "+ "MESSAGE QUEUED: "+ message);
		queue.add(message);
		notify();
	}
	
	public synchronized void getMessage() {
		System.out.println(Thread.currentThread().getName() +" - "+ "SEND REQUEST..");
		while(queue.size() == 0) {
			System.out.println(Thread.currentThread().getName() +" - "+ " --- QUEUE EMPTY ---" );
			try { wait(); } catch (InterruptedException e) { e.printStackTrace();}
		}
		int random =  (int) ((Math.random() * queue.size()));
//		int random =  (int) ((queue.size() - 1));
		System.out.println(Thread.currentThread().getName() +" - "+ "SENT MESSAGE: "+queue.get(random) +" - "+ new Date());
		queue.remove(random);
		notify();
	}	
}

class ProducerMessage implements Runnable {
	private Message queueSystem;
	public ProducerMessage(Message queueSystem) {
		this.queueSystem = queueSystem;
	}
	
	@Override
	public void run() {
		int i = 0;
		while(true) {
			queueSystem.putMessage("MSG"+i++);
			try { Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		}
	}
}

class ConsumerMessage implements Runnable {
	private Message queueSystem;
	public ConsumerMessage(Message queueSystem) {
		this.queueSystem = queueSystem;
	}
	
	@Override
	public void run() {
		while(true) {
			queueSystem.getMessage();
			try { Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		}
	}
}

public class ProducerConsumer4 {
	public static void main(String[] args) {
		
		Message queueSystem = new Message();	
		new Thread(new ProducerMessage(queueSystem),"Queue-P :").start();
		new Thread(new ConsumerMessage(queueSystem),"Queue-C :").start();
	}
}
