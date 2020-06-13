package com.group.java8.test.lambda;

public class MathOperationExample {
	
	interface MathOperation {
		int operation(int a, int b);
	}
	
	interface MyGeneric<T> {
		T compute(T t);
	}

	public static void main(String[] args) {	
		
		MathOperation add = (a,b) -> (a+b);
		MathOperation sub = (a,b) -> {return(a-b);};	
		
		System.out.println(sub.operation(10, 5));
		System.out.println(add.operation(10, 5));
		
		MyGeneric<String> generic = (str) -> { return str;};
		System.out.println(generic.compute("THIS IS GNERIC"));
		

	}
}
