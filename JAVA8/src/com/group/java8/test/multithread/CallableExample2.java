package com.group.java8.test.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class FactorialCal implements Callable<Integer> {

	private Integer number;

	public FactorialCal(Integer number) {
		this.number = number;
	}

	@Override
	public Integer call() throws Exception {
		Integer result = 1;
		if((number == 0) || (number ==1)) {
			result = 1;
		}  else {
			for (int i = 1; i <= number; i++) {
				//System.out.println(result +"*"+ i);
				result *= i;
				TimeUnit.MILLISECONDS.sleep(1000);
			}
		}
		System.out.println("Result factorial for number - " + number + " -> " + result);
		return result;
	}

}


public class CallableExample2 {

	public static void main(String[] args) {
		
	//	ExecutorService executor = Executors.newFixedThreadPool(2);
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		
		List<Future<Integer>> resuFutures = new ArrayList<Future<Integer>>();
		
		Random random = new Random();
		
		for (int i = 0; i < 5; i++) {
			int number = random.nextInt(10);
			Future<Integer> future = executor.submit(new FactorialCal(number));
			resuFutures.add(future);
		}
		
		for (Future<Integer> future : resuFutures) {
			try {
				while (!future.isDone()) {
					TimeUnit.MILLISECONDS.sleep(500);
					System.out.println("ACTIVE COUNT ==== > "+ executor.getActiveCount());
					//System.out.println("inProgress " + future.isDone());
					//System.out.println("Future result is - " + " - " + future.get() + "; And Task done is " + future.isDone());
				}
				 System.out.println("Future result is - " + " - " + future.get() + "; And Task done is " + future.isDone());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		boolean flag = true;
		while(flag) {
			if(executor.getActiveCount() == 0) {
				flag = false;
			}
			System.out.println("ACTIVE COUNT ==== > "+ executor.getActiveCount());
		}
		executor.shutdown();
	}
}
