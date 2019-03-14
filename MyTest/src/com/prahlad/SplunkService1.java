package com.prahlad;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.splunk.CollectionArgs;
import com.splunk.Job;
import com.splunk.JobArgs;
import com.splunk.ResultsReaderXml;
import com.splunk.Service;
import com.splunk.ServiceArgs;

public class SplunkService1 {
	private static String query = "search index=\"msanniboyina_*\" sourcetype=\"ciphercloud_dlp\" | fields _raw | sort 0 _indextime";
	private static final String TIMESTAMP_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";
	public static void main(String[] args) {
		Service service = connect();
		long start = System.currentTimeMillis();
		getResults(service,1521437101000L,1521452302732L);
		long end = System.currentTimeMillis();
		System.out.println("Time Taken: " + (end -start) + " mill seconds");
	}
	private static void getResults(Service service, long indexEarliest, long indexLatest) {
		JobArgs jobArgs = new JobArgs();
		jobArgs.setExecutionMode(JobArgs.ExecutionMode.NORMAL);
		long then = indexLatest;
		long before3Days = getMinus3DaystartTime(indexEarliest);
		System.out.println(converttoUTCString(before3Days));
		jobArgs.put("earliest_time", converttoUTCString(before3Days));
		jobArgs.put("latest_time", converttoUTCString(then));
		jobArgs.put("index_earliest", converttoUTCString(indexEarliest));
		jobArgs.put("index_latest", converttoUTCString(indexLatest));
		
		Job job = service.getJobs().create(query,jobArgs);
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
		int resultCount = job.getResultCount();
		int offset =0;
		int count = 1000;
		try{
			while(offset<resultCount){
				CollectionArgs outputArgs = new CollectionArgs();
			    outputArgs.setCount(count);
			    outputArgs.setOffset(offset);
			    
			 // Get the search results and use the built-in XML parser to display them
				InputStream results =  job.getResults(outputArgs);
				ResultsReaderXml resultsReader = new ResultsReaderXml(results);
				HashMap<String, String> event;
				while ((event = resultsReader.getNextEvent()) != null) {
			        System.out.println("\n***** RESULT  *****\n");
					System.out.println(event.get("_indextime")+event.get("_subsecond").replace(".", "")+" ::"+event.get("_raw"));
			    }
			    resultsReader.close();
			   
			    // Increase the offset to get the next set of results
			    offset = offset + count;
			};
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
		}
	}
	public static String converttoUTCString(long millis) {
		SimpleDateFormat sdf = new SimpleDateFormat(TIMESTAMP_FORMAT);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        return sdf.format(new Date(millis));
	}
	private static Service connect() {
		// Preparing splunk arguments
		ServiceArgs args = new ServiceArgs();
		args.setUsername("msanniboyina_user");
		args.setPassword("CipherCloud@123");
		args.setApp("CC4OBS_msanniboyina");
		args.setHost("localhost");
		args.setPort(8089);

		// Splunk connection
		Service service = Service.connect(args);
		return service;
	}
	/*
	 * 
	 */
	public static long getMinus3DaystartTime(long timeInMillis) {
		DateTime dt = new DateTime(timeInMillis,DateTimeZone.UTC);
		DateTime dtNext = dt.withTimeAtStartOfDay().minusDays(3);
		return dtNext.getMillis();
		
	}
}
