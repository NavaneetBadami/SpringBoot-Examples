package com.group.java8.test.lambda;

@FunctionalInterface
interface Printing {
	public String printName(String name);
}

public class SingleParam {
	
	// With Lambda Expresion
	public static void main(String[] args) {
		
		// without body  
		Printing p = (nam) -> ("Name: " + nam);
		System.out.println(p.printName("Navaneet"));
		
		// body  
		Printing p1 = (nam) -> {
			return "Name: " + nam;
		};
		System.out.println(p1.printName("Navaneet-1"));
		
		Printing p2 = (name) -> {
			return "Name: " + name;
		};
		System.out.println(p2.printName("Navaneet-2"));
	}	
}
