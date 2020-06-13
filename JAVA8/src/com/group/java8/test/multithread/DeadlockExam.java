package com.group.java8.test.multithread;

public class DeadlockExam {

	String s1 = "Dead";
	String s2 = "Lock";

	Thread t1 =  new Thread ("T1") {
		public void run() {
			while(true){
				synchronized(s1){
					synchronized(s2){
						System.out.println(s1 + s2);
					}
				}
			}
		}
	};
	
	Thread t2 =  new Thread ("T2") {
		public void run() {
			while(true){
				synchronized(s2){
					synchronized(s1){
						System.out.println(s1 + s2);
					}
				}
			}
		}
	};
	
	public static void main(String[] args) {
		DeadlockExam deadlockExam = new DeadlockExam();
		deadlockExam.t1.start();
		deadlockExam.t2.start();
		
	}
}
