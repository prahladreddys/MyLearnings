package com.prahlad;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class SchedularTask extends TimerTask {
	private final static int fONE_DAY = 0;
	private final static int fFOUR_AM = 8;
	private final static int fZERO_MINUTES = 0;
	// expressed in milliseconds
	private final static long fONCE_PER_DAY = 1000 * 60 * 60 * 24;

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Writing Schedular task using TimerTask in util package");
		Timer timer = new Timer();
		getTomorrowMorning4am();
		SchedularTask schedular = new SchedularTask();
		timer.scheduleAtFixedRate(schedular, getTomorrowMorning4am(), fONCE_PER_DAY);

		// for demo only.
		for (int i = 0; i <= 5; i++) {
			System.out.println(new Date());
			System.out.println("Execution in Main Thread...." + i);
			Thread.sleep(2000);
			if (i == 5) {
				//System.out.println("Application Terminates");
				//System.exit(0);
			}
		}
	}

	private static Date getTomorrowMorning4am() {
		Calendar tomorrow = new GregorianCalendar();
		tomorrow.add(Calendar.DATE, fONE_DAY);
		Calendar result = new GregorianCalendar(tomorrow.get(Calendar.YEAR), tomorrow.get(Calendar.MONTH),
				tomorrow.get(Calendar.DATE), fFOUR_AM,5, fZERO_MINUTES);
		System.out.println(result.getTime());
		return result.getTime();
	}

	Date now;

	@Override
	public void run() {
		now = new Date();
		System.out.println("Time is : " + now);
	}

}
