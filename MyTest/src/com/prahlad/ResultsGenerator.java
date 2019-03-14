package com.prahlad;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;

import com.splunk.HttpService;
import com.splunk.Job;
import com.splunk.JobArgs;
import com.splunk.SSLSecurityProtocol;
import com.splunk.Service;
import com.splunk.ServiceArgs;


public class ResultsGenerator {

public static final int MAX_RESULTS_SIZE = 10000;
private static final String TIMESTAMP_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";
	public static Service service = null;
	public static long getNextDaystartTime(long timeInMillis) {
		DateTime dt = new DateTime(timeInMillis);
		DateTime dtNext = dt.withTimeAtStartOfDay().plusDays(1);
		return dtNext.getMillis();
		
	}
	public static long getMinus3DaystartTime(long timeInMillis) {
		DateTime dt = new DateTime(timeInMillis);
		DateTime dtNext = dt.withTimeAtStartOfDay().minusDays(3);
		return dtNext.getMillis();
		
	}
	
	public static long getNextHourStartTime(long timeInMillis) {
		DateTime dt = new DateTime(timeInMillis);
		DateTime dtNext = dt.withTimeAtStartOfDay().plusHours(dt.getHourOfDay()+1);
		return dtNext.getMillis();
	}
	
	public static long add10mins(long timeInMillis) {
		DateTime dt = new DateTime(timeInMillis);
		DateTime dtNext = dt.plusMinutes(10);
		return dtNext.getMillis();
	}
	
	public static boolean isSameDate(long time1, long time2) {
			DateTime dt1 = new DateTime(time1);
			DateTime dt2 = new DateTime(time2);
		
		if(dt1.getDayOfMonth() == dt2.getDayOfMonth() && dt1.getMonthOfYear() == dt2.getMonthOfYear() && dt1.getYear() == dt2.getYear())
			return true;
		return false;
	}
	
	public int getTotalEventsCount(long indexEarliest, long indexLatest) {
		//String query = "search index=\"ford7_*\" sourcetype=\"ciphercloud_dlp\" | fields _raw | stats count as Total";
		String query = "search index=\"msanniboyina_*\" sourcetype=\"ciphercloud_dlp\" | fields _raw | stats count as Total";
		JobArgs jobArgs = new JobArgs();
		jobArgs.setExecutionMode(JobArgs.ExecutionMode.NORMAL);
		// Set the parameters for the search:
		
		long then = indexLatest;
		long before3Days = getMinus3DaystartTime(indexLatest);
		
		jobArgs.put("earliest_time", converttoUTCString(before3Days));
		jobArgs.put("latest_time", converttoUTCString(then));
		jobArgs.put("index_earliest", converttoUTCString(indexEarliest));
		jobArgs.put("index_latest", converttoUTCString(indexLatest));
		System.out.println(converttoUTCString(before3Days)+"\t"+converttoUTCString(indexLatest));
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
		//int resultCount = job.getResultCount();
		return job.getEventCount();
	}
	
	public void fetchResults(long startTime, long endTime) throws IOException {
		//fetch the results for the give time range and update the updateSuccessful runtime. 
		System.out.println("Fetching events between "+new DateTime(startTime)+" and "+new DateTime(endTime));
		SplunkExport.getExportResults(service, startTime, endTime);
	}
	
	public void generateResults(long  startTime, long endTime) throws IOException {
		long endIntermediateTime = 0L;
		while(startTime < endTime){
			endIntermediateTime = getNextDaystartTime(startTime);
			
			if(endIntermediateTime > endTime){
				endIntermediateTime = endTime;
			}
			long nextDayStart = endIntermediateTime ;
			int daysResultSize = getTotalEventsCount(startTime, endIntermediateTime);
			
			if(daysResultSize > MAX_RESULTS_SIZE) { // the result was huge for the day. Try generating results for the next hour.
				
				while (startTime < nextDayStart) {
				endIntermediateTime = getNextHourStartTime(startTime);	
				if(endIntermediateTime > nextDayStart) {
					endIntermediateTime = nextDayStart;
				}
				long endHourTime = endIntermediateTime;
				int hourResultSize = getTotalEventsCount(startTime, endHourTime);
				
				if(hourResultSize > MAX_RESULTS_SIZE) { // the result was huge for the current hour window. Try generating results for the next 10 minutes.
					
					while(startTime < endHourTime){ //runs from now till the start of next hour.
						endIntermediateTime = add10mins(startTime);
						if(endIntermediateTime > endHourTime){
							endIntermediateTime = endHourTime;
						}
						fetchResults(startTime,endIntermediateTime);
						startTime = endIntermediateTime;
						
					}
					//now the outer loop will be executed. till now we have generated results from the startTime till the next hour of the startTime.
					//now the logic will repeat from next hour till the end of that day.
				}else {
					if(hourResultSize > 0)
						fetchResults(startTime, endIntermediateTime);
					startTime = endIntermediateTime;
				}
				startTime = endIntermediateTime;
				}
				
			} else {
				if(daysResultSize > 0)
					fetchResults(startTime,endIntermediateTime);
				startTime = endIntermediateTime;
			}
		}
		
	}
	
	private static void connect() throws InterruptedException, IOException {
		if (service == null) {
			// Preparing splunk arguments
			HttpService.setSslSecurityProtocol(SSLSecurityProtocol.TLSv1_2);
			ServiceArgs args = new ServiceArgs();
			args.setUsername("admin");
			args.setPassword("CipherCloud@123");
			args.setHost("localhost");
			args.setPort(8089);

			// Splunk connection
			service = Service.connect(args);
		}
	}
	
	public static String converttoUTCString(long millis) {
		SimpleDateFormat sdf = new SimpleDateFormat(TIMESTAMP_FORMAT);
        //sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        return sdf.format(new Date(millis));
	}
	public static void main(String[] args) throws IOException {
		try{
		connect();
		}catch(Exception e){
			
		}
		ResultsGenerator rg = new ResultsGenerator();
		rg.generateResults(1520983800000L, 1520987420000L);
		//rg.generateResults(15194350520000L, 1519575420000L);
		//rg.generateResults(1519151400000L, 1520534960695L);
	}
}
