package com.prahlad;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for(int i=0;i<10;i++){
			Runnable worker = new WorkerThread(""+i);
			exec.execute(worker);
		}
		exec.shutdown();
		while(!exec.isTerminated()){}
		
		System.out.println("Completed all threads");
	}

}
class WorkerThread implements Runnable{
	private String message;
	public WorkerThread(String s){
		this.message = s;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" (Start) message : "+message);
		processMessage();
		System.out.println(Thread.currentThread().getName()+ " (End)");
	}
	private void processMessage() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}