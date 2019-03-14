package com.prahlad;

import com.splunk.Job;
import com.splunk.JobArgs;
import com.splunk.Service;
import com.splunk.ServiceArgs;

public class SplunkPagination {
	private static String query = "search index=ford7_* | fields _raw| head 10 ";
	
	public static void main(String[] args) {
		Service service = connect();
		getResults(service);
	}

	private static void getResults(Service service) {
		JobArgs jobargs = new JobArgs();
		jobargs.setExecutionMode(JobArgs.ExecutionMode.NORMAL);
		// Set the parameters for the search:
		
		jobargs.put("earliest_time", "2018-02-21T12:00:00.000-07:00");
		jobargs.put("latest_time", "2018-02-27T12:00:00.000-07:00");
		
		
		Job job = service.getJobs().create(query,jobargs);
		
		// Wait for the search to finish
		while (!job.isDone()) {
		    try {
		    	System.out.println("Waiting...");
		        Thread.sleep(5000);
		    } catch (InterruptedException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		}
		System.out.println("Total no of events: "+job.getEventCount());
	}

	private static Service connect() {
		// Preparing splunk arguments
		ServiceArgs args = new ServiceArgs();
		args.setUsername("ford7_user");
		args.setPassword("CipherCloud@123");
		args.setHost("172.16.25.153");
		args.setPort(8089);

		// Splunk connection
		Service service = Service.connect(args);
		return service;
	}

}
