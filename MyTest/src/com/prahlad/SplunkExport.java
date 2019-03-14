package com.prahlad;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import org.apache.commons.compress.utils.IOUtils;
import org.joda.time.DateTime;

import com.splunk.JobExportArgs;
import com.splunk.ResultsReaderXml;
import com.splunk.Service;
import com.splunk.ServiceArgs;

public class SplunkExport {
	private static String query = "search index=\"msanniboyina_*\" sourcetype=\"ciphercloud_dlp\" | fields _raw";
//	private static String query = "search index=\"ford7_*\" sourcetype=\"ciphercloud_dlp\" | fields _raw | sort 0 _time";
	private static String folderName = "D:/spooldir/splunk/090318";
	private static final String TIMESTAMP_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";
	public static void main(String[] args) throws IOException {
		Service service = connect();
		long start = System.currentTimeMillis();
		getExportResults(service,1519480800000L,1519474652000L);
		long end = System.currentTimeMillis();
		System.out.println("Time Taken: " + (end -start) + " mill seconds");
	}
	public static long getMinus3DaystartTime(long timeInMillis) {
		DateTime dt = new DateTime(timeInMillis);
		DateTime dtNext = dt.withTimeAtStartOfDay().minusDays(3);
		return dtNext.getMillis();
		
	}
	public static void getExportResults(Service service,long indexEarliest,long indexLatest) throws IOException {
		// Set up a real-time export with a 30-second window
		JobExportArgs jobArgs = new JobExportArgs();
		jobArgs.setSearchMode(JobExportArgs.SearchMode.NORMAL);
		long then = indexLatest;
		long before3Days = getMinus3DaystartTime(indexLatest);
		jobArgs.put("earliest_time", converttoUTCString(before3Days));
		jobArgs.put("latest_time", converttoUTCString(then));
		jobArgs.put("index_earliest", converttoUTCString(indexEarliest));
		jobArgs.put("index_latest", converttoUTCString(indexLatest));
		
		jobArgs.setOutputMode(JobExportArgs.OutputMode.XML);

		
		int i =0;
		String fileName = getFileName(folderName);
		BufferedWriter bw = null;
		try(InputStream exportStream = service.export(query, jobArgs);){
			// Create the job
			ResultsReaderXml resultsReader = new ResultsReaderXml(exportStream);
			HashMap<String, String> event;			
			while ((event = resultsReader.getNextEvent()) != null) {
				if(i == 5000){
					System.out.println("Events writing completed for file: "+fileName);
					bw.flush();
					bw.close();					
					i = 0;
				}
				if(i ==0 ){
					fileName = getFileName(folderName);
					bw = new BufferedWriter(new FileWriter(fileName));
				}
				bw.write(event.get("_raw"));
				bw.newLine();
				i++;
				//				System.out.println("written: " + i++ + "###      "+ event.get("_time") + "\t" + event.get("_indextime"));
			}
			resultsReader.close();
		} finally{
			if (null != bw) {
				bw.flush();
				IOUtils.closeQuietly(bw);
			}
		}
	}
	public static String converttoUTCString(long millis) {
		SimpleDateFormat sdf = new SimpleDateFormat(TIMESTAMP_FORMAT);
        //sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
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
	/**
	 * @param folderName
	 * @return
	 */
	private static String getFileName(String folderName) {
		UUID uniqueId = UUID.randomUUID();
		String fileName = folderName.concat(File.separator).concat(uniqueId.toString()).concat(".log");
		return fileName;
	}
}
