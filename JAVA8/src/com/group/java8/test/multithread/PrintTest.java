package com.group.java8.test.multithread;

public class PrintTest {

	public static void main(String[] args) {
		
		PrinterQueue printerQueue = new PrinterQueue();
		
		Thread[] thread = new Thread[10];
		for (int i = 0; i < thread.length; i++) {
			thread[i] = new Thread(new PrintingJob(printerQueue),"Thread "+i);
		}
		
		for (int i = 0; i < thread.length; i++) {
			thread[i].start();
		}
	}
}
