package com.prahlad.intv;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTest {
	public static void main(String[] args) {
		Runnable r1 = new Task("R1");
		Runnable r2 = new Task("R2");
		Runnable r3 = new Task("R3");
		Runnable r4 = new Task("R4");
		Runnable r5 = new Task("R5");
		
		ExecutorService service = Executors.newFixedThreadPool(3);
		service.execute(r1);service.execute(r2);service.execute(r3);service.execute(r4);service.execute(r5);
		
		service.shutdown();

	}
}
class Task implements Runnable{
	String s;
	Task(String s){
		this.s = s;
	}
	@Override
	public void run() {
		try {
			for (int i = 0; i <= 5; i++) {
				if (i == 0) {
					Date d = new Date();
					SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
					System.out.println("Initialization Time for" + " task name - " + s + " = " + ft.format(d));
					// prints the initialization time for every task
				} else {
					Date d = new Date();
					SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
					System.out.println("Executing Time for task name - " + s + " = " + ft.format(d));
					// prints the execution time for every task
				}
				Thread.sleep(1000);
			}
			System.out.println(s + " complete");
		}

		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}