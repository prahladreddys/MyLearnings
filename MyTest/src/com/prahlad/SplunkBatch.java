package com.prahlad;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import com.splunk.Job;
import com.splunk.JobArgs;
import com.splunk.JobResultsPreviewArgs;
import com.splunk.ResultsReaderXml;
import com.splunk.Service;
import com.splunk.ServiceArgs;

public class SplunkBatch {
	private static String query = "search index=ford7_* | fields _raw ";

	public static void main(String[] args) throws InterruptedException, IOException {
		Service service = connectToSplunk();
		queryBatching(service);
	}

	private static void queryBatching(Service service) throws InterruptedException, IOException {
		// Create an argument map for the job arguments:
		JobArgs jobArgs = new JobArgs();
		jobArgs.setExecutionMode(JobArgs.ExecutionMode.NORMAL);
		jobArgs.put("isBatchModeSearch", "true");
		// Create the job
		Job job = service.search(query, jobArgs);
		job.enablePreview();
		job.update();
		
		// Wait for the job to be ready
		while (!job.isDone()) {
		    Thread.sleep(500);
		}
		System.out.println("Results count"+job.getResultCount());
		// Display previews using the built-in XML parser 
		int countPreview=0;  // count the number of previews displayed
		int countBatch=0;    // count the number of times previews are retrieved
		while (job.isDone()) {
//			System.out.println("Waiting...");
//			Thread.sleep(5000);
		    JobResultsPreviewArgs previewargs = new JobResultsPreviewArgs();
		    previewargs.setCount(5000);  // Get 500 previews at a time
		    previewargs.setOutputMode(JobResultsPreviewArgs.OutputMode.XML);

		    InputStream results =  job.getResultsPreview(previewargs);
		    ResultsReaderXml resultsReader = new ResultsReaderXml(results);
		    HashMap<String, String> event;
		    while ((event = resultsReader.getNextEvent()) != null) {
		        System.out.println("BATCH " + countBatch + "\nPREVIEW " + countPreview++ + " ********");
		        //System.out.println(event.get("_raw"));
		    }
		    System.out.println("Batch: "+countBatch);
		    countBatch++;
		    resultsReader.close();
		}
		System.out.println("Job is done with " + job.getEventCount() + " results");
	}

	private static Service connectToSplunk() {
		// Preparing splunk arguments
		ServiceArgs args = new ServiceArgs();
		args.setUsername("admin");
		args.setPassword("CipherCloud@123");
		args.setHost("172.16.25.153");
		args.setPort(8089);

		// Splunk connection
		Service service = Service.connect(args);
		return service;
	}

}
