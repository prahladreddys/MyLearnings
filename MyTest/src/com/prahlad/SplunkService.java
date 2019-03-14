package com.prahlad;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;

import com.splunk.CollectionArgs;
import com.splunk.Event;
import com.splunk.HttpException;
import com.splunk.Job;
import com.splunk.JobArgs;
import com.splunk.JobResultsArgs;
import com.splunk.ResultsReaderXml;
import com.splunk.Service;
import com.splunk.ServiceArgs;

public class SplunkService {
	public static void main(String[] args) throws InterruptedException, IOException {
		connect();
	}

	private static void connect() throws InterruptedException, IOException {
		// Preparing splunk arguments
		ServiceArgs args = new ServiceArgs();
		args.setUsername("admin");
		args.setPassword("CipherCloud@123");
		args.setHost("localhost");
		args.setPort(8089);

		// Splunk connection
		Service service = Service.connect(args);
//		System.out.println("Connected : " + service.version);

//		// Splunk Users
//		for (User user : service.getUsers().values())
//			System.out.println(user.getName());
//
//		// Splunk apps
//		for (Application app : service.getApplications().values())
//			System.out.println("App Name: \t" + app.getName());
		
		String query = "search index=\"msanniboyina_*\" sourcetype=\"ciphercloud_dlp\" | fields _raw ";
		JobArgs jobargs = new JobArgs();
		jobargs.setExecutionMode(JobArgs.ExecutionMode.NORMAL);
		// Set the parameters for the search:
		
		jobargs.put("earliest_time", "2018-02-01T12:00:00.000-07:00");
		jobargs.put("latest_time", "2018-02-02T12:00:00.000-07:00");
		service.logout();
		Job job = null;
		try{
			System.out.println(service.getToken());
			if(StringUtils.isBlank(service.getToken())){
				service = Service.connect(args);
			}
		} catch(HttpException e){
			System.out.println(e.getStatus());
			service = Service.connect(args);			
		}
		job = service.getJobs().create(query,jobargs);
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
//		int resultCount = job.getResultCount();
//		int offset =0;
//		int count = 1000;
//		try(BufferedWriter bw = new BufferedWriter(new FileWriter("D:/spooldir/splunk/0803.log"))){
//			while(offset<resultCount){
//				CollectionArgs outputArgs = new CollectionArgs();
//			    outputArgs.setCount(count);
//			    outputArgs.setOffset(offset);
//			    
//			 // Get the search results and use the built-in XML parser to display them
//				InputStream results =  job.getResults(outputArgs);
//				ResultsReaderXml resultsReader = new ResultsReaderXml(results);
//				HashMap<String, String> event;
//				while ((event = resultsReader.getNextEvent()) != null) {
//			        System.out.println("\n***** RESULT  *****\n");
//					for (String key: event.keySet())
//				        System.out.println("   " + key + ":  " + event.get(key));
//			        System.out.println();
//			    }
//			    resultsReader.close();
//			   
//			    // Increase the offset to get the next set of results
//			    offset = offset + count;
//			};
//		} 
		
		
		
        
//		// Get the search results and use the built-in XML parser to display them
//		InputStream resultsNormalSearch =  job.getResults(jobRes);
//		
//		ResultsReaderXml resultsReaderNormalSearch;
//		BufferedWriter bw = null;
//		try {
//		    resultsReaderNormalSearch = new ResultsReaderXml(resultsNormalSearch);
//		    bw = new BufferedWriter(new FileWriter("D:/spooldir/splunk/122.txt"));
//		    Event event;
//		    while ((event = resultsReaderNormalSearch.getNextEvent()) != null) {
//		    	bw.write(event.get("_raw"));
//		    	bw.newLine();
//		    }
//		} catch (Exception e) {
//		    e.printStackTrace();
//		} finally{
//			IOUtils.closeQuietly(bw);
//		}
//		// Get properties of the completed job
//		System.out.println("\nSearch job properties\n---------------------");
//		System.out.println("Search job ID:         " + job.getSid());
//		System.out.println("The number of events:  " + job.getEventCount());
//		System.out.println("The number of results: " + job.getResultCount());
//		System.out.println("Search duration:       " + job.getRunDuration() + " seconds");
//		System.out.println("This job expires in:   " + job.getTtl() + " seconds");
//		Args outputArgs = new Args();
//		outputArgs.put("output_mode", "json_rows");
//		outputArgs.put("count", "100");
//		outputArgs.put("offset", "100");// all limit will be controlled on the
//		// blocking call to make sure the job is ready
//		while (!result.isReady()) {
//			Thread.sleep(1000);
//			System.out.println("Waiting");
//		}
//		InputStream data = result.getResultsPreview(outputArgs);
//		System.out.println(inputStreamToJSON(data));
	}
	
	private static String inputStreamToJSON(InputStream is) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			if (is != null) {
				HashMap objRecs = objMapper.readValue(is, HashMap.class);
				if (objRecs != null) {
					String results = objMapper.writeValueAsString(objRecs);
					return results;
				}
			}
		} catch (IOException ev) {
			// This exception shows when empty InputStream from Splunk data;
			// when empty data is given, keep continue
		} catch (Exception ev) {
			// Other exception might need to get logged
		}
		return "";
	}
}
