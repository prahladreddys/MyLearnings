package com.prahlad;

public class TestThread2 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Start");
		Thread even = new Thread(new PrintEven());
		Thread odd = new Thread(new PrintOdd());
		odd.start();
		even.start();
		try {
            odd.join();
            even.join();
            System.out.println("Main thread exited");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		System.out.println("end");
	}
}
class PrintEven implements Runnable{
	@Override
	public void run(){
		synchronized (CommonUtil.mLock) {
		for(int i=0;i<10;i+=2){			
			System.out.println(i);
			CommonUtil.mLock.notify();
            try {
                CommonUtil.mLock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

		}
		CommonUtil.mLock.notify();
		}
	}
	
}
class PrintOdd implements Runnable{
	@Override
	public void run(){
		synchronized (CommonUtil.mLock) {
			for(int i =1;i<10;i+=2){
				System.out.println(i);
				CommonUtil.mLock.notify();
                try {
                    CommonUtil.mLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
			}
			CommonUtil.mLock.notify();
		}
		
	}
}
class CommonUtil {
	static final Object mLock = new Object();
}