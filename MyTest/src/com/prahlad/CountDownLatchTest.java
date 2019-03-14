/**
 * 
 */
package com.prahlad;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Prahlad created on 03-Jun-2017
 *
 */
public class CountDownLatchTest {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Random r = new Random();
		int N = r.nextInt(10);
		System.out.println("N Value : "+ N);
//		Driver d = new Driver();
//		d.main(N);
		Driver1 d1 = new Driver1();
		d1.main(N);
	}

}

class Driver1 {
	void main(int N){
		CountDownLatch latch = new CountDownLatch(1);
		ExecutorService exec = Executors.newFixedThreadPool(N+1);
		for(int i=0;i<N+1;i++){
			exec.execute(new Worker1(latch));
		}
		doWorkOnLock();
		latch.countDown();
		exec.shutdown();
	}

	private void doWorkOnLock() {
		System.out.println("Doing work on holding count down latch lock on created threads ...");
	}
}
class Worker1 implements Runnable{
	private CountDownLatch latch;
	Worker1(CountDownLatch latch){
		this.latch = latch;
	}
	@Override
	public void run() {
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doSomething();		
	}

	private void doSomething() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done something:: " + Thread.currentThread().getName());
	}
	
}


class Driver{
	void main(int N) throws InterruptedException{
		
		CountDownLatch startSignal = new CountDownLatch(1);
		CountDownLatch stopSignal = new CountDownLatch(N+1);
		for(int i=0;i<N+1;i++){
			new Thread(new Worker(startSignal,stopSignal),""+i).start();
		}
		doSomething();
		startSignal.countDown();
		doSomeThingElse();
		stopSignal.await();
	}

	private void doSomeThingElse() {
		System.out.println("Doing something else...");
	}

	private void doSomething() {
		System.out.println("Do something...");
	}
}
class Worker implements Runnable{
	private CountDownLatch startSignal;
	private CountDownLatch stopSignal;
	public Worker(CountDownLatch startSignal, CountDownLatch stopSignal){
		this.startSignal = startSignal;
		this.stopSignal = stopSignal;
	}

	@Override
	public void run() {
		try{
			startSignal.await();
			doWork();
			stopSignal.countDown();
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	private void doWork() {		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Working on thread : "+ Thread.currentThread().getName());
	}
	
}


