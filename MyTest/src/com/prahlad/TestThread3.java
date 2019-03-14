package com.prahlad;

public class TestThread3 {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new A1(),"one");
		Thread t2 = new Thread(new A2(),"two");
		Thread t3 = new Thread(new A3(),"three");
		Thread t4 = new Thread(new A4(),"four");
		
		t4.start();
		t4.join();
		t3.start();
		t3.join();
		t2.start();
		t2.join();
		t1.start();
		t1.join();
	}
}
class A1 implements Runnable{
	@Override
	public void run(){
		System.out.println(Thread.currentThread().getName()+"---> job starting");		
	}
}
class A2 implements Runnable{
	@Override
	public void run(){
		System.out.println(Thread.currentThread().getName()+"---> job starting");		
	}
}
class A3 implements Runnable{
	@Override
	public void run(){
		System.out.println(Thread.currentThread().getName()+"---> job starting");		
	}
}
class A4 implements Runnable{
	@Override
	public void run(){
		System.out.println(Thread.currentThread().getName()+"---> job starting");		
	}
}