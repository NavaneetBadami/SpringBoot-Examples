package com.group.java8.test.multithread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class CallableEample implements Callable {
	
	@Override
	public Object call() throws Exception {
		
		System.out.println(Thread.currentThread().getName()+" - Getting Random number");
		Integer obj = getRandom();
		return obj;
	}
	
	private int getRandom() throws InterruptedException{
		Random random = new Random();
		Integer integer = random.nextInt(5);
		Thread.sleep(integer * 1000);
		return integer;
	}
	
}


public class CallableTest1 {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		FutureTask<CallableEample>[] randomNumberTasks = new FutureTask[5]; 
		
		for (int i = 0; i < 5; i++) {
			CallableEample callableEample = new CallableEample();
			 randomNumberTasks[i] = new FutureTask(callableEample); 
			  
		      // As it implements Runnable, create Thread 
		      // with FutureTask 
		      Thread t = new Thread(randomNumberTasks[i],"Thread-"+i); 
		      t.start(); 
		}
		System.out.println("------------------");
		for (int i = 0; i < 5; i++) 
	    { 
	      // As it implements Future, we can call get() 
	      System.out.println(Thread.currentThread().getName() +" Received -"+ randomNumberTasks[i].get()); 
	  
	      // This method blocks till the result is obtained 
	      // The get method can throw checked exceptions 
	      // like when it is interrupted. This is the reason 
	      // for adding the throws clause to main 
	    } 
	}
}





