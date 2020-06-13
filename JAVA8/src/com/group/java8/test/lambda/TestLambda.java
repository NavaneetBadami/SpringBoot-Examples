package com.group.java8.test.lambda;

@FunctionalInterface
interface Drawable {
	
	 // default method1  
	default String say1(){  
		return "Hello, this is default method1";  
	}  
	// default method2  
	default String say2(){  
		return "Hello, this is default method2";  
	}  
	// static method1 
	public static int say3() {
		return 10;
	}
	
	// static method2  
	public static int say4() {
		return 20;
	}
	
	 // Abstract method  
	public void draw();
}

class x implements Drawable {
	public String say2(){  
		return "Hello, this is default method2 sub";  
	}  
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}





public class TestLambda {
	
	//without lambda, Drawable implementation using anonymous class  
	/*public static void main(String[] args) {
		int width = 10;
		
		Drawable d = new Drawable() {
			@Override
			public void draw() {
				System.out.println("Drawing: "+ width);

			}
		}; 
		d.draw();
	}*/
	
	// With Lambda Expresion
	public static void main(String[] args) {
		
		int width = 10;
		Drawable d = () -> {
			System.out.println("Drawing: "+ width);
		};
		
		d.draw();
		System.out.println(d.say1());
		System.out.println(d.say2());
		System.out.println(Drawable.say3());
		System.out.println(Drawable.say4());
		
		Drawable d2 = () -> {
			System.out.println("Drawing: "+ width);
		};
		d2 = new x();
		
		d.say2();
		
	}
}
