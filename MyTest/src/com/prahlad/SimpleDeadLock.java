package com.prahlad;

public class SimpleDeadLock {
	public static Object l1 = new Object();
	public static Object l2 = new Object();
	private int index;

	public static void main(String[] args) {
		System.out.println("Creating a dead lock");
		Thread t1 = new Thread1();
		Thread t2 = new Thread2();
		t1.start();
		t2.start();
	}

	static class Thread1 extends Thread {
		public void run() {
			synchronized (l1) {
				System.out.println("Thread1 : accquired lock on l1");
				try {
					Thread.sleep(10);
				} catch (Exception e) {
				}
				System.out.println("Thread 1 waiting for lock l2");
				synchronized (l2) {
					System.out.println("Thread 2 holding l1 and lock2");

				}
			}
		}
	}

	static class Thread2 extends Thread {
		public void run() {
			synchronized (l2) {
				System.out.println("Thread 2: Holding lock 2...");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}
				System.out.println("Thread 2: Waiting for lock 1...");
				synchronized (l1) {
					System.out.println("Thread 2: Holding lock 2 & 1...");
				}

			}
		}

	}
}
