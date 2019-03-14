package com.prahlad;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThread {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		T1 t1 = new T1();
		t1.start();
		T2 t2 = new T2(1);
		Thread t = new Thread(t2);
		t.start();
		
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for(int i =0;i<10;i++){
			Runnable run = new T2(i);
			exec.execute(run);
		}
		Thread.currentThread().join();
	}

}
class T1 extends Thread{
	@Override
	public void run(){
		System.out.println("Running t1 thread");
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(1);
	}
}
class T2 implements Runnable{
	private int i;
	T2(int i){
		this.i = i;
	}
	@Override
	public void run() {
		System.out.println("running t2 thread no :"+ this.i);
		System.out.println(Thread.currentThread().getName() + "\t"+ Thread.currentThread().hashCode() + "\t"+ Thread.currentThread().getPriority());
		
		
	}
	
}
