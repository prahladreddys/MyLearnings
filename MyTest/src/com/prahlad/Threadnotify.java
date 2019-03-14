package com.prahlad;

public class Threadnotify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		thread1 tt = new thread1();
		Thread t1 = new Thread(tt);
		thread2 ttt = new thread2();
		Thread t2 = new Thread(ttt);
		thread3 t3 = new thread3();
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t2.start();
		
		
		t3.start();
	}

}
class thread1 implements Runnable{

	@Override
	public void run() {
			System.out.println("Thread 1 is running..");
			for(int i=0;i<=5;i++){
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("I: "+i);
			}
	}
	
}
class thread2 implements Runnable{
	@Override
	public void run(){
		System.out.println("Thread 2 running..");
		for(int j=5;j>=0;j--){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("J: "+j);
		}
	}
}
class thread3 extends Thread{
	@Override
	public void run(){
		System.out.println("thread 3 running..");
	}
}