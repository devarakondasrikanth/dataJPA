package com.spring.io.srikanth.Lambda;

public class ThreadLambda {

	public static void main(String[] args) {
		// Using anonymous innerclass
		Runnable race1 = new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		};
		 
		// Using lambda expression
		Runnable race2 = () -> System.out.println(Thread.currentThread().getName());
		 
		// Run em!
		new Thread(race1).start();
		new Thread(race2).start();
		
		Thread t1 = new Thread(()->System.out.println(Thread.currentThread().getName()));
		t1.start();
	}

}
