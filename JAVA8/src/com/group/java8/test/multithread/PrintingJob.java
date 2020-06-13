package com.group.java8.test.multithread;

public class PrintingJob implements Runnable{
	
	private PrinterQueue printerQueue;
	
	public PrintingJob(PrinterQueue printerQueue) {
		this.printerQueue = printerQueue;
	}
	
	@Override
	public void run() {
		 System.out.printf("%s: Going to print a document\n", Thread.currentThread().getName());
		 printerQueue.printJob(printerQueue);
	}
	
}
