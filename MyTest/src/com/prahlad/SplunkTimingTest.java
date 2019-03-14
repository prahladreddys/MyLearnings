package com.prahlad;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.splunk.HttpService;
import com.splunk.Job;
import com.splunk.JobArgs;
import com.splunk.SSLSecurityProtocol;
import com.splunk.Service;
import com.splunk.ServiceArgs;


class TWorker implements Runnable {
	Service service;
	
	String startTime;
	String endTime;
	
	
	public TWorker(Service service, String startTime, String endTime) {
		super();
		this.service = service;
		this.startTime = startTime;
		this.endTime = endTime;
	}


	public Service getService() {
		return service;
	}


	public void setService(Service service) {
		this.service = service;
	}


	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public String getEndTime() {
		return endTime;
	}


	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	public void run() {
		
		try {
			System.out.println("Running: "+ getStartTime() + "\t To \t"+getEndTime());
//			SplunkExport.getExportResults(service, getStartTime(), getEndTime());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

public class SplunkTimingTest {
	
	public static Service getService() {
		HttpService.setSslSecurityProtocol(SSLSecurityProtocol.TLSv1_2);
		ServiceArgs args = new ServiceArgs();
		args.setUsername("admin");
		args.setPassword("CipherCloud@123");
		args.setHost("172.16.25.153");
		args.setPort(8089);

		// Splunk connection
		Service service = Service.connect(args);
		return service;
	}
	
	/*public static void runQuery(Service service, String startTime , String endTime) {
		
		String query = "search index=\"msanniboyina_*\" sourcetype=\"ciphercloud_dlp\" | fields _raw | stats count as Total";
		JobArgs jobargs = new JobArgs();
		jobargs.setExecutionMode(JobArgs.ExecutionMode.NORMAL);
		// Set the parameters for the search:
		jobargs.put("earliest_time", startTime);
		jobargs.put("latest_time", endTime);
		
		Job job = service.getJobs().create(query,jobargs);
		// Wait for the search to finish
		while (!job.isDone()) {
		    try {
		        Thread.sleep(500);
		    } catch (InterruptedException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		}
		System.out.println("Total no of events: "+job.getEventCount());
	}*/
	
	public static void testSingleton() {
		final Service service = getService();	
		long start = System.currentTimeMillis();
		ExecutorService executor = Executors.newFixedThreadPool(10);
		String timePrefixWithoutYear = "-01-01T00:00:00.000+05:30";
        for (int i = 0; i < 11; i++) {
        	String startTime = (2008 + i)+timePrefixWithoutYear;
        	String endTime = (2008+i+1)+timePrefixWithoutYear;
            Runnable worker = new TWorker(service,startTime,endTime);
            executor.execute(worker);
          }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
		
		long end = System.currentTimeMillis();
		
		System.out.println("total time taken :" + (end-start)/1000 +" secs");
		
		
	}
	public static void testPooledConnection () {
		Service service[] = new Service[10];
		for(int i =0;i<10;i++) {
			service[i] = getService();
		}
		long start = System.currentTimeMillis();
		ExecutorService executor = Executors.newFixedThreadPool(10);
		String timePrefixWithoutYear = "-01-01T00:00:00.000+05:30";
        for (int i = 0; i < 10; i++) {
        	String startTime = (2008 + i)+timePrefixWithoutYear;
        	String endTime = (2008+i+1)+timePrefixWithoutYear;
        	
            Runnable worker = new TWorker(service[i],startTime,endTime);
            executor.execute(worker);
          }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
		
		long end = System.currentTimeMillis();
		
		System.out.println("total time taken :" + (end-start)/1000 +" secs");
	}
	public static void main(String[] args) {
		System.out.println("Singleton test");
		testSingleton();
		System.out.println("Testing with pool");
		testPooledConnection();

	}

}
