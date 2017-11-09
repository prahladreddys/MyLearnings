package com.prahlad.designpatterns;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestSingleTon {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(5);
		for(int i=0;i<5;i++)
			service.execute(new MyThread());
		System.out.println("Done");
		Thread.sleep(10000);
		service.shutdown();
		System.out.println("Exit");
	}

}
class MyThread implements Runnable{

	@Override
	public void run() {
		SingleTon.getInstance().meth();
	}
	
}