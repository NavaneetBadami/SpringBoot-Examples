package com.group.java8.test.lambda;

import java.util.Arrays;
import java.util.List;

interface FunInteface  {
	
	int testAbstract(int a, int b) ;
}

public class Examples {
	
	interface fun {
		int operation(int x, int y);
	}
	
	interface fun2 {
		void say(String msg);
	}
			
	public static void main(String[] args) {
			
		FunInteface funInteface = (x, y) -> {
			System.out.println(" Multile ");
			int result = x * y;
			return result;
			};
		System.out.println(funInteface.testAbstract(50, 4));
		
		List<Integer> list = Arrays.asList(3,6,5,4,4,4);
		list.forEach(n -> System.out.println(n));
		
		System.out.println("Even numbers: ");
		list.forEach(n -> {if(n%2 ==0){System.out.print(n);}});
		
		System.out.println();
		fun f = (a,b) -> { return(a+b);};
		System.out.println(f.operation(44, 55));
		
		fun2 f2 =(s) -> {System.out.println(s);};
		f2.say("Hello !!");
		
	}	
}
