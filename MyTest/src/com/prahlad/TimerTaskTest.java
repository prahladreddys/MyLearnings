package com.prahlad;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskTest {

	public static void main(String[] args) {
		Timer time = new Timer();
		time.scheduleAtFixedRate(new SayHello(), 0 , 2*1000);
	}
	
}
class SayHello extends TimerTask {

	@Override
	public void run() {
		System.out.println("Hi .. Hello ... ");
		completedTask();
		System.out.println("Done");
	}

	private void completedTask() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}