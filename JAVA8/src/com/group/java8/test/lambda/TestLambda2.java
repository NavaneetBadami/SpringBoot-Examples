package com.group.java8.test.lambda;

interface TestLambda01 {
	default void draw() {
		System.out.println("TestLambda01");
	}
}

interface TestLambda02 {
	default void draw() {
		System.out.println("TestLambda02");
	}
}


public class TestLambda2 implements TestLambda01, TestLambda02 {
	
	@Override
	public void draw() {
		TestLambda01.super.draw();
		TestLambda02.super.draw();
	}
	
	public static void main(String[] args) {

		TestLambda2 allLam = new TestLambda2();
		allLam.draw();

	}

}
