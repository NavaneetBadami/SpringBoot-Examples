package com.group.java8.test.multithread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class MyRunnable implements Callable<MyRunnable> {

	private final long waitTime;
	
	public MyRunnable(long waitTime) {
		this.waitTime = waitTime;
	}
	
	@Override
	public MyRunnable call() throws Exception {
		try { 
            // sleep for user given millisecond 
            // before checking again 
            Thread.sleep(waitTime); 
  
            // return current thread name 
            System.out.println(Thread.currentThread().getName()); 
        } 
  
        catch (InterruptedException ex) { 
           System.out.println(ex.getLocalizedMessage()); 
        } 
		return null;
	}
	
	@Override
	public String toString() {
		return Thread.currentThread().getName()+"-Executed";
	}
}


public class CallableExample {
	
	public static void main(String[] args) {
		
		MyRunnable myRunnable1 = new MyRunnable(1000);
		MyRunnable myRunnable2 = new MyRunnable(3000);
		
		FutureTask<MyRunnable> futureTask1 = new FutureTask<>(myRunnable1); 
		FutureTask<MyRunnable> futureTask2 = new FutureTask<>(myRunnable2); 
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.submit(futureTask1);
		executorService.submit(futureTask2);
		
		 while (true) { 
	            try { 
	  
	                // if both future task complete 
	                if (futureTask1.isDone() && futureTask2.isDone()) { 
	  
	                    System.out.println("Both FutureTask Complete"); 
	  
	                    // shut down executor service 
	                    executorService.shutdown(); 
	                    return; 
	                } 
	  
	                if (!futureTask1.isDone()) { 
	  
	                    // wait indefinitely for future 
	                    // task to complete 
	                    System.out.println("FutureTask1 output = " + futureTask1.get()); 
	                } 
	  
	                System.out.println("Waiting for FutureTask2 to complete"); 
	  
	                // Wait if necessary for the computation to complete, 
	                // and then retrieves its result 
	                Callable<MyRunnable> s = futureTask2.get(250, TimeUnit.MILLISECONDS); 
	  
	                if (s != null) { 
	                    System.out.println("FutureTask2 output=" + s); 
	                } 
	            } 
	  
	            catch (Exception e) { 
	                System.out.println("Exception: " + e); 
	            } 
	        } 
	}
	
}
