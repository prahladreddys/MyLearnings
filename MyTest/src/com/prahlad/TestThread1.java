package com.prahlad;

public class TestThread1 {
	//Object obj = new Object();
	public static void main(String[] args) throws InterruptedException {
		Object obj = new Object();
		N1 n1= new N1(obj);
		N2 n2= new N2(obj);
		Thread t1 = new Thread(n1);
		Thread t2 = new Thread(n2);
		
		
		t2.start();
		t1.start();
		t1.join();
		t2.join();
		//notifyAll();
		//notify();
		
	}
	
	
}
class N1 implements Runnable{
	Object obj;
	N1(Object obj){
		this.obj = obj;
	}
	@Override
	public void run() {
		synchronized (obj) {
			for(int i=2;i<10;i++){
				System.out.println(i);
				i++;
				obj.notify();
				try {
					obj.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//obj.notify();
	//	notifyAll();
	}
	
}
class N2 implements Runnable{
	Object obj;
	N2(Object obj){
		this.obj = obj;
	}
	@Override
	public void run() {
		synchronized (obj) {
			for(int i=1;i<10;i++){
				System.out.println(i);
				i++;
				obj.notify();
				try {
					obj.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		obj.notify();
	}
	
}